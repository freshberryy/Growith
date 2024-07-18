package com.example.growith;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class DynamicMailConfig {
    private final Environment environment;

    public JavaMailSender getMailSender(String provider) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(environment.getProperty("spring.mail.host." + provider));

        String port = environment.getProperty("spring.mail.port" + provider);
        if (port != null) {
            mailSender.setPort(Integer.parseInt(port));
        }


        mailSender.setUsername(environment.getProperty("spring.mail.username." + provider));
        mailSender.setPassword(environment.getProperty("spring.mail.password." + provider));

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.auth", environment.getProperty("spring.mail.properties.mail.smtp.auth." + provider, "true"));
        properties.put("mail.smtp.starttls.enable", environment.getProperty("spring.mail.properties.mail.smtp.starttls.enable." + provider, "true"));
        properties.put("mail.smtp.ssl.enable", environment.getProperty("spring.mail.properties.mail.smtp.ssl.enable." + provider, "true"));

        properties.put("mail.smtp.timeout", environment.getProperty("spring.mail.properties.mail.smtp.timeout", "5000"));
        properties.put("mail.debug", environment.getProperty("spring.mail.properties.mail.debug", "true"));

        return mailSender;
    }
}
