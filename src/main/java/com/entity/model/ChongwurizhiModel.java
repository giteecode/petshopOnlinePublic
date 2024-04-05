package com.entity.model;

import com.entity.ChongwurizhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 寄存日志
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChongwurizhiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 宠物寄养订单
     */
    private Integer chongwujiyangYuyueId;


    /**
     * 标题
     */
    private String chongwurizhiName;


    /**
     * 寄养服务详情
     */
    private String chongwurizhiContent;


    /**
     * 录入时间
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
