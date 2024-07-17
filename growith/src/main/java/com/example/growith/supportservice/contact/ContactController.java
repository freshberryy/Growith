package com.example.growith.supportservice.contact;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/support")
@RequiredArgsConstructor
@Controller
public class ContactController {
    private final ContactService contactService;

    @GetMapping("/contact")
    public String create() {
        return "support_contact";
    }

    @PostMapping("/contact")
    public String create(@ModelAttribute Contact contact) {
        contactService.create(contact);
        return "support_notice";
    }
}
