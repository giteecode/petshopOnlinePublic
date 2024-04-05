package com.entity.model;

import com.entity.ChongwujiyangYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 宠物寄养订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChongwujiyangYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 宠物寄养
     */
    private Integer chongwujiyangId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 宠物名称
     */
    private String chongwujiyangYuyueName;


    /**
     * 宠物类型
     */
    private Integer chongwuTypes;


    /**
     * 宠物重量
     */
    private Integer chongwuZhongliang;


    /**
     * 寄养开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date chongwujiyangYuyueTime;


    /**
     * 寄养天数
     */
    private Integer chongwujiyangYuyueNum;


    /**
     * 是否接送
     */
    private Integer shifouTypes;


    /**
     * 总价格
     */
    private Double chongwujiyangYuyuePrice;


    /**
     * 寄养审核
     */
    private Integer chongwujiyangYuyueYesnoTypes;


    /**
     * 审核结果
     */
    private String chongwujiyangYuyueYesnoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
