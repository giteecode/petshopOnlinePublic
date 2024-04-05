package com.entity.vo;

import com.entity.ChongwuyongpinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chongwuyongpin")
public class ChongwuyongpinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商品名称
     */

    @TableField(value = "chongwuyongpin_name")
    private String chongwuyongpinName;


    /**
     * 商品编号
     */

    @TableField(value = "chongwuyongpin_uuid_number")
    private String chongwuyongpinUuidNumber;


    /**
     * 商品照片
     */

    @TableField(value = "chongwuyongpin_photo")
    private String chongwuyongpinPhoto;


    /**
     * 商品类型
     */

    @TableField(value = "chongwuyongpin_types")
    private Integer chongwuyongpinTypes;


    /**
     * 商品库存
     */

    @TableField(value = "chongwuyongpin_kucun_number")
    private Integer chongwuyongpinKucunNumber;


    /**
     * 商品原价
     */

    @TableField(value = "chongwuyongpin_old_money")
    private Double chongwuyongpinOldMoney;


    /**
     * 现价
     */

    @TableField(value = "chongwuyongpin_new_money")
    private Double chongwuyongpinNewMoney;


    /**
     * 商品热度
     */

    @TableField(value = "chongwuyongpin_clicknum")
    private Integer chongwuyongpinClicknum;


    /**
     * 商品介绍
     */

    @TableField(value = "chongwuyongpin_content")
    private String chongwuyongpinContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "chongwuyongpin_delete")
    private Integer chongwuyongpinDelete;


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
	 * 设置：商品名称
	 */
    public String getChongwuyongpinName() {
        return chongwuyongpinName;
    }


    /**
	 * 获取：商品名称
	 */

    public void setChongwuyongpinName(String chongwuyongpinName) {
        this.chongwuyongpinName = chongwuyongpinName;
    }
    /**
	 * 设置：商品编号
	 */
    public String getChongwuyongpinUuidNumber() {
        return chongwuyongpinUuidNumber;
    }


    /**
	 * 获取：商品编号
	 */

    public void setChongwuyongpinUuidNumber(String chongwuyongpinUuidNumber) {
        this.chongwuyongpinUuidNumber = chongwuyongpinUuidNumber;
    }
    /**
	 * 设置：商品照片
	 */
    public String getChongwuyongpinPhoto() {
        return chongwuyongpinPhoto;
    }


    /**
	 * 获取：商品照片
	 */

    public void setChongwuyongpinPhoto(String chongwuyongpinPhoto) {
        this.chongwuyongpinPhoto = chongwuyongpinPhoto;
    }
    /**
	 * 设置：商品类型
	 */
    public Integer getChongwuyongpinTypes() {
        return chongwuyongpinTypes;
    }


    /**
	 * 获取：商品类型
	 */

    public void setChongwuyongpinTypes(Integer chongwuyongpinTypes) {
        this.chongwuyongpinTypes = chongwuyongpinTypes;
    }
    /**
	 * 设置：商品库存
	 */
    public Integer getChongwuyongpinKucunNumber() {
        return chongwuyongpinKucunNumber;
    }


    /**
	 * 获取：商品库存
	 */

    public void setChongwuyongpinKucunNumber(Integer chongwuyongpinKucunNumber) {
        this.chongwuyongpinKucunNumber = chongwuyongpinKucunNumber;
    }
    /**
	 * 设置：商品原价
	 */
    public Double getChongwuyongpinOldMoney() {
        return chongwuyongpinOldMoney;
    }


    /**
	 * 获取：商品原价
	 */

    public void setChongwuyongpinOldMoney(Double chongwuyongpinOldMoney) {
        this.chongwuyongpinOldMoney = chongwuyongpinOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getChongwuyongpinNewMoney() {
        return chongwuyongpinNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setChongwuyongpinNewMoney(Double chongwuyongpinNewMoney) {
        this.chongwuyongpinNewMoney = chongwuyongpinNewMoney;
    }
    /**
	 * 设置：商品热度
	 */
    public Integer getChongwuyongpinClicknum() {
        return chongwuyongpinClicknum;
    }


    /**
	 * 获取：商品热度
	 */

    public void setChongwuyongpinClicknum(Integer chongwuyongpinClicknum) {
        this.chongwuyongpinClicknum = chongwuyongpinClicknum;
    }
    /**
	 * 设置：商品介绍
	 */
    public String getChongwuyongpinContent() {
        return chongwuyongpinContent;
    }


    /**
	 * 获取：商品介绍
	 */

    public void setChongwuyongpinContent(String chongwuyongpinContent) {
        this.chongwuyongpinContent = chongwuyongpinContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getChongwuyongpinDelete() {
        return chongwuyongpinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChongwuyongpinDelete(Integer chongwuyongpinDelete) {
        this.chongwuyongpinDelete = chongwuyongpinDelete;
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
