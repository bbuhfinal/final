package com.yuukiiii.finalwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})

public class Order {

  @Id
  @GeneratedValue
  private Integer orderid;
  private Integer userid;
  private String orderdate;
  private Integer btid;
  private Integer status;
  private Integer btcount;


  public Integer getOrderid() {
    return orderid;
  }

  public void setOrderid(Integer orderid) {
    this.orderid = orderid;
  }


  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }


  public String getOrderdate() {
    return orderdate;
  }

  public void setOrderdate(String orderdate) {
    this.orderdate = orderdate;
  }


  public Integer getBtid() {
    return btid;
  }

  public void setBtid(Integer btid) {
    this.btid = btid;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  public Integer getBtcount() {
    return btcount;
  }

  public void setBtcount(Integer btcount) {
    this.btcount = btcount;
  }

}
