package com.library.system.util;

import com.library.system.config.EmailSendConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
    private static final Logger log = LoggerFactory.getLogger(EmailUtil.class);

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailUtil(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * 发送邮件
     *
     * @param userEmail 收件人
     * @param content 邮件内容
     * @param title 邮件标题
     */
    public void sendFromEmail(String userEmail, String content, String title) {
        SimpleMailMessage message  = new SimpleMailMessage();
        //收件人邮箱地址
        message.setTo(userEmail);
        //邮件主题
        message.setSubject(title);
        //邮件正文
        message.setText(content);
        //发件人
        message.setFrom(EmailSendConfig.getFrom());
        try {
            javaMailSender.send(message);
            log.info("邮件发送成功！");
        } catch (MailException e) {
            log.error("邮件发送失败：", e);
            // 处理邮件发送失败的情况
            throw new RuntimeException("邮件配置信息不存在");
        }
    }
}
