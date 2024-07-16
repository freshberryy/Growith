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
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return "admin/login";
    }
}
