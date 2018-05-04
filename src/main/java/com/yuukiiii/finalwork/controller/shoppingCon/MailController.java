package com.yuukiiii.finalwork.controller.shoppingCon;

import com.yuukiiii.finalwork.enums.ResultEnum;
import com.yuukiiii.finalwork.model.Result;
import com.yuukiiii.finalwork.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

/**
 * Created by Yuukiiii
 * on 2018/4/16 19:34
 */

@RestController
@RequestMapping(value = "/mail")
public class MailController {
    @Autowired
    private JavaMailSender mailSender; //自动注入的Bean

    @Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数

    @GetMapping(value = "/mailtest")
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Sender);
        message.setTo(Sender); //自己给自己发送邮件
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }
}
//    @GetMapping(value = "/sendVerifyMail")
//    public Result sendVerifyMail(String username, String email){
//        username="lxh1";
//        StringBuffer sb = new StringBuffer();
//        sb.append("<h1>您好，这里是来自SubscriBE的认证邮件!</h1>");
//        sb.append("<h1>请您点击下方链接，既可完成认证: </h1>");
//        sb.append("<a href=\"localhost:8080/shopping/userVerify?username="+username+"\">确认链接</a>");
//        sb.append("localhost:8080/shopping/userVerify?username="+username);
//        MimeMessage message = null;
//        try {
//            message = mailSender.createMimeMessage();
//
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom(Sender);
//            helper.setTo(Sender);
//            helper.setSubject("测试一下");
//            helper.setText(sb.toString(), true);
//
//            mailSender.send(message);
//
//            return ResultUtil.success("邮件发送成功！");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResultUtil.Error(ResultEnum.SEND_MAIL_FAIL);
//        }
//    }
