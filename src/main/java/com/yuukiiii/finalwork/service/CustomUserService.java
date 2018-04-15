package com.yuukiiii.finalwork.service;

import com.yuukiiii.finalwork.model.User;
import com.yuukiiii.finalwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Yuukiiii
 * on 2018/4/12 18:24
 */


public class CustomUserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("name:"+name);
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }
}
