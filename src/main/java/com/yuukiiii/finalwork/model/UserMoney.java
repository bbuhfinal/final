package com.yuukiiii.finalwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})

public class UserMoney {

  @Id
  @GeneratedValue
  private Integer umid;
  private Integer userid;
  private String umtime;
  private Double ummoney;


  public Integer getUmid() {
    return umid;
  }

  public void setUmid(Integer umid) {
    this.umid = umid;
  }


  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }


  public String getUmtime() {
    return umtime;
  }

  public void setUmtime(String umtime) {
    this.umtime = umtime;
  }


  public Double getUmmoney() {
    return ummoney;
  }

  public void setUmmoney(Double ummoney) {
    this.ummoney = ummoney;
  }

}
