package com.yuukiiii.finalwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})

public class BuyType {

  @Id
  @GeneratedValue
  private Integer btid;
  private Integer buytypedays;
  private Integer price;
  private Integer softwareid;


  public Integer getBtid() {
    return btid;
  }

  public void setBtid(Integer btid) {
    this.btid = btid;
  }


  public Integer getBuytypename() {
    return buytypedays;
  }

  public void setBuytypename(Integer buytypedays) {
    this.buytypedays = buytypedays;
  }


  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }


  public Integer getSoftwareid() {
    return softwareid;
  }

  public void setSoftwareid(Integer softwareid) {
    this.softwareid = softwareid;
  }

}
