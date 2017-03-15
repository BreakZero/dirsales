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
    private String executeId;

    /**
     * 上级分配额度ID
     */
    @Column(name = "PID")
    private String pid;

    /**
     * 营销活动编号
     */
    @Column(name = "ACT_ID")
    private String actId;

    /**
     * 直销责任人工号
     */
    @Column(name = "MANAGER_NUMBER")
    private String managerNumber;

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
     * 6-10为营销外呼责任人
     */
    @Column(name = "DUTY_CODE")
    private String dutyCode;

    /**
     * 0不可执行 1可以执行 2-活动结束 ETL分配的时候，省级默认是1，其他默认为0
     */
    @Column(name = "EXEC_STATUS")
    private int execStatus;

    /**
     * 1   未签收  2   已签收 3   已拒签
     * 签收和下发，同样的业务漏记。管理者没有拒签功能
     */
    @Column(name = "SIGN_STATUS")
    private int signStatus;

    /**
     * 下发/签收状态时间
     */
    @Column(name = "SIGN_DATE")
    private String signDate;

    /**
     * ETL加载时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LOAD_DATE")
    private Date loadDate;

    /**
     * 分配人数
     */
    @Column(name = "SIGN_CNT")
    private int signCnt;

    public String getExecuteId() {
        return executeId;
    }

    public void setExecuteId(String executeId) {
        this.executeId = executeId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getManagerNumber() {
        return managerNumber;
    }

    public void setManagerNumber(String managerNumber) {
        this.managerNumber = managerNumber;
    }

    public String getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode;
    }

    public int getExecStatus() {
        return execStatus;
    }

    public void setExecStatus(int execStatus) {
        this.execStatus = execStatus;
    }

    public int getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(int signStatus) {
        this.signStatus = signStatus;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public int getSignCnt() {
        return signCnt;
    }

    public void setSignCnt(int signCnt) {
        this.signCnt = signCnt;
    }


}
