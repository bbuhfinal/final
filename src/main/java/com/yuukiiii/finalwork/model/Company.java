package com.yuukiiii.finalwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})

public class Company {

  @Id
  @GeneratedValue
  private Integer companyid;
  private String companyname;
  private String companyaddress;


  public Integer getCompanyid() {
    return companyid;
  }

  public void setCompanyid(Integer companyid) {
    this.companyid = companyid;
  }


  public String getCompanyname() {
    return companyname;
  }

  public void setCompanyname(String companyname) {
    this.companyname = companyname;
  }


  public String getCompanyaddress() {
    return companyaddress;
  }

  public void setCompanyaddress(String companyaddress) {
    this.companyaddress = companyaddress;
  }

}
