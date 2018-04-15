package com.yuukiiii.finalwork.utils;

import com.yuukiiii.finalwork.enums.ResultEnum;
import com.yuukiiii.finalwork.model.Result;
import com.yuukiiii.finalwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * Created by Yuukiiii
 * on 2018/4/14 19:37
 */

@Service
public class MailUtil {
    @Autowired
    JavaMailSender mailSender;

    @Autowired
    UserRepository userRepository;

    @Value("${spring.mail.username}")
    private String from;


    public Result sendSimpleEmail(String to,String title,String text)
    {
        try
        {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
//            message.setTo("1249794581@qq.com");
//            message.setSubject("这是测试邮件");
//            message.setText("这是测试邮件的内容 恭喜你");
            message.setTo(to);
            message.setSubject(title);
            message.setText(text);
            mailSender.send(message);
            return ResultUtil.success("邮件发送成功！");

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ResultUtil.Error(ResultEnum.SEND_MAIL_FAIL);
        }
    }

    public Result sendVerifyMail(String username,String email){
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>您好，这里是来自SubscriBE的认证邮件!</h1>");
        sb.append("<h1>请您点击下方链接，既可完成认证: </h1>");
        sb.append("<a href=\"localhost:8080/shopping/userVerify?username=\""+username+">确认链接</a>");
        return sendHtmlMail(email,"这是来自SubsriBE的认证邮件",sb.toString());
    }

    public Result sendHtmlMail(String to,String title,String text) {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(title);

//            StringBuffer sb = new StringBuffer();
//            sb.append("<h1>大标题-h1</h1>")
//                    .append("<p style='color:#F00'>红色字</p>")
//                    .append("<p style='text-align:right'>右对齐</p>");
            helper.setText(text, true);
            mailSender.send(message);

            return ResultUtil.success("邮件发送成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.Error(ResultEnum.SEND_MAIL_FAIL);
        }
    }



}
