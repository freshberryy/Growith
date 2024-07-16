package com.example.growith.supportservice.faq;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/support")
@RequiredArgsConstructor
@Controller
public class FaqController {
    private final FaqService faqService;

    @GetMapping("/faqlist")
    public String faq(@ModelAttribute Faq faq, Model model) {
        model.addAttribute("faqList", faqService.getAllFaq());
        return "support_faq";
    }
}
