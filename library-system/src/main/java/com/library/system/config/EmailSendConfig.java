package com.library.system.config;

import com.library.common.util.EncryptUtil;
import com.library.system.modules.emailconfig.entity.EmailConfig;
import com.library.system.modules.emailconfig.service.EmailConfigService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Log4j2
@Configuration
public class EmailSendConfig {

    private final EmailConfigService emailConfigService;

    private static String from;

    @Autowired
    public EmailSendConfig(EmailConfigService emailConfigService) {
        this.emailConfigService = emailConfigService;
    }

    public static String getFrom() {
        return from;
    }

    @Bean
    @ConditionalOnMissingBean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        try {
            EmailConfig sendEmail = emailConfigService.getSendEmail();
            if (sendEmail != null) {
                // 设置邮件服务器主机名
                mailSender.setHost(sendEmail.getHost());
                // 设置邮件服务器端口号
                mailSender.setPort(Integer.parseInt(sendEmail.getPort()));
                // 设置邮件发送者的邮箱
                from = sendEmail.getFromUser();
                mailSender.setUsername(from);
                // 设置邮件发送者的密码
                mailSender.setPassword(EncryptUtil.desDecrypt(sendEmail.getPass()));
                mailSender.setDefaultEncoding("UTF-8");
                Properties properties = mailSender.getJavaMailProperties();
                properties.setProperty("mail.smtp.timeout", "5000");
                properties.setProperty("mail.smtp.auth", "true");
                properties.setProperty("mail.smtp.starttls.enable", "true");
                properties.setProperty("mail.smtp.starttls.required", "true");
            }
        } catch (Exception e) {
            log.error("邮件发送属性配置失败！", e);
        }
        return mailSender;
    }
}
