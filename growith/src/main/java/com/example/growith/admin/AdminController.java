package com.example.growith.admin;

import com.example.growith.member.MemberService;
import com.example.growith.supportservice.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin")
@RequiredArgsConstructor
@Controller
public class AdminController {
    private final NoticeService noticeService;

    @GetMapping("/login")
    public String login() {
        return "admin_login";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/faq")
    public String adminFaq() {
        return "admin_faq_manager";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/notice")
    public String adminNotice(Model model) {
        model.addAttribute("notices", noticeService.readList());
        return "admin_notice_manager";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/contactType")
    public String adminContactType(Model model) {
        model.addAttribute(noticeService.readList());
        return "admin_contact_manager";
    }

}
