package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 宠物寄养订单
 *
 * @author 
 * @email
 */
@TableName("chongwujiyang_yuyue")
public class ChongwujiyangYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChongwujiyangYuyueEntity() {

	}

	public ChongwujiyangYuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 宠物寄养
     */
    @ColumnInfo(comment="宠物寄养",type="int(11)")
    @TableField(value = "chongwujiyang_id")

    private Integer chongwujiyangId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 宠物名称
     */
    @ColumnInfo(comment="宠物名称",type="varchar(200)")
    @TableField(value = "chongwujiyang_yuyue_name")

    private String chongwujiyangYuyueName;


    /**
     * 宠物类型
     */
    @ColumnInfo(comment="宠物类型",type="int(11)")
    @TableField(value = "chongwu_types")

    private Integer chongwuTypes;


    /**
     * 宠物重量
     */
    @ColumnInfo(comment="宠物重量",type="int(11)")
    @TableField(value = "chongwu_zhongliang")

    private Integer chongwuZhongliang;


    /**
     * 寄养开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="寄养开始时间",type="timestamp")
    @TableField(value = "chongwujiyang_yuyue_time")

    private Date chongwujiyangYuyueTime;


    /**
     * 寄养天数
     */
    @ColumnInfo(comment="寄养天数",type="int(11)")
    @TableField(value = "chongwujiyang_yuyue_num")

    private Integer chongwujiyangYuyueNum;


    /**
     * 是否接送
     */
    @ColumnInfo(comment="是否接送",type="int(11)")
    @TableField(value = "shifou_types")

    private Integer shifouTypes;


    /**
     * 总价格
     */
    @ColumnInfo(comment="总价格",type="decimal(10,2)")
    @TableField(value = "chongwujiyang_yuyue_price")

    private Double chongwujiyangYuyuePrice;


    /**
     * 寄养审核
     */
    @ColumnInfo(comment="寄养审核",type="int(11)")
    @TableField(value = "chongwujiyang_yuyue_yesno_types")

    private Integer chongwujiyangYuyueYesnoTypes;


    /**
     * 审核结果
     */
    @ColumnInfo(comment="审核结果",type="text")
    @TableField(value = "chongwujiyang_yuyue_yesno_text")

    private String chongwujiyangYuyueYesnoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：宠物寄养
	 */
    public Integer getChongwujiyangId() {
        return chongwujiyangId;
    }
    /**
	 * 设置：宠物寄养
	 */

    public void setChongwujiyangId(Integer chongwujiyangId) {
        this.chongwujiyangId = chongwujiyangId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：宠物名称
	 */
    public String getChongwujiyangYuyueName() {
        return chongwujiyangYuyueName;
    }
    /**
	 * 设置：宠物名称
	 */

    public void setChongwujiyangYuyueName(String chongwujiyangYuyueName) {
        this.chongwujiyangYuyueName = chongwujiyangYuyueName;
    }
    /**
	 * 获取：宠物类型
	 */
    public Integer getChongwuTypes() {
        return chongwuTypes;
    }
    /**
	 * 设置：宠物类型
	 */

    public void setChongwuTypes(Integer chongwuTypes) {
        this.chongwuTypes = chongwuTypes;
    }
    /**
	 * 获取：宠物重量
	 */
    public Integer getChongwuZhongliang() {
        return chongwuZhongliang;
    }
    /**
	 * 设置：宠物重量
	 */

    public void setChongwuZhongliang(Integer chongwuZhongliang) {
        this.chongwuZhongliang = chongwuZhongliang;
    }
    /**
	 * 获取：寄养开始时间
	 */
    public Date getChongwujiyangYuyueTime() {
        return chongwujiyangYuyueTime;
    }
    /**
	 * 设置：寄养开始时间
	 */

    public void setChongwujiyangYuyueTime(Date chongwujiyangYuyueTime) {
        this.chongwujiyangYuyueTime = chongwujiyangYuyueTime;
    }
    /**
	 * 获取：寄养天数
	 */
    public Integer getChongwujiyangYuyueNum() {
        return chongwujiyangYuyueNum;
    }
    /**
	 * 设置：寄养天数
	 */

    public void setChongwujiyangYuyueNum(Integer chongwujiyangYuyueNum) {
        this.chongwujiyangYuyueNum = chongwujiyangYuyueNum;
    }
    /**
	 * 获取：是否接送
	 */
    public Integer getShifouTypes() {
        return shifouTypes;
    }
    /**
	 * 设置：是否接送
	 */

    public void setShifouTypes(Integer shifouTypes) {
        this.shifouTypes = shifouTypes;
    }
    /**
	 * 获取：总价格
	 */
    public Double getChongwujiyangYuyuePrice() {
        return chongwujiyangYuyuePrice;
    }
    /**
	 * 设置：总价格
	 */

    public void setChongwujiyangYuyuePrice(Double chongwujiyangYuyuePrice) {
        this.chongwujiyangYuyuePrice = chongwujiyangYuyuePrice;
    }
    /**
	 * 获取：寄养审核
	 */
    public Integer getChongwujiyangYuyueYesnoTypes() {
        return chongwujiyangYuyueYesnoTypes;
    }
    /**
	 * 设置：寄养审核
	 */

    public void setChongwujiyangYuyueYesnoTypes(Integer chongwujiyangYuyueYesnoTypes) {
        this.chongwujiyangYuyueYesnoTypes = chongwujiyangYuyueYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */
    public String getChongwujiyangYuyueYesnoText() {
        return chongwujiyangYuyueYesnoText;
    }
    /**
	 * 设置：审核结果
	 */

    public void setChongwujiyangYuyueYesnoText(String chongwujiyangYuyueYesnoText) {
        this.chongwujiyangYuyueYesnoText = chongwujiyangYuyueYesnoText;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ChongwujiyangYuyue{" +
            ", id=" + id +
            ", chongwujiyangId=" + chongwujiyangId +
            ", yonghuId=" + yonghuId +
            ", chongwujiyangYuyueName=" + chongwujiyangYuyueName +
            ", chongwuTypes=" + chongwuTypes +
            ", chongwuZhongliang=" + chongwuZhongliang +
            ", chongwujiyangYuyueTime=" + DateUtil.convertString(chongwujiyangYuyueTime,"yyyy-MM-dd") +
            ", chongwujiyangYuyueNum=" + chongwujiyangYuyueNum +
            ", shifouTypes=" + shifouTypes +
            ", chongwujiyangYuyuePrice=" + chongwujiyangYuyuePrice +
            ", chongwujiyangYuyueYesnoTypes=" + chongwujiyangYuyueYesnoTypes +
            ", chongwujiyangYuyueYesnoText=" + chongwujiyangYuyueYesnoText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
