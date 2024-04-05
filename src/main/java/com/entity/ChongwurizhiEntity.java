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
 * 寄存日志
 *
 * @author 
 * @email
 */
@TableName("chongwurizhi")
public class ChongwurizhiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChongwurizhiEntity() {

	}

	public ChongwurizhiEntity(T t) {
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
     * 宠物寄养订单
     */
    @ColumnInfo(comment="宠物寄养订单",type="int(11)")
    @TableField(value = "chongwujiyang_yuyue_id")

    private Integer chongwujiyangYuyueId;


    /**
     * 标题
     */
    @ColumnInfo(comment="标题",type="varchar(200)")
    @TableField(value = "chongwurizhi_name")

    private String chongwurizhiName;


    /**
     * 寄养服务详情
     */
    @ColumnInfo(comment="寄养服务详情",type="text")
    @TableField(value = "chongwurizhi_content")

    private String chongwurizhiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
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
	 * 获取：宠物寄养订单
	 */
    public Integer getChongwujiyangYuyueId() {
        return chongwujiyangYuyueId;
    }
    /**
	 * 设置：宠物寄养订单
	 */

    public void setChongwujiyangYuyueId(Integer chongwujiyangYuyueId) {
        this.chongwujiyangYuyueId = chongwujiyangYuyueId;
    }
    /**
	 * 获取：标题
	 */
    public String getChongwurizhiName() {
        return chongwurizhiName;
    }
    /**
	 * 设置：标题
	 */

    public void setChongwurizhiName(String chongwurizhiName) {
        this.chongwurizhiName = chongwurizhiName;
    }
    /**
	 * 获取：寄养服务详情
	 */
    public String getChongwurizhiContent() {
        return chongwurizhiContent;
    }
    /**
	 * 设置：寄养服务详情
	 */

    public void setChongwurizhiContent(String chongwurizhiContent) {
        this.chongwurizhiContent = chongwurizhiContent;
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
        return "Chongwurizhi{" +
            ", id=" + id +
            ", chongwujiyangYuyueId=" + chongwujiyangYuyueId +
            ", chongwurizhiName=" + chongwurizhiName +
            ", chongwurizhiContent=" + chongwurizhiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
