package com.yuukiiii.finalwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})

public class Software {

  @Id
  @GeneratedValue
  private long softwareid;
  private String softwarename;
  private String softwaredscp;
  private long companyid;
  private double version;


  public long getSoftwareid() {
    return softwareid;
  }

  public void setSoftwareid(long softwareid) {
    this.softwareid = softwareid;
  }


  public String getSoftwarename() {
    return softwarename;
  }

  public void setSoftwarename(String softwarename) {
    this.softwarename = softwarename;
  }


  public String getSoftwaredscp() {
    return softwaredscp;
  }

  public void setSoftwaredscp(String softwaredscp) {
    this.softwaredscp = softwaredscp;
  }


  public long getCompanyid() {
    return companyid;
  }

  public void setCompanyid(long companyid) {
    this.companyid = companyid;
  }


  public double getVersion() {
    return version;
  }

  public void setVersion(double version) {
    this.version = version;
  }

}
