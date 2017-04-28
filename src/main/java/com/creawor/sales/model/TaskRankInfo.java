package com.creawor.sales.model;

import com.creawor.sales.common.Const;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Zero on 2017/4/28.
 * 任务排行
 */
@Entity
@Table(catalog = Const.DB_CATALOG, name = "TB_DCHANNEL_CASE_ANALYSIS")
public class TaskRankInfo {
    /**
     * 营销活动编号
     */
    @Id
    @Column(name = "ACT_ID")
    private String actId;

    @Column(name = "ORG_ID")
    private String orgId;

    @Column(name = "PID")
    private String pid;

    /**
     * 直销责任人工号
     */
    @Column(name = "MANAGER_NUMBER")
    private String managerNumber;

    /**
     * 直销责任人姓名
     */
    @Column(name = "MANAGER_NAME")
    private String managerName;

    /**
     * 直销责任人类型
     */
    @Column(name = "MANAGER_TYPE")
    private String managerType;

    /**
     * 签收人数
     */
    @Column(name = "SIGN_CNT")
    private String signCount;

    /**
     * 短信接触人数
     */
    @Column(name = "SMS_TOUCH_CNT")
    private String smsCount;

    /**
     * 外呼接触人数
     */
    @Column(name = "CALL_TOUCH_CNT")
    private String callCount;

    /**
     * 办理订购人数
     */
    @Column(name = "ORDER_CNT")
    private String orderCount;

    /**
     * 统计日期
     */
    @Column(name = "STATIS_DATE")
    private String statisDate;

    /**
     * 省内排行
     * <p>Title: </p>
     * <p>Description: </p>
     */
    @Column(name = "PROV_RANK")
    private String provRank;

    /**
     * 市内排行
     * <p>Title: </p>
     * <p>Description: </p>
     */
    @Column(name = "REGION_RANK")
    private String regionRank;

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getManagerNumber() {
        return managerNumber;
    }

    public void setManagerNumber(String managerNumber) {
        this.managerNumber = managerNumber;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerType() {
        return managerType;
    }

    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }

    public String getSignCount() {
        return signCount;
    }

    public void setSignCount(String signCount) {
        this.signCount = signCount;
    }

    public String getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(String smsCount) {
        this.smsCount = smsCount;
    }

    public String getCallCount() {
        return callCount;
    }

    public void setCallCount(String callCount) {
        this.callCount = callCount;
    }

    public String getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(String orderCount) {
        this.orderCount = orderCount;
    }

    public String getStatisDate() {
        return statisDate;
    }

    public void setStatisDate(String statisDate) {
        this.statisDate = statisDate;
    }

    public String getProvRank() {
        return provRank;
    }

    public void setProvRank(String provRank) {
        this.provRank = provRank;
    }

    public String getRegionRank() {
        return regionRank;
    }

    public void setRegionRank(String regionRank) {
        this.regionRank = regionRank;
    }
}
