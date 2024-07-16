package com.example.growith.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/support")
@Controller
public class SupportController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/announcements")
	public String announcements(Model model) {
		
		model.addAttribute("notices", noticeService.readList());
		
		return "support_announcements";
	}
	
	@GetMapping("/announcements/readdetail/{id}")
	public String readdetail(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("notice", noticeService.readdetail(id));
		return "support_announcements_readdetail";
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
