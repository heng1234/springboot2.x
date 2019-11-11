package com.boot.boot_email.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : kaifa
 * create at:  2019-11-11  13:48
 * @description: springboot集成发送邮箱根工具类
 */
@Component
public class MailUtil {


    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailSender sender;

    @Resource
    private TemplateEngine templateEngine;

    /**
     * 这是发送一个文本邮件
     * @param to 发送目标邮箱
     * @param subject 标题
     * @param content 内容
     * @throws Exception
     */
   
    public void sendSimpleMail(String to,String subject,String content) throws Exception{
        SimpleMailMessage mail =new SimpleMailMessage();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(content);
        mail.setFrom(from);
        sender.send(mail);
    }

    /**
     * 发送html邮件
     * @param to 目标邮箱
     * @param subject 标题
     * @param content 内容可以存放html
     * @throws Exception
     */
   
    public void sendHtmlMail(String to , String subject , String content) throws Exception{
        MimeMessage message =mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper =new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }



    /**
     * 带有附件的邮件
     * @param to 接收地址
     * @param subject 标题
     * @param content 内容
     * @param filePath 文件路径
     * @throws Exception
     */
    public void sendOnlyAttachmentMail(String to ,String subject,String content , String filePath) throws Exception{

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            FileSystemResource file =new FileSystemResource(new File(filePath));
            String fileName = file.getFilename();
            helper.addAttachment(fileName,file);
            //helper.addAttachment(fileName+"_test",file);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 带有多个附件的邮件
     * @param to 目标邮箱
     * @param subject 标题
     * @param content 内容
     * @param filePathList 文件路径集合
     * @throws Exception
     */
   
    public void sendAttachmentsMail(String to , String subject, String content , List<String> filePathList) throws Exception{

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            FileSystemResource file = null;
            for(String filePath : filePathList){
                file =new FileSystemResource(new File(filePath));
                String fileName = file.getFilename();
                helper.addAttachment(fileName,file);
                helper.addAttachment(fileName+"_test",file);
            }

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 带有图片的邮件
     * @param to 目标邮箱
     * @param subject 主题
     * @param content 内容
     * @param filePath 文件路径
     * @param srcId 图片id
     * @throws Exception
     */
   
    public void sendImageMail(String to ,String subject,String content , String filePath,String srcId) throws Exception{

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            FileSystemResource file =new FileSystemResource(new File(filePath));
            helper.addInline(srcId,file);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     *  携带多个图片的邮件
     * @param to 目标邮箱
     * @param subject 内容
     * @param content 内容
     * @param filePathList 文件路径集合
     * @param srcIdList 图片id集合
     * @throws Exception
     */
   
    public void sendImagesMail(String to ,String subject,String content , List<String> filePathList,List<String> srcIdList) throws Exception{

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            for(int i =0;i<srcIdList.size();i++){
                FileSystemResource file =new FileSystemResource(new File(filePathList.get(i)));
                helper.addInline(srcIdList.get(i),file);
            }

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 使用html模版进行发送邮件
     * @param to 目标邮箱
     * @param subject 标题
     * @param map map 用于模板里读取map数据 模板读取比如th:text="${randomvalue}"
     * @param templateName 目标名称 比如emailTemplate对应emailTemplate.html
     * @throws Exception
     */
   
    public void sendTemplateMail(String to , String subject, Map<String,Object> map , String templateName) throws Exception{
        Context context = new Context();
        Set<String> keyList =map.keySet();
        for(String key:keyList){
            context.setVariable(key, map.get(key));
        }
        String templateContext = templateEngine.process(templateName,context);
        sendHtmlMail(to,subject,templateContext);
    }
}
