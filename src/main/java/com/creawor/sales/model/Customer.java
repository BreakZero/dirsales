package com.creawor.sales.model;

import com.creawor.sales.common.Const;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Zero on 2017/3/15.
 * 营销客户表
 */
@Entity
@Table(catalog = Const.DB_CATALOG, name = "TB_DCHANNEL_USER_LIST")
public class Customer {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "USER_LIST_ID")
    private String uid;

    /**
     * 分配额度ID
     */
    @Column(name = "EXECUTE_ID")
    private String executeId;

    /**
     * 营销活动编号
     */
    @Column(name = "ACT_ID")
    private String activityId;

    /**
     * 直销责任人工号
     */
    @Column(name = "MANAGER_NUMBER2")
    private String jobNumber;

    /**
     * 用户电话号码
     */
    @Column(name = "SERV_NUMBER")
    private String custPhoneNum;

    /**
     * 短信营销时间
     */
    @Column(name = "SMS_DATE")
    private String smsTime;

    /**
     * 外呼营销开始时间
     */
    @Column(name = "CALL_START_DATE")
    private String callStartTime;

    /**
     * 外呼营销结束时间
     */
    @Column(name = "CALL_END_DATE")
    private String callEndTime;

    /**
     * 是否接触
     */
    @Column(name = "IF_TOUCH")
    private int ifTouch;

    /**
     * 是否订购 0 否， 1 是
     */
    @Column(name = "IF_ORDER")
    private int ifOrder;

    /**
     * 外呼成功标志0 失败 1成功
     */
    @Column(name = "CALL_IF_SUCCES")
    private int callState;

    /**
     * 短信成功标志0 失败 1成功
     */
    @Column(name = "SMS_IF_SUCCES")
    private int smsState;

    /**
     * 是否抽奖计数
     */
    @Column(name = "IF_BONUS")
    private int ifBonus;

    /**
     * 客户营销状态0-未完成  1-已完成
     */
    @Column(name = "SERV_STATUS")
    private int marketState;

    /**
     * 电话录音地址
     */
    @Column(name = "call_content")
    private String audioFilePath;

    /**
     * 短信内容
     */
    @Column(name = "sms_content")
    private String smsContent;


    /**
     * 客户意愿
     */
    @Column(name = "USER_WILL")
    private String userWill;
    /**
     * 星级
     */
    @Column(name = "user_level")
    private String custLevel;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getExecuteId() {
        return executeId;
    }

    public void setExecuteId(String executeId) {
        this.executeId = executeId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getCustPhoneNum() {
        return custPhoneNum;
    }

    public void setCustPhoneNum(String custPhoneNum) {
        this.custPhoneNum = custPhoneNum;
    }

    public String getSmsTime() {
        return smsTime;
    }

    public void setSmsTime(String smsTime) {
        this.smsTime = smsTime;
    }

    public String getCallStartTime() {
        return callStartTime;
    }

    public void setCallStartTime(String callStartTime) {
        this.callStartTime = callStartTime;
    }

    public String getCallEndTime() {
        return callEndTime;
    }

    public void setCallEndTime(String callEndTime) {
        this.callEndTime = callEndTime;
    }

    public int getIfTouch() {
        return ifTouch;
    }

    public void setIfTouch(int ifTouch) {
        this.ifTouch = ifTouch;
    }

    public int getIfOrder() {
        return ifOrder;
    }

    public void setIfOrder(int ifOrder) {
        this.ifOrder = ifOrder;
    }

    public int getCallState() {
        return callState;
    }

    public void setCallState(int callState) {
        this.callState = callState;
    }

    public int getSmsState() {
        return smsState;
    }

    public void setSmsState(int smsState) {
        this.smsState = smsState;
    }

    public int getIfBonus() {
        return ifBonus;
    }

    public void setIfBonus(int ifBonus) {
        this.ifBonus = ifBonus;
    }

    public int getMarketState() {
        return marketState;
    }

    public void setMarketState(int marketState) {
        this.marketState = marketState;
    }

    public String getAudioFilePath() {
        return audioFilePath;
    }

    public void setAudioFilePath(String audioFilePath) {
        this.audioFilePath = audioFilePath;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public String getUserWill() {
        return userWill;
    }

    public void setUserWill(String userWill) {
        this.userWill = userWill;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }
}
