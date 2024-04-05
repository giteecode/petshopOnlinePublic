
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 宠物寄养
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chongwujiyang")
public class ChongwujiyangController {
    private static final Logger logger = LoggerFactory.getLogger(ChongwujiyangController.class);

    private static final String TABLE_NAME = "chongwujiyang";

    @Autowired
    private ChongwujiyangService chongwujiyangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private ChatService chatService;//客服聊天
    @Autowired
    private ChongwujiyangYuyueService chongwujiyangYuyueService;//宠物寄养订单
    @Autowired
    private ChongwurizhiService chongwurizhiService;//寄存日志
    @Autowired
    private ChongwuyongpinService chongwuyongpinService;//商品
    @Autowired
    private ChongwuyongpinCollectionService chongwuyongpinCollectionService;//商品收藏
    @Autowired
    private ChongwuyongpinCommentbackService chongwuyongpinCommentbackService;//商品评价
    @Autowired
    private ChongwuyongpinOrderService chongwuyongpinOrderService;//商品订单
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("chongwujiyangDeleteStart",1);params.put("chongwujiyangDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = chongwujiyangService.queryPage(params);

        //字典表数据转换
        List<ChongwujiyangView> list =(List<ChongwujiyangView>)page.getList();
        for(ChongwujiyangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChongwujiyangEntity chongwujiyang = chongwujiyangService.selectById(id);
        if(chongwujiyang !=null){
            //entity转view
            ChongwujiyangView view = new ChongwujiyangView();
            BeanUtils.copyProperties( chongwujiyang , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChongwujiyangEntity chongwujiyang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chongwujiyang:{}",this.getClass().getName(),chongwujiyang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChongwujiyangEntity> queryWrapper = new EntityWrapper<ChongwujiyangEntity>()
            .eq("chongwujiyang_name", chongwujiyang.getChongwujiyangName())
            .eq("chongwujiyang_types", chongwujiyang.getChongwujiyangTypes())
            .eq("chongwujiyang_delete", chongwujiyang.getChongwujiyangDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChongwujiyangEntity chongwujiyangEntity = chongwujiyangService.selectOne(queryWrapper);
        if(chongwujiyangEntity==null){
            chongwujiyang.setChongwujiyangClicknum(1);
            chongwujiyang.setChongwujiyangDelete(1);
            chongwujiyang.setInsertTime(new Date());
            chongwujiyang.setCreateTime(new Date());
            chongwujiyangService.insert(chongwujiyang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChongwujiyangEntity chongwujiyang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chongwujiyang:{}",this.getClass().getName(),chongwujiyang.toString());
        ChongwujiyangEntity oldChongwujiyangEntity = chongwujiyangService.selectById(chongwujiyang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(chongwujiyang.getChongwujiyangPhoto()) || "null".equals(chongwujiyang.getChongwujiyangPhoto())){
                chongwujiyang.setChongwujiyangPhoto(null);
        }

            chongwujiyangService.updateById(chongwujiyang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChongwujiyangEntity> oldChongwujiyangList =chongwujiyangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ChongwujiyangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ChongwujiyangEntity chongwujiyangEntity = new ChongwujiyangEntity();
            chongwujiyangEntity.setId(id);
            chongwujiyangEntity.setChongwujiyangDelete(2);
            list.add(chongwujiyangEntity);
        }
        if(list != null && list.size() >0){
            chongwujiyangService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ChongwujiyangEntity> chongwujiyangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChongwujiyangEntity chongwujiyangEntity = new ChongwujiyangEntity();
//                            chongwujiyangEntity.setChongwujiyangName(data.get(0));                    //寄养服务名称 要改的
//                            chongwujiyangEntity.setChongwujiyangPhoto("");//详情和图片
//                            chongwujiyangEntity.setChongwujiyangTypes(Integer.valueOf(data.get(0)));   //寄养服务类型 要改的
//                            chongwujiyangEntity.setChongwujiyangNewMoney(data.get(0));                    //价格/天 要改的
//                            chongwujiyangEntity.setChongwujiyangClicknum(Integer.valueOf(data.get(0)));   //寄养服务热度 要改的
//                            chongwujiyangEntity.setChongwujiyangContent("");//详情和图片
//                            chongwujiyangEntity.setChongwujiyangDelete(1);//逻辑删除字段
//                            chongwujiyangEntity.setInsertTime(date);//时间
//                            chongwujiyangEntity.setCreateTime(date);//时间
                            chongwujiyangList.add(chongwujiyangEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        chongwujiyangService.insertBatch(chongwujiyangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = chongwujiyangService.queryPage(params);

        //字典表数据转换
        List<ChongwujiyangView> list =(List<ChongwujiyangView>)page.getList();
        for(ChongwujiyangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChongwujiyangEntity chongwujiyang = chongwujiyangService.selectById(id);
            if(chongwujiyang !=null){

                //点击数量加1
                chongwujiyang.setChongwujiyangClicknum(chongwujiyang.getChongwujiyangClicknum()+1);
                chongwujiyangService.updateById(chongwujiyang);

                //entity转view
                ChongwujiyangView view = new ChongwujiyangView();
                BeanUtils.copyProperties( chongwujiyang , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChongwujiyangEntity chongwujiyang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chongwujiyang:{}",this.getClass().getName(),chongwujiyang.toString());
        Wrapper<ChongwujiyangEntity> queryWrapper = new EntityWrapper<ChongwujiyangEntity>()
            .eq("chongwujiyang_name", chongwujiyang.getChongwujiyangName())
            .eq("chongwujiyang_types", chongwujiyang.getChongwujiyangTypes())
            .eq("chongwujiyang_clicknum", chongwujiyang.getChongwujiyangClicknum())
            .eq("chongwujiyang_delete", chongwujiyang.getChongwujiyangDelete())
//            .notIn("chongwujiyang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChongwujiyangEntity chongwujiyangEntity = chongwujiyangService.selectOne(queryWrapper);
        if(chongwujiyangEntity==null){
            chongwujiyang.setChongwujiyangDelete(1);
            chongwujiyang.setInsertTime(new Date());
            chongwujiyang.setCreateTime(new Date());
        chongwujiyangService.insert(chongwujiyang);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

