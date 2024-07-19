package com.example.growith.supportservice.contact;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

@RequiredArgsConstructor
@Service
public class SendMailService {
//    private final DynamicMailConfig dynamicMailConfig;
    private final JavaMailSender mailSender;

    private static final String EMAIL_TITLE_PREFIX = "Growith 문의사항: ";
    private static final Logger logger = LoggerFactory.getLogger(SendMailService.class);

    public void sendMail(Contact contact) throws MessagingException {
        String email = contact.getEmail();
//        String provider = email.substring(email.indexOf('@')+1, email.indexOf('.'));
//        JavaMailSender mailSender = dynamicMailConfig.getMailSender(provider);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");

        try {
            helper.setFrom("hs381717@naver.com", email);
        } catch (UnsupportedEncodingException e) {
            System.err.println("Encoding not supported: " + e.getMessage());
        }

        helper.setReplyTo(email);
        helper.setTo("hs381717@gmail.com");
        helper.setSubject(EMAIL_TITLE_PREFIX + "[" + contact.getType().getContent() + "] " + contact.getSubject());
        helper.setText(contact.getContent() + "\n\n" + "발신자: " + contact.getName() + "\n" +
                "연락처: " + contact.getPhone());

//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo("hs381717@naver.com");
//        message.setSubject(EMAIL_TITLE_PREFIX + "["+ contact.getType().getContent() + "] " + contact.getSubject());
//        message.setText(contact.getContent()+"\n\n"+"발신자: "+ contact.getName()+"\n"
//                +"연락처: "+ contact.getPhone());
//        message.setFrom(contact.getEmail());

        try {
            mailSender.send(message);
            logger.info("Email sent successfully to {}", "hs381717@gmail.com");
        } catch (MailSendException e) {
            logger.error("Failed to send Email: {}", e.getMessage());
        }
    }
}
