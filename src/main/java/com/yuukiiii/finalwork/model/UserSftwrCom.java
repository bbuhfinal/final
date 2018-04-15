package com.yuukiiii.finalwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})

public class UserSftwrCom {

  @Id
  @GeneratedValue
  private Integer uscid;
  private Integer userid;
  private Integer softwareid;
  private Integer commentid;


  public Integer getUscid() {
    return uscid;
  }

  public void setUscid(Integer uscid) {
    this.uscid = uscid;
  }


  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }


  public Integer getSoftwareid() {
    return softwareid;
  }

  public void setSoftwareid(Integer softwareid) {
    this.softwareid = softwareid;
  }


  public Integer getCommentid() {
    return commentid;
  }

  public void setCommentid(Integer commentid) {
    this.commentid = commentid;
  }

}
