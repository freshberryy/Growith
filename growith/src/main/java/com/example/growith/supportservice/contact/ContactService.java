package com.example.growith.supportservice.contact;

import com.example.growith.supportservice.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ContactService {
    private final ContactRepository contactRepository;

    private final JavaMailSender mailSender;
    private static final String EMAIL_TITLE_PREFIX = "[Growith] 문의사항: ";

    public void craate(Contact contact) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("hs381717@gmail.com");
        message.setSubject(EMAIL_TITLE_PREFIX + contact.getType());
        message.setText(contact.getContent()+"\n\n"+"발신자: "+ contact.getName()+"\n"
                +"연락처: "+ contact.getPhone());
        message.setFrom(contact.getEmail());

        mailSender.send(message);

        contact.setDate(LocalDateTime.now());
        contactRepository.save(contact);
    }

    public void get(Integer id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            contactRepository.delete(contact.get());
        } else {
            throw new DataNotFoundException("문의사항을 찾을 수 없습니다.");
        }
    }
}
