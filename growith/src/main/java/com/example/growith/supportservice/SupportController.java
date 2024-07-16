package com.example.growith.supportservice;

import com.example.growith.supportservice.contact.Contact;
import com.example.growith.supportservice.contact.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/support")
@RequiredArgsConstructor
@Controller
public class SupportController {
    private final ContactService contactService;

    @GetMapping("/contact")
    public String create() {
        return "support_contact";
    }

    @PostMapping("/contact")
    public String create(@ModelAttribute Contact contact) {
        contactService.craate(contact);
        return "support_announcements";
    }

    @GetMapping("/faq")
    public String faq() {
        return "support_faq";
    }

    @GetMapping("/aunnouncements")
    public String aunnouncements() {
        return "support_aunnouncements";
    }
}
