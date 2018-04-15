package com.yuukiiii.finalwork.model;

import javax.persistence.*;

@Entity
@IdClass(URid.class)
@Table(name = "user_roles")

public class UserRoles {

    @Id
    private Integer user_userid;
    @Id
    private Integer roles_roleid;

    public Integer getUser_userid() {
        return user_userid;
    }

    public void setUser_userid(Integer user_userid) {
        this.user_userid = user_userid;
    }

    public Integer getRoles_roleid() {
        return roles_roleid;
    }

    public void setRoles_roleid(Integer roles_roleid) {
        this.roles_roleid = roles_roleid;
    }
}
