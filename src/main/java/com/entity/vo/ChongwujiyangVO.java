package com.entity.vo;

import com.entity.ChongwujiyangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宠物寄养
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chongwujiyang")
public class ChongwujiyangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 寄养服务名称
     */

    @TableField(value = "chongwujiyang_name")
    private String chongwujiyangName;


    /**
     * 寄养服务封面
     */

    @TableField(value = "chongwujiyang_photo")
    private String chongwujiyangPhoto;


    /**
     * 寄养服务类型
     */

    @TableField(value = "chongwujiyang_types")
    private Integer chongwujiyangTypes;


    /**
     * 价格/天
     */

    @TableField(value = "chongwujiyang_new_money")
    private Double chongwujiyangNewMoney;


    /**
     * 寄养服务热度
     */

    @TableField(value = "chongwujiyang_clicknum")
    private Integer chongwujiyangClicknum;


    /**
     * 寄养服务介绍
     */

    @TableField(value = "chongwujiyang_content")
    private String chongwujiyangContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "chongwujiyang_delete")
    private Integer chongwujiyangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：寄养服务名称
	 */
    public String getChongwujiyangName() {
        return chongwujiyangName;
    }


    /**
	 * 获取：寄养服务名称
	 */

    public void setChongwujiyangName(String chongwujiyangName) {
        this.chongwujiyangName = chongwujiyangName;
    }
    /**
	 * 设置：寄养服务封面
	 */
    public String getChongwujiyangPhoto() {
        return chongwujiyangPhoto;
    }


    /**
	 * 获取：寄养服务封面
	 */

    public void setChongwujiyangPhoto(String chongwujiyangPhoto) {
        this.chongwujiyangPhoto = chongwujiyangPhoto;
    }
    /**
	 * 设置：寄养服务类型
	 */
    public Integer getChongwujiyangTypes() {
        return chongwujiyangTypes;
    }


    /**
	 * 获取：寄养服务类型
	 */

    public void setChongwujiyangTypes(Integer chongwujiyangTypes) {
        this.chongwujiyangTypes = chongwujiyangTypes;
    }
    /**
	 * 设置：价格/天
	 */
    public Double getChongwujiyangNewMoney() {
        return chongwujiyangNewMoney;
    }


    /**
	 * 获取：价格/天
	 */

    public void setChongwujiyangNewMoney(Double chongwujiyangNewMoney) {
        this.chongwujiyangNewMoney = chongwujiyangNewMoney;
    }
    /**
	 * 设置：寄养服务热度
	 */
    public Integer getChongwujiyangClicknum() {
        return chongwujiyangClicknum;
    }


    /**
	 * 获取：寄养服务热度
	 */

    public void setChongwujiyangClicknum(Integer chongwujiyangClicknum) {
        this.chongwujiyangClicknum = chongwujiyangClicknum;
    }
    /**
	 * 设置：寄养服务介绍
	 */
    public String getChongwujiyangContent() {
        return chongwujiyangContent;
    }


    /**
	 * 获取：寄养服务介绍
	 */

    public void setChongwujiyangContent(String chongwujiyangContent) {
        this.chongwujiyangContent = chongwujiyangContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getChongwujiyangDelete() {
        return chongwujiyangDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChongwujiyangDelete(Integer chongwujiyangDelete) {
        this.chongwujiyangDelete = chongwujiyangDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
