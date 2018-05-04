package com.yuukiiii.finalwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {

  @Id
  @GeneratedValue
  private Integer tagid;
  private String tagname;


  public Integer getTagid() {
    return tagid;
  }

  public void setTagid(Integer tagid) {
    this.tagid = tagid;
  }


  public String getTagname() {
    return tagname;
  }

  public void setTagname(String tagname) {
    this.tagname = tagname;
  }

}
