package com.boot.boot_email.controller;

import com.boot.boot_email.mail.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author : kaifa
 * create at:  2019-11-11  14:05
 * @description: email测试
 */
@RestController
@RequestMapping("email")
public class MailController {


    @Autowired
    private MailUtil mailUtil;

    /**
     * 发送邮件
     * @param email 邮箱
     * @param title 主题
     * @param context 内容
     * @throws Exception
     */
    @RequestMapping("simpleMail")
    public void sendSimpleMai(String email,String title,String context) throws Exception{
        mailUtil.sendSimpleMail(email,title,context);
    }

    /**
     * 发送图片
     * @param email 邮箱
     * @throws Exception
     */
    @RequestMapping("imgMail")
    public void sendImageMail(String email) throws Exception{

        String srcId = "harryImage";
        String htmlContent = "<html><body><h3>this is a image:</h3> <img src = \'cid:{srcId}\'></body></html>".replace("{srcId}",srcId);
        mailUtil.sendImageMail(email,"主题",htmlContent,ResourceUtils.getURL("classpath:static/images/heng.png").getPath(),srcId);
    }

    /**
     * 根据自定义模板发送 验证码
     * @param email
     * @throws Exception
     */
    @RequestMapping("tempMail")
    public  void sendTemplateMail(String email) throws Exception{
        Map<String,Object> map =new HashMap<>();
        map.put("randomvalue",new Random().nextInt(999999));
        mailUtil.sendTemplateMail(email,"测试",map,"emailTemplate");
    }

    /**
     * 发送邮件携带配件
     * @param email
     * @throws Exception
     */
    @RequestMapping("attachmentMail")
    public  void sendOnlyAttachmentMail(String email) throws Exception{
        mailUtil.sendOnlyAttachmentMail(email,"测试","带附件email",ResourceUtils.getURL("classpath:static/file/emailTest.xls").getPath());
    }
}
