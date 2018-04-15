package com.yuukiiii.finalwork.controller.shoppingCon;

import com.yuukiiii.finalwork.model.Result;
import com.yuukiiii.finalwork.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yuukiiii
 * on 2018/4/15 17:00
 */

@RestController
@RequestMapping(value = "/utils")
public class UtilController {

    @Autowired
    MailUtil mailUtil;

    @GetMapping(value = "/sendVerifyMail")
    public Result sendVerifyMail(String username,String email){
        System.out.println("test1");
        MailUtil mailUtil = new MailUtil();
        return mailUtil.sendVerifyMail(username,email);
    }
}
