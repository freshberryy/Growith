package com.example.growith.supportservice.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/support")
@RequiredArgsConstructor
@Controller
public class FaqController {
	
	@Autowired
    private final FaqService faqService;

	@GetMapping("/faqlist")
	public String faq(Model model) {
		
		model.addAttribute("faqs", faqService.readList());
		
		return "support_faq";
	}
	
	@GetMapping("/faq/readdetail/{id}")
	public String readdetail(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("faqs", faqService.readdetail(id));
		return "support_faq_readdetail";
	}
}
