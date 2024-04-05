package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChongwurizhiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 寄存日志
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chongwurizhi")
public class ChongwurizhiView extends ChongwurizhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 宠物寄养订单
										 
		/**
		* 宠物寄养订单 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer chongwujiyangYuyueYonghuId;
		/**
		* 宠物名称
		*/

		@ColumnInfo(comment="宠物名称",type="varchar(200)")
		private String chongwujiyangYuyueName;
		/**
		* 宠物类型
		*/
		@ColumnInfo(comment="宠物类型",type="int(11)")
		private Integer chongwuTypes;
			/**
			* 宠物类型的值
			*/
			@ColumnInfo(comment="宠物类型的字典表值",type="varchar(200)")
			private String chongwuValue;
		/**
		* 宠物重量
		*/

		@ColumnInfo(comment="宠物重量",type="int(11)")
		private Integer chongwuZhongliang;
		/**
		* 寄养开始时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="寄养开始时间",type="timestamp")
		private Date chongwujiyangYuyueTime;
		/**
		* 寄养天数
		*/

		@ColumnInfo(comment="寄养天数",type="int(11)")
		private Integer chongwujiyangYuyueNum;
		/**
		* 是否接送
		*/
		@ColumnInfo(comment="是否接送",type="int(11)")
		private Integer shifouTypes;
			/**
			* 是否接送的值
			*/
			@ColumnInfo(comment="是否接送的字典表值",type="varchar(200)")
			private String shifouValue;
		/**
		* 总价格
		*/
		@ColumnInfo(comment="总价格",type="decimal(10,2)")
		private Double chongwujiyangYuyuePrice;
		/**
		* 寄养审核
		*/
		@ColumnInfo(comment="寄养审核",type="int(11)")
		private Integer chongwujiyangYuyueYesnoTypes;
			/**
			* 寄养审核的值
			*/
			@ColumnInfo(comment="寄养审核的字典表值",type="varchar(200)")
			private String chongwujiyangYuyueYesnoValue;
		/**
		* 审核结果
		*/

		@ColumnInfo(comment="审核结果",type="text")
		private String chongwujiyangYuyueYesnoText;



	public ChongwurizhiView() {

	}

	public ChongwurizhiView(ChongwurizhiEntity chongwurizhiEntity) {
		try {
			BeanUtils.copyProperties(this, chongwurizhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 宠物寄养订单
		/**
		* 获取：宠物寄养订单 的 用户
		*/
		public Integer getChongwujiyangYuyueYonghuId() {
			return chongwujiyangYuyueYonghuId;
		}
		/**
		* 设置：宠物寄养订单 的 用户
		*/
		public void setChongwujiyangYuyueYonghuId(Integer chongwujiyangYuyueYonghuId) {
			this.chongwujiyangYuyueYonghuId = chongwujiyangYuyueYonghuId;
		}

		/**
		* 获取： 宠物名称
		*/
		public String getChongwujiyangYuyueName() {
			return chongwujiyangYuyueName;
		}
		/**
		* 设置： 宠物名称
		*/
		public void setChongwujiyangYuyueName(String chongwujiyangYuyueName) {
			this.chongwujiyangYuyueName = chongwujiyangYuyueName;
		}
		/**
		* 获取： 宠物类型
		*/
		public Integer getChongwuTypes() {
			return chongwuTypes;
		}
		/**
		* 设置： 宠物类型
		*/
		public void setChongwuTypes(Integer chongwuTypes) {
			this.chongwuTypes = chongwuTypes;
		}


			/**
			* 获取： 宠物类型的值
			*/
			public String getChongwuValue() {
				return chongwuValue;
			}
			/**
			* 设置： 宠物类型的值
			*/
			public void setChongwuValue(String chongwuValue) {
				this.chongwuValue = chongwuValue;
			}

		/**
		* 获取： 宠物重量
		*/
		public Integer getChongwuZhongliang() {
			return chongwuZhongliang;
		}
		/**
		* 设置： 宠物重量
		*/
		public void setChongwuZhongliang(Integer chongwuZhongliang) {
			this.chongwuZhongliang = chongwuZhongliang;
		}

		/**
		* 获取： 寄养开始时间
		*/
		public Date getChongwujiyangYuyueTime() {
			return chongwujiyangYuyueTime;
		}
		/**
		* 设置： 寄养开始时间
		*/
		public void setChongwujiyangYuyueTime(Date chongwujiyangYuyueTime) {
			this.chongwujiyangYuyueTime = chongwujiyangYuyueTime;
		}

		/**
		* 获取： 寄养天数
		*/
		public Integer getChongwujiyangYuyueNum() {
			return chongwujiyangYuyueNum;
		}
		/**
		* 设置： 寄养天数
		*/
		public void setChongwujiyangYuyueNum(Integer chongwujiyangYuyueNum) {
			this.chongwujiyangYuyueNum = chongwujiyangYuyueNum;
		}
		/**
		* 获取： 是否接送
		*/
		public Integer getShifouTypes() {
			return shifouTypes;
		}
		/**
		* 设置： 是否接送
		*/
		public void setShifouTypes(Integer shifouTypes) {
			this.shifouTypes = shifouTypes;
		}


			/**
			* 获取： 是否接送的值
			*/
			public String getShifouValue() {
				return shifouValue;
			}
			/**
			* 设置： 是否接送的值
			*/
			public void setShifouValue(String shifouValue) {
				this.shifouValue = shifouValue;
			}

		/**
		* 获取： 总价格
		*/
		public Double getChongwujiyangYuyuePrice() {
			return chongwujiyangYuyuePrice;
		}
		/**
		* 设置： 总价格
		*/
		public void setChongwujiyangYuyuePrice(Double chongwujiyangYuyuePrice) {
			this.chongwujiyangYuyuePrice = chongwujiyangYuyuePrice;
		}
		/**
		* 获取： 寄养审核
		*/
		public Integer getChongwujiyangYuyueYesnoTypes() {
			return chongwujiyangYuyueYesnoTypes;
		}
		/**
		* 设置： 寄养审核
		*/
		public void setChongwujiyangYuyueYesnoTypes(Integer chongwujiyangYuyueYesnoTypes) {
			this.chongwujiyangYuyueYesnoTypes = chongwujiyangYuyueYesnoTypes;
		}


			/**
			* 获取： 寄养审核的值
			*/
			public String getChongwujiyangYuyueYesnoValue() {
				return chongwujiyangYuyueYesnoValue;
			}
			/**
			* 设置： 寄养审核的值
			*/
			public void setChongwujiyangYuyueYesnoValue(String chongwujiyangYuyueYesnoValue) {
				this.chongwujiyangYuyueYesnoValue = chongwujiyangYuyueYesnoValue;
			}

		/**
		* 获取： 审核结果
		*/
		public String getChongwujiyangYuyueYesnoText() {
			return chongwujiyangYuyueYesnoText;
		}
		/**
		* 设置： 审核结果
		*/
		public void setChongwujiyangYuyueYesnoText(String chongwujiyangYuyueYesnoText) {
			this.chongwujiyangYuyueYesnoText = chongwujiyangYuyueYesnoText;
		}


	@Override
	public String toString() {
		return "ChongwurizhiView{" +
			", chongwujiyangYuyueName=" + chongwujiyangYuyueName +
			", chongwuZhongliang=" + chongwuZhongliang +
			", chongwujiyangYuyueTime=" + DateUtil.convertString(chongwujiyangYuyueTime,"yyyy-MM-dd") +
			", chongwujiyangYuyueNum=" + chongwujiyangYuyueNum +
			", chongwujiyangYuyuePrice=" + chongwujiyangYuyuePrice +
			", chongwujiyangYuyueYesnoText=" + chongwujiyangYuyueYesnoText +
			"} " + super.toString();
	}
}
