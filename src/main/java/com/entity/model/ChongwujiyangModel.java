package com.entity.model;

import com.entity.ChongwujiyangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 宠物寄养
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChongwujiyangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 寄养服务名称
     */
    private String chongwujiyangName;


    /**
     * 寄养服务封面
     */
    private String chongwujiyangPhoto;


    /**
     * 寄养服务类型
     */
    private Integer chongwujiyangTypes;


    /**
     * 价格/天
     */
    private Double chongwujiyangNewMoney;


    /**
     * 寄养服务热度
     */
    private Integer chongwujiyangClicknum;


    /**
     * 寄养服务介绍
     */
    private String chongwujiyangContent;


    /**
     * 逻辑删除
     */
    private Integer chongwujiyangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
