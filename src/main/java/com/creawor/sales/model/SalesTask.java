package com.creawor.sales.model;

import com.creawor.sales.common.Const;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Zero on 2017/3/10.
 * 直销任务额度
 */
@Entity
@Table(catalog = Const.DB_CATALOG, name = "TB_DCHANNEL_CASE_EXECUTE_LIST")
public class SalesTask implements Serializable {
    /**
     * 分配额度ID
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "EXECUTE_ID")
    private String uid;

    /**
     * 上级分配额度ID
     */
    @Column(name = "PID")
    private String supId;

    /**
     * 营销活动编号
     */
    @Column(name = "ACT_ID")
    private String activityId;

    /**
     * 直销责任人工号
     */
    @Column(name = "MANAGER_NUMBER")
    private String jobNumber;

    /**
     * 直销责任人类型
     * 1    省公司直销责任人（一个）
     * 2    地市公司直销责任人（一个）
     * 3    县区公司直销责任人（一个）
     * 4    片区直销责任人（多个）
     * 5    自有营业厅直销责任人（厅长）  （一个）
     * 6    (集团)客户经理
     * 7    社区经理
     * 8    片区经理
     * 9    自由营业厅员工
     * 10   社会渠道责任人
     * 1至5 不参与直销外呼，负责任务管理
     * 6-10 为营销外呼责任人
     */
    @Column(name = "DUTY_CODE")
    private String dutyTypeCode;

    /**
     * 0 不可执行 1 可以执行 2 活动结束 ETL分配的时候，省级默认是1，其他默认为0
     */
    @Column(name = "EXEC_STATUS")
    private int execState;

    /**
     * 1   未签收  2   已签收 3   已拒签
     * 签收和下发，同样的业务漏记。管理者没有拒签功能
     */
    @Column(name = "SIGN_STATUS")
    private int signState;

    /**
     * 下发/签收状态时间
     */
    @Column(name = "SIGN_DATE")
    private String signTime;

    /**
     * ETL加载时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LOAD_DATE")
    private Date loadTime;

    /**
     * 分配人数
     */
    @Column(name = "SIGN_CNT")
    private int AssignCount;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
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

    public String getDutyTypeCode() {
        return dutyTypeCode;
    }

    public void setDutyTypeCode(String dutyTypeCode) {
        this.dutyTypeCode = dutyTypeCode;
    }

    public int getExecState() {
        return execState;
    }

    public void setExecState(int execState) {
        this.execState = execState;
    }

    public int getSignState() {
        return signState;
    }

    public void setSignState(int signState) {
        this.signState = signState;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public Date getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Date loadTime) {
        this.loadTime = loadTime;
    }

    public int getAssignCount() {
        return AssignCount;
    }

    public void setAssignCount(int assignCount) {
        AssignCount = assignCount;
    }
}
