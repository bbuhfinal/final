package com.yuukiiii.finalwork.service;

import java.util.List;
import com.yuukiiii.finalwork.model.UserMoney;
import com.yuukiiii.finalwork.repository.UserMoneyRepository;
import com.yuukiiii.finalwork.repository.UserRepository;
import com.yuukiiii.finalwork.repository.UserSftwrComRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yuukiiii
 * on 2018/4/12 14:56
 */

@Service
public class UserMoneyService {

    @Autowired
    private UserMoneyRepository userMoneyRepository;

    @Autowired
    private UserRepository userRepository;

    public UserMoney addMoney(UserMoney userMoney){
        return userMoneyRepository.save(userMoney);
    }

    public void deleteUserMoneyById(Integer umid){
        userMoneyRepository.deleteById(umid);
    }

    public List<UserMoney> getAllUserMoney(){
        return userMoneyRepository.findAll();
    }

    public UserMoney getOneUserMoneyById(Integer umid){
        return userMoneyRepository.getOne(umid);
    }

    public UserMoney updateUserMoney(UserMoney userMoney){
        return userMoneyRepository.save(userMoney);
    }

}
