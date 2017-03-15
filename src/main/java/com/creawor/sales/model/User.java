package com.creawor.sales.model;


import com.creawor.sales.common.Const;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jin_ on 2016/11/10.
 *
 * 用户表
 */
@Entity
@Table(catalog = Const.DB_CATALOG, name = "TB_SYS_USER")
public class User implements Serializable {
  /**
   * 用户主键
   */
  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  @Column(name = "USER_ID", length = 32)
  private String userId;

  /**
   * 角色表主键
   */
  @Column(name = "ROLE_ID", length = 32)
  private String roleId;

  /**
   * 组织ID
   */
  @Column(name = "ORG_ID", length = 20)
  private String orgId;

  /**
   * 帐号
   */
  @Column(name = "ACCOUNT_NO", length = 20)
  private String accountNo;

  /**
   * 密码
   */
  @Column(name = "PWD", length = 50)
  private String pwd;

  /**
   * 昵称
   */
  @Column(name = "NICKNAME", length = 50)
  private String nickname;

  /**
   * 性别：1-男 2-女
   */
  @Column(name = "SEX")
  private int sex;

  /**
   * 手机号码
   */
  @Column(name = "PHONE", length = 11)
  private String phone;

  /**
   * 电子邮箱
   */
  @Column(name = "EMAIL", length = 50)
  private String email;

  /**
   * 创建者：来至用户表账号
   */
  @Column(name = "CREATOR", length = 20)
  private String creator;

  /**
   * 创建时间
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "CREATE_TIME")
  private Date createTime;

  /*
   * 卡号
   */
  @Column(name = "CardID", length = 50)
  private String cardID;

  /*
   * 账号类型 0:本地用户  1:portal用户
   */
  @Column(name = "account_type")
  private int accountType;

  /*
   * 工号
   */
  @Column(name = "MANAGER_NUMBER")
  private String managerNumber;



  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getOrgId() {
    return orgId;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }

  public String getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(String accountNo) {
    this.accountNo = accountNo;
  }

  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getCardID() {
    return cardID;
  }

  public void setCardID(String cardID) {
    this.cardID = cardID;
  }

  public int getAccountType() {
    return accountType;
  }

  public void setAccountType(int accountType) {
    this.accountType = accountType;
  }

  public String getManagerNumber() {
    return managerNumber;
  }

  public void setManagerNumber(String managerNumber) {
    this.managerNumber = managerNumber;
  }
}
