package com.yuukiiii.finalwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SftwrTag {
  @Id
  @GeneratedValue
  private Integer sftwrtagid;
  private Integer softwareid;
  private Integer tagid;


  public Integer getSftwrtagid() {
    return sftwrtagid;
  }

  public void setSftwrtagid(Integer sftwrtagid) {
    this.sftwrtagid = sftwrtagid;
  }


  public Integer getSoftwareid() {
    return softwareid;
  }

  public void setSoftwareid(Integer softwareid) {
    this.softwareid = softwareid;
  }


  public Integer getTagid() {
    return tagid;
  }

  public void setTagid(Integer tagid) {
    this.tagid = tagid;
  }

}
