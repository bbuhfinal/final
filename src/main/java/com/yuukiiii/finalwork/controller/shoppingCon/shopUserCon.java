package com.yuukiiii.finalwork.controller.shoppingCon;

import com.yuukiiii.finalwork.enums.ResultEnum;
import com.yuukiiii.finalwork.model.Result;
import com.yuukiiii.finalwork.model.User;
import com.yuukiiii.finalwork.service.UserService;
import com.yuukiiii.finalwork.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;

/**
 * Created by Yuukiiii
 * on 2018/4/13 15:07
 */

@Controller
@RequestMapping(value = "/shopping")
public class shopUserCon {

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender mailSender; //自动注入的Bean


    @Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数

    @PostMapping(value = "/userRegister")
    @ResponseBody
    public Result userRegister(Model model,
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

        boolean b = sendVerifyMail(user1.getUsername(),user1.getEmail());
        if (b==true)
            return ResultUtil.success("注册成功");
        else
            return ResultUtil.Error(ResultEnum.REGISTER_FAIL2);
    }

    @GetMapping(value = "/userVerify")
    @ResponseBody
    public Result userVerify(@RequestParam("username") String username){
        User user = userService.userVerify(username);
        if (user==null)
            return ResultUtil.Error(ResultEnum.UPDATE_FAIL);
        return ResultUtil.success(user);
    }

    public boolean sendVerifyMail(String username, String email){
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>您好，这里是来自SubscriBE的认证邮件!</h1>");
        sb.append("<h1>请您点击下方链接，既可完成认证: </h1>");
        sb.append("<a href=\"localhost:8080/shopping/userVerify?username="+username+"\">确认链接</a>");
        sb.append("localhost:8080/shopping/userVerify?username="+username);
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(Sender);
            helper.setTo(email);
            helper.setSubject("测试一下");
            helper.setText(sb.toString(), true);

            mailSender.send(message);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping(value = "/userLogin")
    public String userLogin(@RequestParam(value = "username") String username,
                            @RequestParam(value = "password") String password,
                            Model model){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        boolean b = userService.checklogin(username,password);
        if (b==true) {
            model.addAttribute("username", username);
            return "index";
        }
        else{
            model.addAttribute("msg", "登录信息有误，请重新登录!");
            return "error";
        }
    }
}
