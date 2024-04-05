package com.entity.vo;

import com.entity.ChongwuyongpinOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chongwuyongpin_order")
public class ChongwuyongpinOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "chongwuyongpin_order_uuid_number")
    private String chongwuyongpinOrderUuidNumber;


    /**
     * 收货地址
     */

    @TableField(value = "address_id")
    private Integer addressId;


    /**
     * 商品
     */

    @TableField(value = "chongwuyongpin_id")
    private Integer chongwuyongpinId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 购买数量
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 实付价格
     */

    @TableField(value = "chongwuyongpin_order_true_price")
    private Double chongwuyongpinOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "chongwuyongpin_order_types")
    private Integer chongwuyongpinOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "chongwuyongpin_order_payment_types")
    private Integer chongwuyongpinOrderPaymentTypes;


    /**
     * 订单创建时间
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
	 * 设置：订单号
	 */
    public String getChongwuyongpinOrderUuidNumber() {
        return chongwuyongpinOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setChongwuyongpinOrderUuidNumber(String chongwuyongpinOrderUuidNumber) {
        this.chongwuyongpinOrderUuidNumber = chongwuyongpinOrderUuidNumber;
    }
    /**
	 * 设置：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：商品
	 */
    public Integer getChongwuyongpinId() {
        return chongwuyongpinId;
    }


    /**
	 * 获取：商品
	 */

    public void setChongwuyongpinId(Integer chongwuyongpinId) {
        this.chongwuyongpinId = chongwuyongpinId;
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
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getChongwuyongpinOrderTruePrice() {
        return chongwuyongpinOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setChongwuyongpinOrderTruePrice(Double chongwuyongpinOrderTruePrice) {
        this.chongwuyongpinOrderTruePrice = chongwuyongpinOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getChongwuyongpinOrderTypes() {
        return chongwuyongpinOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setChongwuyongpinOrderTypes(Integer chongwuyongpinOrderTypes) {
        this.chongwuyongpinOrderTypes = chongwuyongpinOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getChongwuyongpinOrderPaymentTypes() {
        return chongwuyongpinOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setChongwuyongpinOrderPaymentTypes(Integer chongwuyongpinOrderPaymentTypes) {
        this.chongwuyongpinOrderPaymentTypes = chongwuyongpinOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
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
