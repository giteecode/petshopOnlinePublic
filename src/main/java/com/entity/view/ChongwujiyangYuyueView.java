package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChongwujiyangYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 宠物寄养订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chongwujiyang_yuyue")
public class ChongwujiyangYuyueView extends ChongwujiyangYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 宠物类型的值
	*/
	@ColumnInfo(comment="宠物类型的字典表值",type="varchar(200)")
	private String chongwuValue;
	/**
	* 是否接送的值
	*/
	@ColumnInfo(comment="是否接送的字典表值",type="varchar(200)")
	private String shifouValue;
	/**
	* 寄养审核的值
	*/
	@ColumnInfo(comment="寄养审核的字典表值",type="varchar(200)")
	private String chongwujiyangYuyueYesnoValue;

	//级联表 宠物寄养
		/**
		* 寄养服务名称
		*/

		@ColumnInfo(comment="寄养服务名称",type="varchar(200)")
		private String chongwujiyangName;
		/**
		* 寄养服务封面
		*/

		@ColumnInfo(comment="寄养服务封面",type="varchar(200)")
		private String chongwujiyangPhoto;
		/**
		* 寄养服务类型
		*/
		@ColumnInfo(comment="寄养服务类型",type="int(11)")
		private Integer chongwujiyangTypes;
			/**
			* 寄养服务类型的值
			*/
			@ColumnInfo(comment="寄养服务类型的字典表值",type="varchar(200)")
			private String chongwujiyangValue;
		/**
		* 价格/天
		*/
		@ColumnInfo(comment="价格/天",type="decimal(10,2)")
		private Double chongwujiyangNewMoney;
		/**
		* 寄养服务热度
		*/

		@ColumnInfo(comment="寄养服务热度",type="int(11)")
		private Integer chongwujiyangClicknum;
		/**
		* 寄养服务介绍
		*/

		@ColumnInfo(comment="寄养服务介绍",type="text")
		private String chongwujiyangContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer chongwujiyangDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;



	public ChongwujiyangYuyueView() {

	}

	public ChongwujiyangYuyueView(ChongwujiyangYuyueEntity chongwujiyangYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, chongwujiyangYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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
	//当前表的
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
	//当前表的
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


	//级联表的get和set 宠物寄养

		/**
		* 获取： 寄养服务名称
		*/
		public String getChongwujiyangName() {
			return chongwujiyangName;
		}
		/**
		* 设置： 寄养服务名称
		*/
		public void setChongwujiyangName(String chongwujiyangName) {
			this.chongwujiyangName = chongwujiyangName;
		}

		/**
		* 获取： 寄养服务封面
		*/
		public String getChongwujiyangPhoto() {
			return chongwujiyangPhoto;
		}
		/**
		* 设置： 寄养服务封面
		*/
		public void setChongwujiyangPhoto(String chongwujiyangPhoto) {
			this.chongwujiyangPhoto = chongwujiyangPhoto;
		}
		/**
		* 获取： 寄养服务类型
		*/
		public Integer getChongwujiyangTypes() {
			return chongwujiyangTypes;
		}
		/**
		* 设置： 寄养服务类型
		*/
		public void setChongwujiyangTypes(Integer chongwujiyangTypes) {
			this.chongwujiyangTypes = chongwujiyangTypes;
		}


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

		/**
		* 获取： 价格/天
		*/
		public Double getChongwujiyangNewMoney() {
			return chongwujiyangNewMoney;
		}
		/**
		* 设置： 价格/天
		*/
		public void setChongwujiyangNewMoney(Double chongwujiyangNewMoney) {
			this.chongwujiyangNewMoney = chongwujiyangNewMoney;
		}

		/**
		* 获取： 寄养服务热度
		*/
		public Integer getChongwujiyangClicknum() {
			return chongwujiyangClicknum;
		}
		/**
		* 设置： 寄养服务热度
		*/
		public void setChongwujiyangClicknum(Integer chongwujiyangClicknum) {
			this.chongwujiyangClicknum = chongwujiyangClicknum;
		}

		/**
		* 获取： 寄养服务介绍
		*/
		public String getChongwujiyangContent() {
			return chongwujiyangContent;
		}
		/**
		* 设置： 寄养服务介绍
		*/
		public void setChongwujiyangContent(String chongwujiyangContent) {
			this.chongwujiyangContent = chongwujiyangContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getChongwujiyangDelete() {
			return chongwujiyangDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setChongwujiyangDelete(Integer chongwujiyangDelete) {
			this.chongwujiyangDelete = chongwujiyangDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}


	@Override
	public String toString() {
		return "ChongwujiyangYuyueView{" +
			", chongwuValue=" + chongwuValue +
			", shifouValue=" + shifouValue +
			", chongwujiyangYuyueYesnoValue=" + chongwujiyangYuyueYesnoValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", chongwujiyangName=" + chongwujiyangName +
			", chongwujiyangPhoto=" + chongwujiyangPhoto +
			", chongwujiyangNewMoney=" + chongwujiyangNewMoney +
			", chongwujiyangClicknum=" + chongwujiyangClicknum +
			", chongwujiyangContent=" + chongwujiyangContent +
			", chongwujiyangDelete=" + chongwujiyangDelete +
			"} " + super.toString();
	}
}
