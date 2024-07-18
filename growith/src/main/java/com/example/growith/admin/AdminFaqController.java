package com.example.growith.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.growith.supportservice.faq.Faq;
import com.example.growith.supportservice.faq.FaqService;

import lombok.RequiredArgsConstructor;

@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/admin/faq")
@RequiredArgsConstructor
@Controller
public class AdminFaqController {
	
	@Autowired
    private final FaqService faqService;

    @GetMapping("/create")
    public String faqCreate() {
        return "admin_faq_create";
    }

    @PostMapping("/create")
    public String faqCreate(@ModelAttribute Faq faq) {
        faqService.create(faq);
        return "redirect:/admin/faq";
    }

    @GetMapping("/delete/faqID={id}")
    public String faqDelete(@PathVariable("id") Integer id) {
        faqService.delete(id);
        return "redirect:/admin/faq";
    }

    @GetMapping("/update/faqID={id}")
    public String faqUpdate(@PathVariable("id") Integer id, Model model) {
        Faq faq = faqService.readdetail(id);
        model.addAttribute("faq", faq);
        return "admin/faq/update";
    }

    @PostMapping("/update/faqID={id}")
    public String faqUpdate(@ModelAttribute Faq faq, @PathVariable("id") Integer id) {
        faqService.create(faq);
        return "redirect:/admin/faq/detail/faqID=" + id;
    }
}

