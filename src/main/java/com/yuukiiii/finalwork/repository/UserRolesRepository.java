package com.yuukiiii.finalwork.repository;

import com.yuukiiii.finalwork.model.URid;
import com.yuukiiii.finalwork.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yuukiiii
 * on 2018/4/15 15:00
 */


public interface UserRolesRepository extends JpaRepository<UserRoles,URid>{
}
