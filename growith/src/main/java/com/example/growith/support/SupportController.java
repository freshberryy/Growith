package com.example.growith.support;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/support")
@Controller
public class SupportController {
	
	@GetMapping("/announcements")
	public String announcements() {
		return "support_announcements";
	}

	@GetMapping("/contact")
	public String contact() {
		return "support_contact";
	}
	
	@PostMapping("/contact")
    public String submitContactForm(@RequestParam("name") String name,
                                    @RequestParam("email") String email,
                                    @RequestParam("content") String content,
                                    @RequestParam("phone") String phone,
                                    Model model) {
		return "support_contact";
	}

	@GetMapping("/faq")
	public String faq() {
		return "support_faq";
	}
}
