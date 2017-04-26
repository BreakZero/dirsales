package com.creawor.sales.model;

import com.creawor.sales.common.Const;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Zero on 2017/4/19.
 * 通知类型
 */
@Entity
@Table(catalog = Const.DB_CATALOG, name = "TB_DIC_DCHANNEL_NOTICE_CLASS")
public class NoticeType {
    /**
     * 分类GUID
     */
    @Id
    @Column(name = "CLASS_ID")
    private String uid;

    /**
     * 分类名称
     */
    @Column(name = "CLASS_NAME")
    private String name;

    /**
     * 分类级别
     */
    @Column(name = "CLASS_GRADE")
    private int level;

    /**
     * 根标志
     */
    @Column(name = "ROOT")
    private int rootFlag;

    /**
     * 底层分类标识
     */
    @Column(name = "BOTTOM")
    private int lastFlag;

    /**
     * 上级分类GUID
     */
    @Column(name = "UP_CLASS_ID")
    private String parentUid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRootFlag() {
        return rootFlag;
    }

    public void setRootFlag(int rootFlag) {
        this.rootFlag = rootFlag;
    }

    public int getLastFlag() {
        return lastFlag;
    }

    public void setLastFlag(int lastFlag) {
        this.lastFlag = lastFlag;
    }

    public String getParentUid() {
        return parentUid;
    }

    public void setParentUid(String parentUid) {
        this.parentUid = parentUid;
    }
}
