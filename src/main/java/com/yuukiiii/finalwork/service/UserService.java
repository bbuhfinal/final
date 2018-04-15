package com.yuukiiii.finalwork.service;

import java.util.List;

import com.yuukiiii.finalwork.model.URid;
import com.yuukiiii.finalwork.model.User;
import com.yuukiiii.finalwork.model.UserRoles;
import com.yuukiiii.finalwork.repository.UserRepository;
import com.yuukiiii.finalwork.repository.UserRolesRepository;
import com.yuukiiii.finalwork.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Yuukiiii
 * on 2018/4/12 14:50
 */

@Transactional
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Transactional
    public User addUser(User user,Integer roleid){
        System.out.println(1);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(user.getPassword());
        user.setPassword(encode);
        user.setCredit(0.0);
        user.setEmailVerified("0");
        user.setDatecreated(new DateUtil().getDateString());


        user = userRepository.save(user);

        System.out.println(1);
        UserRoles userRoles = new UserRoles();
        userRoles.setRoles_roleid(roleid);
        userRoles.setUser_userid(user.getUserid());

        userRolesRepository.save(userRoles);

        System.out.println(1);

        return user;
    }

    public User userVerify(String username){
        User user = userRepository.findByUsername(username);
        user.setEmailVerified("1");
        return userRepository.save(user);
    }

    public void deleteUserById(Integer userid){
        userRepository.deleteById(userid);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getOneUserById(Integer userid){
        return userRepository.getOne(userid);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        logger.debug("name is ______________"+name+"------------------");
        User user = userRepository.findByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return user;
    }
}
