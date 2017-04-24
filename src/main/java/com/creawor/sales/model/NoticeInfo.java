package com.creawor.sales.model;

import com.creawor.sales.common.Const;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Zero on 2017/4/19.
 * 通知信息
 */
@Entity
@Table(catalog = Const.DB_CATALOG, name = "TB_DCHANNEL_NOTICE_RECODE")
public class NoticeInfo implements Serializable {
    /**
     * GUID
     */
    @Id
    @Column(name = "GUID")
    private String uid;

    /**
     * 分类ID
     */
    @Column(name = "CLASS_ID")
    private String classId;

    /**
     * 通知主题
     */
    @Column(name = "TOPIC")
    private String topic;

    /**
     * 通知摘要
     */
    @Column(name = "SUMMY")
    private String summary;

    /**
     * 内容类型
     */
    @Column(name = "TYPE")
    private String type;

    /**
     * 内容
     */
    @Column(name = "CONTEXT")
    private String content;

    /**
     * 作者工号
     */
    @Column(name = "AUTHER")
    private String author;

    /**
     * 发布时间
     */
    @Column(name = "PUBLISH_DATE")
    private String publishDate;

    /**
     * 访问次数
     */
    @Column(name = "VISIT_CNT")
    private int visitCount;

    /**
     * 是否组织通知
     */
    @Column(name = "IF_UNIT")
    private int ifUnit;

    /**
     * 组织代码
     */
    @Column(name = "UNIT_CODE")
    private String unitCode;

    /**
     * 是否任务通知
     */
    @Column(name = "IF_MISSION")
    private int ifMission;

    /**
     * 营销任务代码
     */
    @Column(name = "ACT_ID")
    private String actId;

    //社会渠道通知
    @Column(name = "INFO_SCOC_HAN")
    private int infosh;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public int getIfUnit() {
        return ifUnit;
    }

    public void setIfUnit(int ifUnit) {
        this.ifUnit = ifUnit;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public int getIfMission() {
        return ifMission;
    }

    public void setIfMission(int ifMission) {
        this.ifMission = ifMission;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public int getInfosh() {
        return infosh;
    }

    public void setInfosh(int infosh) {
        this.infosh = infosh;
    }
}
