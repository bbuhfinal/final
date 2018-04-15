package com.yuukiiii.finalwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Yuukiiii
 * on 2018/4/12 15:25
 */

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Integer roleid;

    private String rolename;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
