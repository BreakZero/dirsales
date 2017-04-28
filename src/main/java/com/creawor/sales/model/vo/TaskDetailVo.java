package com.creawor.sales.model.vo;

/**
 * Created by Zero on 2017/3/22.
 * 营销任务详情
 */
public class TaskDetailVo {
    private String uid;
    private String activityId;
    private String activityName;
    private String phoneNum;
    private String starNum;
    private int signState; // 1、未签收  2、已签收 3、已拒签
    private String marketTerms;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getStarNum() {
        return starNum;
    }

    public void setStarNum(String starNum) {
        this.starNum = starNum;
    }

    public int getSignState() {
        return signState;
    }

    public void setSignState(int signState) {
        this.signState = signState;
    }

    public String getMarketTerms() {
        return marketTerms;
    }

    public void setMarketTerms(String marketTerms) {
        this.marketTerms = marketTerms;
    }
}
