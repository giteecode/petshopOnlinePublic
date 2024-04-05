package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChongwujiyangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 宠物寄养
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chongwujiyang")
public class ChongwujiyangView extends ChongwujiyangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 寄养服务类型的值
	*/
	@ColumnInfo(comment="寄养服务类型的字典表值",type="varchar(200)")
	private String chongwujiyangValue;




	public ChongwujiyangView() {

	}

	public ChongwujiyangView(ChongwujiyangEntity chongwujiyangEntity) {
		try {
			BeanUtils.copyProperties(this, chongwujiyangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 寄养服务类型的值
	*/
	public String getChongwujiyangValue() {
		return chongwujiyangValue;
	}
	/**
	* 设置： 寄养服务类型的值
	*/
	public void setChongwujiyangValue(String chongwujiyangValue) {
		this.chongwujiyangValue = chongwujiyangValue;
	}




	@Override
	public String toString() {
		return "ChongwujiyangView{" +
			", chongwujiyangValue=" + chongwujiyangValue +
			"} " + super.toString();
	}
}
