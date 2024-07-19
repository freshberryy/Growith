package com.example.growith.admin;

import com.example.growith.supportservice.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/admin")
@RequiredArgsConstructor
@Controller
public class AdminController {
    private final NoticeService noticeService;

    @GetMapping("/login")
    public String login() {
        return "admin_login";
    }

//    @GetMapping("/")
//    public String admin() {
//        return "admin";
//    }

//    @PostMapping("/admin")
//    public String adminPost() {
//        return "redirect:/";
//    }

//    @GetMapping("/login")
//    public String login() {
//        return "admin/login";
//    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        return "redirect:/admin/login";
    }
    
    @GetMapping("/faq")
    public String adminfaq() {
        return "admin_faq_manager";
    }

    @GetMapping("/notice")
    public String adminnotice() {
        return "admin_notice_manager";
    }


}
