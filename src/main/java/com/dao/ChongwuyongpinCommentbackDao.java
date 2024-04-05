package com.dao;

import com.entity.ChongwuyongpinCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongwuyongpinCommentbackView;

/**
 * 商品评价 Dao 接口
 *
 * @author 
 */
public interface ChongwuyongpinCommentbackDao extends BaseMapper<ChongwuyongpinCommentbackEntity> {

   List<ChongwuyongpinCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
