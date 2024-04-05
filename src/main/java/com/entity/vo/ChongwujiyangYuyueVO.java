package com.entity.vo;

import com.entity.ChongwujiyangYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宠物寄养订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chongwujiyang_yuyue")
public class ChongwujiyangYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 宠物寄养
     */

    @TableField(value = "chongwujiyang_id")
    private Integer chongwujiyangId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 宠物名称
     */

    @TableField(value = "chongwujiyang_yuyue_name")
    private String chongwujiyangYuyueName;


    /**
     * 宠物类型
     */

    @TableField(value = "chongwu_types")
    private Integer chongwuTypes;


    /**
     * 宠物重量
     */

    @TableField(value = "chongwu_zhongliang")
    private Integer chongwuZhongliang;


    /**
     * 寄养开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "chongwujiyang_yuyue_time")
    private Date chongwujiyangYuyueTime;


    /**
     * 寄养天数
     */

    @TableField(value = "chongwujiyang_yuyue_num")
    private Integer chongwujiyangYuyueNum;


    /**
     * 是否接送
     */

    @TableField(value = "shifou_types")
    private Integer shifouTypes;


    /**
     * 总价格
     */

    @TableField(value = "chongwujiyang_yuyue_price")
    private Double chongwujiyangYuyuePrice;


    /**
     * 寄养审核
     */

    @TableField(value = "chongwujiyang_yuyue_yesno_types")
    private Integer chongwujiyangYuyueYesnoTypes;


    /**
     * 审核结果
     */

    @TableField(value = "chongwujiyang_yuyue_yesno_text")
    private String chongwujiyangYuyueYesnoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：宠物寄养
	 */
    public Integer getChongwujiyangId() {
        return chongwujiyangId;
    }


    /**
	 * 获取：宠物寄养
	 */

    public void setChongwujiyangId(Integer chongwujiyangId) {
        this.chongwujiyangId = chongwujiyangId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：宠物名称
	 */
    public String getChongwujiyangYuyueName() {
        return chongwujiyangYuyueName;
    }


    /**
	 * 获取：宠物名称
	 */

    public void setChongwujiyangYuyueName(String chongwujiyangYuyueName) {
        this.chongwujiyangYuyueName = chongwujiyangYuyueName;
    }
    /**
	 * 设置：宠物类型
	 */
    public Integer getChongwuTypes() {
        return chongwuTypes;
    }


    /**
	 * 获取：宠物类型
	 */

    public void setChongwuTypes(Integer chongwuTypes) {
        this.chongwuTypes = chongwuTypes;
    }
    /**
	 * 设置：宠物重量
	 */
    public Integer getChongwuZhongliang() {
        return chongwuZhongliang;
    }


    /**
	 * 获取：宠物重量
	 */

    public void setChongwuZhongliang(Integer chongwuZhongliang) {
        this.chongwuZhongliang = chongwuZhongliang;
    }
    /**
	 * 设置：寄养开始时间
	 */
    public Date getChongwujiyangYuyueTime() {
        return chongwujiyangYuyueTime;
    }


    /**
	 * 获取：寄养开始时间
	 */

    public void setChongwujiyangYuyueTime(Date chongwujiyangYuyueTime) {
        this.chongwujiyangYuyueTime = chongwujiyangYuyueTime;
    }
    /**
	 * 设置：寄养天数
	 */
    public Integer getChongwujiyangYuyueNum() {
        return chongwujiyangYuyueNum;
    }


    /**
	 * 获取：寄养天数
	 */

    public void setChongwujiyangYuyueNum(Integer chongwujiyangYuyueNum) {
        this.chongwujiyangYuyueNum = chongwujiyangYuyueNum;
    }
    /**
	 * 设置：是否接送
	 */
    public Integer getShifouTypes() {
        return shifouTypes;
    }


    /**
	 * 获取：是否接送
	 */

    public void setShifouTypes(Integer shifouTypes) {
        this.shifouTypes = shifouTypes;
    }
    /**
	 * 设置：总价格
	 */
    public Double getChongwujiyangYuyuePrice() {
        return chongwujiyangYuyuePrice;
    }


    /**
	 * 获取：总价格
	 */

    public void setChongwujiyangYuyuePrice(Double chongwujiyangYuyuePrice) {
        this.chongwujiyangYuyuePrice = chongwujiyangYuyuePrice;
    }
    /**
	 * 设置：寄养审核
	 */
    public Integer getChongwujiyangYuyueYesnoTypes() {
        return chongwujiyangYuyueYesnoTypes;
    }


    /**
	 * 获取：寄养审核
	 */

    public void setChongwujiyangYuyueYesnoTypes(Integer chongwujiyangYuyueYesnoTypes) {
        this.chongwujiyangYuyueYesnoTypes = chongwujiyangYuyueYesnoTypes;
    }
    /**
	 * 设置：审核结果
	 */
    public String getChongwujiyangYuyueYesnoText() {
        return chongwujiyangYuyueYesnoText;
    }


    /**
	 * 获取：审核结果
	 */

    public void setChongwujiyangYuyueYesnoText(String chongwujiyangYuyueYesnoText) {
        this.chongwujiyangYuyueYesnoText = chongwujiyangYuyueYesnoText;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
