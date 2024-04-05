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
 * 宠物寄养
 *
 * @author 
 * @email
 */
@TableName("chongwujiyang")
public class ChongwujiyangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChongwujiyangEntity() {

	}

	public ChongwujiyangEntity(T t) {
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
     * 寄养服务名称
     */
    @ColumnInfo(comment="寄养服务名称",type="varchar(200)")
    @TableField(value = "chongwujiyang_name")

    private String chongwujiyangName;


    /**
     * 寄养服务封面
     */
    @ColumnInfo(comment="寄养服务封面",type="varchar(200)")
    @TableField(value = "chongwujiyang_photo")

    private String chongwujiyangPhoto;


    /**
     * 寄养服务类型
     */
    @ColumnInfo(comment="寄养服务类型",type="int(11)")
    @TableField(value = "chongwujiyang_types")

    private Integer chongwujiyangTypes;


    /**
     * 价格/天
     */
    @ColumnInfo(comment="价格/天",type="decimal(10,2)")
    @TableField(value = "chongwujiyang_new_money")

    private Double chongwujiyangNewMoney;


    /**
     * 寄养服务热度
     */
    @ColumnInfo(comment="寄养服务热度",type="int(11)")
    @TableField(value = "chongwujiyang_clicknum")

    private Integer chongwujiyangClicknum;


    /**
     * 寄养服务介绍
     */
    @ColumnInfo(comment="寄养服务介绍",type="text")
    @TableField(value = "chongwujiyang_content")

    private String chongwujiyangContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "chongwujiyang_delete")

    private Integer chongwujiyangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：寄养服务名称
	 */
    public String getChongwujiyangName() {
        return chongwujiyangName;
    }
    /**
	 * 设置：寄养服务名称
	 */

    public void setChongwujiyangName(String chongwujiyangName) {
        this.chongwujiyangName = chongwujiyangName;
    }
    /**
	 * 获取：寄养服务封面
	 */
    public String getChongwujiyangPhoto() {
        return chongwujiyangPhoto;
    }
    /**
	 * 设置：寄养服务封面
	 */

    public void setChongwujiyangPhoto(String chongwujiyangPhoto) {
        this.chongwujiyangPhoto = chongwujiyangPhoto;
    }
    /**
	 * 获取：寄养服务类型
	 */
    public Integer getChongwujiyangTypes() {
        return chongwujiyangTypes;
    }
    /**
	 * 设置：寄养服务类型
	 */

    public void setChongwujiyangTypes(Integer chongwujiyangTypes) {
        this.chongwujiyangTypes = chongwujiyangTypes;
    }
    /**
	 * 获取：价格/天
	 */
    public Double getChongwujiyangNewMoney() {
        return chongwujiyangNewMoney;
    }
    /**
	 * 设置：价格/天
	 */

    public void setChongwujiyangNewMoney(Double chongwujiyangNewMoney) {
        this.chongwujiyangNewMoney = chongwujiyangNewMoney;
    }
    /**
	 * 获取：寄养服务热度
	 */
    public Integer getChongwujiyangClicknum() {
        return chongwujiyangClicknum;
    }
    /**
	 * 设置：寄养服务热度
	 */

    public void setChongwujiyangClicknum(Integer chongwujiyangClicknum) {
        this.chongwujiyangClicknum = chongwujiyangClicknum;
    }
    /**
	 * 获取：寄养服务介绍
	 */
    public String getChongwujiyangContent() {
        return chongwujiyangContent;
    }
    /**
	 * 设置：寄养服务介绍
	 */

    public void setChongwujiyangContent(String chongwujiyangContent) {
        this.chongwujiyangContent = chongwujiyangContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChongwujiyangDelete() {
        return chongwujiyangDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setChongwujiyangDelete(Integer chongwujiyangDelete) {
        this.chongwujiyangDelete = chongwujiyangDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Chongwujiyang{" +
            ", id=" + id +
            ", chongwujiyangName=" + chongwujiyangName +
            ", chongwujiyangPhoto=" + chongwujiyangPhoto +
            ", chongwujiyangTypes=" + chongwujiyangTypes +
            ", chongwujiyangNewMoney=" + chongwujiyangNewMoney +
            ", chongwujiyangClicknum=" + chongwujiyangClicknum +
            ", chongwujiyangContent=" + chongwujiyangContent +
            ", chongwujiyangDelete=" + chongwujiyangDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
