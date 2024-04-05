
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
 * 宠物寄养订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chongwujiyangYuyue")
public class ChongwujiyangYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(ChongwujiyangYuyueController.class);

    private static final String TABLE_NAME = "chongwujiyangYuyue";

    @Autowired
    private ChongwujiyangYuyueService chongwujiyangYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private ChatService chatService;//客服聊天
    @Autowired
    private ChongwujiyangService chongwujiyangService;//宠物寄养
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
        CommonUtil.checkMap(params);
        PageUtils page = chongwujiyangYuyueService.queryPage(params);

        //字典表数据转换
        List<ChongwujiyangYuyueView> list =(List<ChongwujiyangYuyueView>)page.getList();
        for(ChongwujiyangYuyueView c:list){
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
        ChongwujiyangYuyueEntity chongwujiyangYuyue = chongwujiyangYuyueService.selectById(id);
        if(chongwujiyangYuyue !=null){
            //entity转view
            ChongwujiyangYuyueView view = new ChongwujiyangYuyueView();
            BeanUtils.copyProperties( chongwujiyangYuyue , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(chongwujiyangYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 宠物寄养
            //级联表
            ChongwujiyangEntity chongwujiyang = chongwujiyangService.selectById(chongwujiyangYuyue.getChongwujiyangId());
            if(chongwujiyang != null){
            BeanUtils.copyProperties( chongwujiyang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setChongwujiyangId(chongwujiyang.getId());
            }
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
    public R save(@RequestBody ChongwujiyangYuyueEntity chongwujiyangYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chongwujiyangYuyue:{}",this.getClass().getName(),chongwujiyangYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            chongwujiyangYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ChongwujiyangYuyueEntity> queryWrapper = new EntityWrapper<ChongwujiyangYuyueEntity>()
            .eq("chongwujiyang_id", chongwujiyangYuyue.getChongwujiyangId())
            .eq("yonghu_id", chongwujiyangYuyue.getYonghuId())
            .eq("chongwujiyang_yuyue_name", chongwujiyangYuyue.getChongwujiyangYuyueName())
            .eq("chongwu_types", chongwujiyangYuyue.getChongwuTypes())
            .eq("chongwu_zhongliang", chongwujiyangYuyue.getChongwuZhongliang())
            .eq("chongwujiyang_yuyue_num", chongwujiyangYuyue.getChongwujiyangYuyueNum())
            .eq("shifou_types", chongwujiyangYuyue.getShifouTypes())
            .in("chongwujiyang_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChongwujiyangYuyueEntity chongwujiyangYuyueEntity = chongwujiyangYuyueService.selectOne(queryWrapper);
        if(chongwujiyangYuyueEntity==null){
            chongwujiyangYuyue.setChongwujiyangYuyueYesnoTypes(1);
            chongwujiyangYuyue.setInsertTime(new Date());
            chongwujiyangYuyue.setCreateTime(new Date());
            chongwujiyangYuyueService.insert(chongwujiyangYuyue);
            return R.ok();
        }else {
            if(chongwujiyangYuyueEntity.getChongwujiyangYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(chongwujiyangYuyueEntity.getChongwujiyangYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChongwujiyangYuyueEntity chongwujiyangYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chongwujiyangYuyue:{}",this.getClass().getName(),chongwujiyangYuyue.toString());
        ChongwujiyangYuyueEntity oldChongwujiyangYuyueEntity = chongwujiyangYuyueService.selectById(chongwujiyangYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            chongwujiyangYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            chongwujiyangYuyueService.updateById(chongwujiyangYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ChongwujiyangYuyueEntity chongwujiyangYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,chongwujiyangYuyueEntity:{}",this.getClass().getName(),chongwujiyangYuyueEntity.toString());

        ChongwujiyangYuyueEntity oldChongwujiyangYuyue = chongwujiyangYuyueService.selectById(chongwujiyangYuyueEntity.getId());//查询原先数据

        if(chongwujiyangYuyueEntity.getChongwujiyangYuyueYesnoTypes() == 2){//通过
            YonghuEntity yonghuEntity = yonghuService.selectById(oldChongwujiyangYuyue.getYonghuId());
            if(yonghuEntity.getNewMoney() < (oldChongwujiyangYuyue.getChongwujiyangYuyuePrice() * oldChongwujiyangYuyue.getChongwujiyangYuyueNum())){
                return R.error("用户余额不足！！！");
            }
            yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - (oldChongwujiyangYuyue.getChongwujiyangYuyuePrice() * oldChongwujiyangYuyue.getChongwujiyangYuyueNum()));
            yonghuService.updateById(yonghuEntity);
        }
        chongwujiyangYuyueService.updateById(chongwujiyangYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChongwujiyangYuyueEntity> oldChongwujiyangYuyueList =chongwujiyangYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        chongwujiyangYuyueService.deleteBatchIds(Arrays.asList(ids));

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
            List<ChongwujiyangYuyueEntity> chongwujiyangYuyueList = new ArrayList<>();//上传的东西
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
                            ChongwujiyangYuyueEntity chongwujiyangYuyueEntity = new ChongwujiyangYuyueEntity();
//                            chongwujiyangYuyueEntity.setChongwujiyangId(Integer.valueOf(data.get(0)));   //宠物寄养 要改的
//                            chongwujiyangYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            chongwujiyangYuyueEntity.setChongwujiyangYuyueName(data.get(0));                    //宠物名称 要改的
//                            chongwujiyangYuyueEntity.setChongwuTypes(Integer.valueOf(data.get(0)));   //宠物类型 要改的
//                            chongwujiyangYuyueEntity.setChongwuZhongliang(Integer.valueOf(data.get(0)));   //宠物重量 要改的
//                            chongwujiyangYuyueEntity.setChongwujiyangYuyueTime(sdf.parse(data.get(0)));          //寄养开始时间 要改的
//                            chongwujiyangYuyueEntity.setChongwujiyangYuyueNum(Integer.valueOf(data.get(0)));   //寄养天数 要改的
//                            chongwujiyangYuyueEntity.setShifouTypes(Integer.valueOf(data.get(0)));   //是否接送 要改的
//                            chongwujiyangYuyueEntity.setChongwujiyangYuyuePrice(data.get(0));                    //总价格 要改的
//                            chongwujiyangYuyueEntity.setChongwujiyangYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //寄养审核 要改的
//                            chongwujiyangYuyueEntity.setChongwujiyangYuyueYesnoText(data.get(0));                    //审核结果 要改的
//                            chongwujiyangYuyueEntity.setInsertTime(date);//时间
//                            chongwujiyangYuyueEntity.setCreateTime(date);//时间
                            chongwujiyangYuyueList.add(chongwujiyangYuyueEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        chongwujiyangYuyueService.insertBatch(chongwujiyangYuyueList);
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
        PageUtils page = chongwujiyangYuyueService.queryPage(params);

        //字典表数据转换
        List<ChongwujiyangYuyueView> list =(List<ChongwujiyangYuyueView>)page.getList();
        for(ChongwujiyangYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChongwujiyangYuyueEntity chongwujiyangYuyue = chongwujiyangYuyueService.selectById(id);
            if(chongwujiyangYuyue !=null){


                //entity转view
                ChongwujiyangYuyueView view = new ChongwujiyangYuyueView();
                BeanUtils.copyProperties( chongwujiyangYuyue , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(chongwujiyangYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    ChongwujiyangEntity chongwujiyang = chongwujiyangService.selectById(chongwujiyangYuyue.getChongwujiyangId());
                if(chongwujiyang != null){
                    BeanUtils.copyProperties( chongwujiyang , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChongwujiyangId(chongwujiyang.getId());
                }
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
    public R add(@RequestBody ChongwujiyangYuyueEntity chongwujiyangYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chongwujiyangYuyue:{}",this.getClass().getName(),chongwujiyangYuyue.toString());
        Wrapper<ChongwujiyangYuyueEntity> queryWrapper = new EntityWrapper<ChongwujiyangYuyueEntity>()
            .eq("chongwujiyang_id", chongwujiyangYuyue.getChongwujiyangId())
            .eq("yonghu_id", chongwujiyangYuyue.getYonghuId())
            .eq("chongwujiyang_yuyue_name", chongwujiyangYuyue.getChongwujiyangYuyueName())
            .eq("chongwu_types", chongwujiyangYuyue.getChongwuTypes())
            .eq("chongwu_zhongliang", chongwujiyangYuyue.getChongwuZhongliang())
            .eq("chongwujiyang_yuyue_num", chongwujiyangYuyue.getChongwujiyangYuyueNum())
            .eq("shifou_types", chongwujiyangYuyue.getShifouTypes())
            .in("chongwujiyang_yuyue_yesno_types", new Integer[]{1,2})
            .eq("chongwujiyang_yuyue_yesno_text", chongwujiyangYuyue.getChongwujiyangYuyueYesnoText())
//            .notIn("chongwujiyang_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChongwujiyangYuyueEntity chongwujiyangYuyueEntity = chongwujiyangYuyueService.selectOne(queryWrapper);
        if(chongwujiyangYuyueEntity==null){
            chongwujiyangYuyue.setChongwujiyangYuyueYesnoTypes(1);
            chongwujiyangYuyue.setInsertTime(new Date());
            chongwujiyangYuyue.setCreateTime(new Date());
        chongwujiyangYuyueService.insert(chongwujiyangYuyue);

            return R.ok();
        }else {
            if(chongwujiyangYuyueEntity.getChongwujiyangYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(chongwujiyangYuyueEntity.getChongwujiyangYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

