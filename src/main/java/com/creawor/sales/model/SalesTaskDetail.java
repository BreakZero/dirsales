package com.creawor.sales.model;

import com.creawor.sales.common.Const;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Zero on 2017/3/22.
 * 营销任务详情
 */
@Entity
@Table(catalog = Const.DB_CATALOG, name = "TB_DCHANNEL_CASE_INFO")
public class SalesTaskDetail {
    /**
     * 营销活动编号
     */
    @Id
    @Column(name = "ACT_ID")
    private String activityId;

    /**
     * 营销活动名称
     */
    @Column(name = "ACT_NAME")
    private String activityName;

    /**
     * 营销任务描述
     */
    @Column(name = "ACT_NOTE")
    private String activityNote;

    /**
     * 推荐业务类型
     */
    @Column(name = "GROOM_OPT_TYPE")
    private String groomOptType;

    /**
     * 业务名称
     */
    @Column(name = "OPT_NAME")
    private String optName;

    /**
     * 业务编号
     */
    @Column(name = "OPT_ID")
    private String optId;

    /**
     * 规则编码
     */
    @Column(name = "RULE_ID")
    private String ruleId;

    /**
     * 活动执行地区
     */
    @Column(name = "ACT_AREA")
    private String activityArea;

    /**
     * 目标客户群编码
     */
    @Column(name = "CUS_ID")
    private String customerId;

    /**
     * 目标客户群名称
     */
    @Column(name = "CUS_NAME")
    private String customerName;

    /**
     * 活动目标
     */
    @Column(name = "ACT_TARGET")
    private String activityTarget;

    /**
     * 营销用语
     */
    @Column(name = "CAMPSEG_CONTENT")
    private String marketTerms;

    /**
     * 营销活动开始日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ACT_START_DATE")
    private Date startTime;

    /**
     * 营销活动结束日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ACT_END_DATE")
    private Date endDate;

    /**
     * 发起部门
     */
    @Column(name = "ACT_SEND_DEPARTMANT")
    private String actSendDepartmant;

    /**
     * 发起时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ACT_SEND_DATE")
    private Date actSendDate;

    /**
     * 扩展一
     */
    @Column(name = "EXTENDED_1")
    private String extended1;

    /**
     * 扩展二
     */
    @Column(name = "EXTENDED_2")
    private String extended2;

    /**
     * 扩展三
     */
    @Column(name = "EXTENDED_3")
    private String extended3;

    /**
     * 营销活动状态
     */
    @Column(name = "ACT_STATUS")
    private String actState;

    /**
     * 营销责任人类型范围
     */
    @Column(name = "ACT_DUTY_SCOPE")
    private String actDutyScope;

    /**
     * 优先级
     */
    @Column(name = "ACT_STAR")
    private String starNum;

    /**
     * 优先级
     */
    @Column(name = "IF_ZH")
    private String useIVR;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityNote() {
        return activityNote;
    }

    public void setActivityNote(String activityNote) {
        this.activityNote = activityNote;
    }

    public String getGroomOptType() {
        return groomOptType;
    }

    public void setGroomOptType(String groomOptType) {
        this.groomOptType = groomOptType;
    }

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName;
    }

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getActivityArea() {
        return activityArea;
    }

    public void setActivityArea(String activityArea) {
        this.activityArea = activityArea;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getActivityTarget() {
        return activityTarget;
    }

    public void setActivityTarget(String activityTarget) {
        this.activityTarget = activityTarget;
    }

    public String getMarketTerms() {
        return marketTerms;
    }

    public void setMarketTerms(String marketTerms) {
        this.marketTerms = marketTerms;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getActSendDepartmant() {
        return actSendDepartmant;
    }

    public void setActSendDepartmant(String actSendDepartmant) {
        this.actSendDepartmant = actSendDepartmant;
    }

    public Date getActSendDate() {
        return actSendDate;
    }

    public void setActSendDate(Date actSendDate) {
        this.actSendDate = actSendDate;
    }

    public String getExtended1() {
        return extended1;
    }

    public void setExtended1(String extended1) {
        this.extended1 = extended1;
    }

    public String getExtended2() {
        return extended2;
    }

    public void setExtended2(String extended2) {
        this.extended2 = extended2;
    }

    public String getExtended3() {
        return extended3;
    }

    public void setExtended3(String extended3) {
        this.extended3 = extended3;
    }

    public String getActState() {
        return actState;
    }

    public void setActState(String actState) {
        this.actState = actState;
    }

    public String getActDutyScope() {
        return actDutyScope;
    }

    public void setActDutyScope(String actDutyScope) {
        this.actDutyScope = actDutyScope;
    }

    public String getStarNum() {
        return starNum;
    }

    public void setStarNum(String starNum) {
        this.starNum = starNum;
    }

    public String getUseIVR() {
        return useIVR;
    }

    public void setUseIVR(String useIVR) {
        this.useIVR = useIVR;
    }
}
