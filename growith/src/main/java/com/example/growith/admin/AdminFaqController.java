package com.example.growith.admin;

import java.util.List;

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
import com.example.growith.supportservice.notice.Notice;

import lombok.RequiredArgsConstructor;

@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/admin/faq")
@RequiredArgsConstructor
@Controller
public class AdminFaqController {
    private final AdminFaqService adminFaqService;
    
    
    @GetMapping("/manager")
    public String getFaqList(Model model) {
        List<Faq> faqList = adminFaqService.getAllFaqs();
        model.addAttribute("faqs", faqList);
        return "admin_faq_manager";
    }
    
    @GetMapping("/create")
    public String faqCreate(Model model) {
    	model.addAttribute("faqs", new Faq());
        return "admin_faq_create";
    }

    @PostMapping("/create")
    public String faqCreate(@ModelAttribute Faq faq) {
        adminFaqService.createFaq(faq);
        return "redirect:/admin/faq/manager";
    }

    @GetMapping("/delete/faqID={id}")
    public String faqDelete(@PathVariable("id") Integer id) {
        adminFaqService.deleteFaq(id);
        return "redirect:/admin/faq/manager";
    }

    @GetMapping("/update/faqID={id}")
    public String faqUpdate(@PathVariable("id") Integer id, Model model) {
    	Faq faq = adminFaqService.getFaq(id);
        model.addAttribute("faq", faq);
        return "admin_faq_create";
    }

    @PostMapping("/update")
    public String faqUpdate(@ModelAttribute Faq faq) {
        adminFaqService.updateFaq(faq);
        return "redirect:/admin/faq/manager";
    }
}

