package com.example.growith.admin;

import com.example.growith.supportservice.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasAuthority('ROLE_ADMIN')") //함수 호출 전, 현재 유저가 권한을 갖고 있는지 검사
@RequestMapping("/admin")
@RequiredArgsConstructor
@Controller
public class AdminController {
    private final NoticeService noticeService;




    @GetMapping("/faq")
    public String adminfaq() {
        return "admin_faq_manager";
    }

    @GetMapping("/notice")
    public String adminnotice() {
        return "admin_notice_manager";
    }

}
