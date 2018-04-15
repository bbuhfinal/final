package com.yuukiiii.finalwork.repository;

import com.yuukiiii.finalwork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yuukiiii
 * on 2018/4/12 13:24
 */


public interface UserRepository extends JpaRepository<User,Integer>{

    public User findByUsername(String username);
}
