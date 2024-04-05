package com.dao;

import com.entity.ChongwuyongpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongwuyongpinView;

/**
 * 商品 Dao 接口
 *
 * @author 
 */
public interface ChongwuyongpinDao extends BaseMapper<ChongwuyongpinEntity> {

   List<ChongwuyongpinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
