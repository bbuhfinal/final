package com.yuukiiii.finalwork.controller;

import com.yuukiiii.finalwork.model.Msg;
import com.yuukiiii.finalwork.model.Result;
import com.yuukiiii.finalwork.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yuukiiii
 * on 2018/3/21 14:14
 */

@RestController
public class ViewController {

    @Autowired
    MailUtil mailUtil;

    @RequestMapping(value = "/")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }


}
