package com.example.ylye.utils;

import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * 邮件业务类
 * @author qzz
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MailService {

    /**
     * 注入邮件工具类
     */

    private final JavaMailSenderImpl javaMailSender;

    @Value("${spring.mail.username}")
    private String sendMailer;

    /**
     * 检测邮件信息类
     * @param to
     * @param subject
     * @param text
     */
    @Async
    public  void checkMail(String to,String subject,String text){
        if(StrUtil.isEmpty(to)){
            throw new RuntimeException("邮件收信人不能为空");
        }
        if(StrUtil.isEmpty(subject)){
            throw new RuntimeException("邮件主题不能为空");
        }
        if(StrUtil.isEmpty(text)){
            throw new RuntimeException("邮件内容不能为空");
        }
    }

    /**
     * 发送纯文本邮件
     * @param to
     */

    private final  StringRedisTemplate redisTemplate;
    //表示这个方法是一个异步任务
    @Async
    @Transactional
    public void sendTextMailMessage(String to,String text){
//        String subject = "验证码";
//        String text = RandomUtil.randomNumbers(6);
        try {
            //true 代表支持复杂的类型
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(javaMailSender.createMimeMessage(),true);
            //邮件发信人
            mimeMessageHelper.setFrom(sendMailer);
            //邮件收信人  1或多个
            mimeMessageHelper.setTo(to.split(","));
            //邮件主题
            mimeMessageHelper.setSubject("验证码");
            //邮件内容
            mimeMessageHelper.setText("您的验证码为"+text+"有效期为5分钟");
            System.out.println(new Date());
            //邮件发送时间
            mimeMessageHelper.setSentDate(new Date());

            //使用redis的办法 存入redis 设置过期时间
        //    redisTemplate.opsForValue().set("code",text,5, TimeUnit.MINUTES);
            // 发送邮件
            javaMailSender.send(mimeMessageHelper.getMimeMessage());

            // System.out.println("发送邮件成功："+sendMailer+"->"+to);
//            Code code = new Code(to,text);
            //把验证码存入数据库中
//            codeService.save(code);

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("发送邮件失败："+e.getMessage());
        }
    }

    /**
     * 禁用用户
     * @param to 发送给谁

     */
    @Async
    @Transactional
    public void sendBan(String to){
        try {


            //true 代表支持复杂的类型
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(javaMailSender.createMimeMessage(),true);
            //邮件发信人
            mimeMessageHelper.setFrom(sendMailer);
            //邮件收信人  1或多个
            mimeMessageHelper.setTo(to.split(","));
            //邮件主题
            mimeMessageHelper.setSubject("禁用用户");
            String html = "<html>\n" +
                    "<body>\n" +
                    "<p>点击下方链接即可禁用当前用户的发布功能</p>" +
                    "<a href='http://localhost:9000/user/ban?email="+to+"'>点击禁用</a>" +
                    "</body>" +
                    "</html>";
            //邮件内容
            mimeMessageHelper.setText(html,true);
            System.out.println(new Date());
            //邮件发送时间
            mimeMessageHelper.setSentDate(new Date());

            javaMailSender.send(mimeMessageHelper.getMimeMessage());

            // System.out.println("发送邮件成功："+sendMailer+"->"+to);
//            Code code = new Code(to,text);
            //把验证码存入数据库中
//            codeService.save(code);

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("发送邮件失败："+e.getMessage());
        }
    }

    /**
     *
     * @param address 发送给谁
     */
    @Async
    public void sendMsg(String address){
        try {

            //true 代表支持复杂的类型
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(javaMailSender.createMimeMessage(),true);
            //邮件发信人
            mimeMessageHelper.setFrom(sendMailer);
            //邮件收信人  1或多个
            mimeMessageHelper.setTo(address.split(","));
            //邮件主题
            mimeMessageHelper.setSubject("评论提示");
            String html = "有人给你的博客发送信息的快去查看一下吧。";
            //邮件内容
            mimeMessageHelper.setText(html,true);
            System.out.println(new Date());
            //邮件发送时间
            mimeMessageHelper.setSentDate(new Date());

            javaMailSender.send(mimeMessageHelper.getMimeMessage());
        }catch (MessagingException e){
            e.printStackTrace();
            System.out.println("发送邮件失败："+e.getMessage());
        }
    }
}

