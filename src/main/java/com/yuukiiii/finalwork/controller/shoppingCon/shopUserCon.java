package com.yuukiiii.finalwork.controller.shoppingCon;

import com.yuukiiii.finalwork.enums.ResultEnum;
import com.yuukiiii.finalwork.model.Result;
import com.yuukiiii.finalwork.model.User;
import com.yuukiiii.finalwork.service.UserService;
import com.yuukiiii.finalwork.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yuukiiii
 * on 2018/4/13 15:07
 */

@Controller
@RequestMapping(value = "/shopping")
public class shopUserCon {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/userRegister")
    public String userRegister(Model model,
                               @RequestParam(value = "username") String username,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value = "password") String password){

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        User user1 = userService.addUser(user,2);

        model.addAttribute("username",user1.getUsername());
        model.addAttribute("email",user1.getEmail());

        return "checkmail";
    }

    @GetMapping(value = "/userVerify")
    @ResponseBody
    public Result userVerify(@RequestParam("username") String username){
        User user = userService.userVerify(username);
        if (user==null)
            return ResultUtil.Error(ResultEnum.UPDATE_FAIL);
        return ResultUtil.success(user);
    }
}
