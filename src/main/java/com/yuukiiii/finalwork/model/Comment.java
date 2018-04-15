package com.yuukiiii.finalwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})

public class Comment {

  @Id
  @GeneratedValue
  private Integer commentid;
  private String commentword;
  private Integer parentid;
  private String commenttime;


  public Integer getCommentid() {
    return commentid;
  }

  public void setCommentid(Integer commentid) {
    this.commentid = commentid;
  }


  public String getCommentword() {
    return commentword;
  }

  public void setCommentword(String commentword) {
    this.commentword = commentword;
  }


  public Integer getParentid() {
    return parentid;
  }

  public void setParentid(Integer parentid) {
    this.parentid = parentid;
  }


  public String getCommenttime() {
    return commenttime;
  }

  public void setCommenttime(String commenttime) {
    this.commenttime = commenttime;
  }

}
