package com.yuukiiii.finalwork.model;

/**
 * Created by Yuukiiii
 * on 2018/4/12 09:56
 */


public class BigComment {
    private Comment comment;
    private Integer userid;
    private String username;
    private Integer softwareid;
    private String softwarename;

    public BigComment(Comment comment) {
        this.comment = comment;
    }

    public BigComment() {
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSoftwareid() {
        return softwareid;
    }

    public void setSoftwareid(Integer softwareid) {
        this.softwareid = softwareid;
    }

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }
}
