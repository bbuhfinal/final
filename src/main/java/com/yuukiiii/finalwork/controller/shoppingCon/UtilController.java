package com.yuukiiii.finalwork.controller.shoppingCon;

import com.yuukiiii.finalwork.model.Result;
import com.yuukiiii.finalwork.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result sendVerifyMail(@RequestParam("username") String username,
                                 @RequestParam("email") String email) throws Exception {
        System.out.println("test1");
        MailUtil mailUtil = new MailUtil();
        return mailUtil.sendVerifyMail(username,email);
    }


}
