package com.example.growith.supportservice.faq;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/support")
@RequiredArgsConstructor
@Controller
public class FaqController {
    private final FaqService faqService;

    @GetMapping("/faq")
    public String faq(Model model) {
        model.addAttribute("faqs", faqService.readList());
        return "support_faq";
    }
}
