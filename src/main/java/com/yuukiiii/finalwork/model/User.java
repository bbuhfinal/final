package com.yuukiiii.finalwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class User implements UserDetails{

  @Id
  @GeneratedValue
  private Integer userid;
  private String email;
  private String password;
  private String username;
  private Double credit;
  private String emailVerified;
  private String datecreated;

  @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
  private List<Role> roles;

  //getters and setters

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> auths = new ArrayList<>();
    List<Role> roles = this.getRoles();
    for (Role role : roles) {
      auths.add(new SimpleGrantedAuthority(role.getRolename()));
    }
    return auths;

  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    if (this.getEmailVerified()=="1")
      return true;
    else
      return false;
  }


  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public void setUsername(String username) {
    this.username = username;
  }


  public Double getCredit() {
    return credit;
  }

  public void setCredit(Double credit) {
    this.credit = credit;
  }


  public String getEmailVerified() {
    return emailVerified;
  }

  public void setEmailVerified(String emailVerified) {
    this.emailVerified = emailVerified;
  }


  public String getDatecreated() {
    return datecreated;
  }

  public void setDatecreated(String datecreated) {
    this.datecreated = datecreated;
  }


  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }
}


