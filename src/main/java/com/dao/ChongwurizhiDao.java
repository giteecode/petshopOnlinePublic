package com.dao;

import com.entity.ChongwurizhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongwurizhiView;

/**
 * 寄存日志 Dao 接口
 *
 * @author 
 */
public interface ChongwurizhiDao extends BaseMapper<ChongwurizhiEntity> {

   List<ChongwurizhiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
