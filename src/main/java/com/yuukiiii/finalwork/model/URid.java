package com.yuukiiii.finalwork.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Yuukiiii
 * on 2018/4/15 14:38
 */

@Embeddable
public class URid implements Serializable{

    private Integer user_userid;

    private Integer roles_roleid;

    public URid() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof URid)) return false;
        URid uRid = (URid) o;
        return Objects.equals(getUser_userid(), uRid.getUser_userid()) &&
                Objects.equals(getRoles_roleid(), uRid.getRoles_roleid());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUser_userid(), getRoles_roleid());
    }
}
