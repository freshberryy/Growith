package com.example.growith.supportservice.contact;

import com.example.growith.DynamicMailConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.Level;

@RequiredArgsConstructor
@Service
public class SendMailService {
    private final DynamicMailConfig dynamicMailConfig;

    private static final String EMAIL_TITLE_PREFIX = "Growith 문의사항: ";
    private static final Logger logger = LoggerFactory.getLogger(SendMailService.class);

    public void sendMail(Contact contact) {
        String email = contact.getEmail();
        String provider = email.substring(email.indexOf('@')+1, email.indexOf('.'));

        JavaMailSender mailSender = dynamicMailConfig.getMailSender(provider);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("hs381717@naver.com");
        message.setSubject(EMAIL_TITLE_PREFIX + "["+ contact.getType().getContent() + "] " + contact.getSubject());
        message.setText(contact.getContent()+"\n\n"+"발신자: "+ contact.getName()+"\n"
                +"연락처: "+ contact.getPhone());
        message.setFrom(contact.getEmail());

        try {
            mailSender.send(message);
            logger.info("Email sent successfully to {}", "hs381717@naver.com");
        } catch (MailSendException e) {
            logger.error("Failed to send Email: {}", e.getMessage());
        }
    }
}
