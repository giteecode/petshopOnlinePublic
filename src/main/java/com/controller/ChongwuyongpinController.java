
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
 * 商品
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chongwuyongpin")
public class ChongwuyongpinController {
    private static final Logger logger = LoggerFactory.getLogger(ChongwuyongpinController.class);

    private static final String TABLE_NAME = "chongwuyongpin";

    @Autowired
    private ChongwuyongpinService chongwuyongpinService;


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
    private ChongwujiyangYuyueService chongwujiyangYuyueService;//宠物寄养订单
    @Autowired
    private ChongwurizhiService chongwurizhiService;//寄存日志
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
        params.put("chongwuyongpinDeleteStart",1);params.put("chongwuyongpinDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = chongwuyongpinService.queryPage(params);

        //字典表数据转换
        List<ChongwuyongpinView> list =(List<ChongwuyongpinView>)page.getList();
        for(ChongwuyongpinView c:list){
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
        ChongwuyongpinEntity chongwuyongpin = chongwuyongpinService.selectById(id);
        if(chongwuyongpin !=null){
            //entity转view
            ChongwuyongpinView view = new ChongwuyongpinView();
            BeanUtils.copyProperties( chongwuyongpin , view );//把实体数据重构到view中
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
    public R save(@RequestBody ChongwuyongpinEntity chongwuyongpin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chongwuyongpin:{}",this.getClass().getName(),chongwuyongpin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChongwuyongpinEntity> queryWrapper = new EntityWrapper<ChongwuyongpinEntity>()
            .eq("chongwuyongpin_name", chongwuyongpin.getChongwuyongpinName())
            .eq("chongwuyongpin_types", chongwuyongpin.getChongwuyongpinTypes())
            .eq("chongwuyongpin_kucun_number", chongwuyongpin.getChongwuyongpinKucunNumber())
            .eq("shangxia_types", chongwuyongpin.getShangxiaTypes())
            .eq("chongwuyongpin_delete", chongwuyongpin.getChongwuyongpinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChongwuyongpinEntity chongwuyongpinEntity = chongwuyongpinService.selectOne(queryWrapper);
        if(chongwuyongpinEntity==null){
            chongwuyongpin.setChongwuyongpinClicknum(1);
            chongwuyongpin.setShangxiaTypes(1);
            chongwuyongpin.setChongwuyongpinDelete(1);
            chongwuyongpin.setInsertTime(new Date());
            chongwuyongpin.setCreateTime(new Date());
            chongwuyongpinService.insert(chongwuyongpin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChongwuyongpinEntity chongwuyongpin, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chongwuyongpin:{}",this.getClass().getName(),chongwuyongpin.toString());
        ChongwuyongpinEntity oldChongwuyongpinEntity = chongwuyongpinService.selectById(chongwuyongpin.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(chongwuyongpin.getChongwuyongpinPhoto()) || "null".equals(chongwuyongpin.getChongwuyongpinPhoto())){
                chongwuyongpin.setChongwuyongpinPhoto(null);
        }

            chongwuyongpinService.updateById(chongwuyongpin);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChongwuyongpinEntity> oldChongwuyongpinList =chongwuyongpinService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ChongwuyongpinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ChongwuyongpinEntity chongwuyongpinEntity = new ChongwuyongpinEntity();
            chongwuyongpinEntity.setId(id);
            chongwuyongpinEntity.setChongwuyongpinDelete(2);
            list.add(chongwuyongpinEntity);
        }
        if(list != null && list.size() >0){
            chongwuyongpinService.updateBatchById(list);
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
            List<ChongwuyongpinEntity> chongwuyongpinList = new ArrayList<>();//上传的东西
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
                            ChongwuyongpinEntity chongwuyongpinEntity = new ChongwuyongpinEntity();
//                            chongwuyongpinEntity.setChongwuyongpinName(data.get(0));                    //商品名称 要改的
//                            chongwuyongpinEntity.setChongwuyongpinUuidNumber(data.get(0));                    //商品编号 要改的
//                            chongwuyongpinEntity.setChongwuyongpinPhoto("");//详情和图片
//                            chongwuyongpinEntity.setChongwuyongpinTypes(Integer.valueOf(data.get(0)));   //商品类型 要改的
//                            chongwuyongpinEntity.setChongwuyongpinKucunNumber(Integer.valueOf(data.get(0)));   //商品库存 要改的
//                            chongwuyongpinEntity.setChongwuyongpinOldMoney(data.get(0));                    //商品原价 要改的
//                            chongwuyongpinEntity.setChongwuyongpinNewMoney(data.get(0));                    //现价 要改的
//                            chongwuyongpinEntity.setChongwuyongpinClicknum(Integer.valueOf(data.get(0)));   //商品热度 要改的
//                            chongwuyongpinEntity.setChongwuyongpinContent("");//详情和图片
//                            chongwuyongpinEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            chongwuyongpinEntity.setChongwuyongpinDelete(1);//逻辑删除字段
//                            chongwuyongpinEntity.setInsertTime(date);//时间
//                            chongwuyongpinEntity.setCreateTime(date);//时间
                            chongwuyongpinList.add(chongwuyongpinEntity);


                            //把要查询是否重复的字段放入map中
                                //商品编号
                                if(seachFields.containsKey("chongwuyongpinUuidNumber")){
                                    List<String> chongwuyongpinUuidNumber = seachFields.get("chongwuyongpinUuidNumber");
                                    chongwuyongpinUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chongwuyongpinUuidNumber = new ArrayList<>();
                                    chongwuyongpinUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chongwuyongpinUuidNumber",chongwuyongpinUuidNumber);
                                }
                        }

                        //查询是否重复
                         //商品编号
                        List<ChongwuyongpinEntity> chongwuyongpinEntities_chongwuyongpinUuidNumber = chongwuyongpinService.selectList(new EntityWrapper<ChongwuyongpinEntity>().in("chongwuyongpin_uuid_number", seachFields.get("chongwuyongpinUuidNumber")).eq("chongwuyongpin_delete", 1));
                        if(chongwuyongpinEntities_chongwuyongpinUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChongwuyongpinEntity s:chongwuyongpinEntities_chongwuyongpinUuidNumber){
                                repeatFields.add(s.getChongwuyongpinUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [商品编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chongwuyongpinService.insertBatch(chongwuyongpinList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ChongwuyongpinView> returnChongwuyongpinViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = chongwuyongpinOrderService.queryPage(params1);
        List<ChongwuyongpinOrderView> orderViewsList =(List<ChongwuyongpinOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ChongwuyongpinOrderView orderView:orderViewsList){
            Integer chongwuyongpinTypes = orderView.getChongwuyongpinTypes();
            if(typeMap.containsKey(chongwuyongpinTypes)){
                typeMap.put(chongwuyongpinTypes,typeMap.get(chongwuyongpinTypes)+1);
            }else{
                typeMap.put(chongwuyongpinTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("chongwuyongpinTypes",type);
            PageUtils pageUtils1 = chongwuyongpinService.queryPage(params2);
            List<ChongwuyongpinView> chongwuyongpinViewList =(List<ChongwuyongpinView>)pageUtils1.getList();
            returnChongwuyongpinViewList.addAll(chongwuyongpinViewList);
            if(returnChongwuyongpinViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = chongwuyongpinService.queryPage(params);
        if(returnChongwuyongpinViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnChongwuyongpinViewList.size();//要添加的数量
            List<ChongwuyongpinView> chongwuyongpinViewList =(List<ChongwuyongpinView>)page.getList();
            for(ChongwuyongpinView chongwuyongpinView:chongwuyongpinViewList){
                Boolean addFlag = true;
                for(ChongwuyongpinView returnChongwuyongpinView:returnChongwuyongpinViewList){
                    if(returnChongwuyongpinView.getId().intValue() ==chongwuyongpinView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnChongwuyongpinViewList.add(chongwuyongpinView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnChongwuyongpinViewList = returnChongwuyongpinViewList.subList(0, limit);
        }

        for(ChongwuyongpinView c:returnChongwuyongpinViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnChongwuyongpinViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = chongwuyongpinService.queryPage(params);

        //字典表数据转换
        List<ChongwuyongpinView> list =(List<ChongwuyongpinView>)page.getList();
        for(ChongwuyongpinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChongwuyongpinEntity chongwuyongpin = chongwuyongpinService.selectById(id);
            if(chongwuyongpin !=null){

                //点击数量加1
                chongwuyongpin.setChongwuyongpinClicknum(chongwuyongpin.getChongwuyongpinClicknum()+1);
                chongwuyongpinService.updateById(chongwuyongpin);

                //entity转view
                ChongwuyongpinView view = new ChongwuyongpinView();
                BeanUtils.copyProperties( chongwuyongpin , view );//把实体数据重构到view中

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
    public R add(@RequestBody ChongwuyongpinEntity chongwuyongpin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chongwuyongpin:{}",this.getClass().getName(),chongwuyongpin.toString());
        Wrapper<ChongwuyongpinEntity> queryWrapper = new EntityWrapper<ChongwuyongpinEntity>()
            .eq("chongwuyongpin_name", chongwuyongpin.getChongwuyongpinName())
            .eq("chongwuyongpin_uuid_number", chongwuyongpin.getChongwuyongpinUuidNumber())
            .eq("chongwuyongpin_types", chongwuyongpin.getChongwuyongpinTypes())
            .eq("chongwuyongpin_kucun_number", chongwuyongpin.getChongwuyongpinKucunNumber())
            .eq("chongwuyongpin_clicknum", chongwuyongpin.getChongwuyongpinClicknum())
            .eq("shangxia_types", chongwuyongpin.getShangxiaTypes())
            .eq("chongwuyongpin_delete", chongwuyongpin.getChongwuyongpinDelete())
//            .notIn("chongwuyongpin_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChongwuyongpinEntity chongwuyongpinEntity = chongwuyongpinService.selectOne(queryWrapper);
        if(chongwuyongpinEntity==null){
            chongwuyongpin.setChongwuyongpinDelete(1);
            chongwuyongpin.setInsertTime(new Date());
            chongwuyongpin.setCreateTime(new Date());
        chongwuyongpinService.insert(chongwuyongpin);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

