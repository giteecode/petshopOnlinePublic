package com.entity.vo;

import com.entity.ChongwurizhiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 寄存日志
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chongwurizhi")
public class ChongwurizhiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 宠物寄养订单
     */

    @TableField(value = "chongwujiyang_yuyue_id")
    private Integer chongwujiyangYuyueId;


    /**
     * 标题
     */

    @TableField(value = "chongwurizhi_name")
    private String chongwurizhiName;


    /**
     * 寄养服务详情
     */

    @TableField(value = "chongwurizhi_content")
    private String chongwurizhiContent;


    /**
     * 录入时间
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
	 * 设置：宠物寄养订单
	 */
    public Integer getChongwujiyangYuyueId() {
        return chongwujiyangYuyueId;
    }


    /**
	 * 获取：宠物寄养订单
	 */

    public void setChongwujiyangYuyueId(Integer chongwujiyangYuyueId) {
        this.chongwujiyangYuyueId = chongwujiyangYuyueId;
    }
    /**
	 * 设置：标题
	 */
    public String getChongwurizhiName() {
        return chongwurizhiName;
    }


    /**
	 * 获取：标题
	 */

    public void setChongwurizhiName(String chongwurizhiName) {
        this.chongwurizhiName = chongwurizhiName;
    }
    /**
	 * 设置：寄养服务详情
	 */
    public String getChongwurizhiContent() {
        return chongwurizhiContent;
    }


    /**
	 * 获取：寄养服务详情
	 */

    public void setChongwurizhiContent(String chongwurizhiContent) {
        this.chongwurizhiContent = chongwurizhiContent;
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
