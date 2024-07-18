package com.example.growith.admin;

import com.example.growith.supportservice.notice.Notice;
import com.example.growith.supportservice.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/admin/notice")
@RequiredArgsConstructor
@Controller
public class AdminNoticeController {
    private final NoticeService noticeService;

    @GetMapping("/create")
    public String noticeCreate() {
        return "admin_notice_create";
    }

    @PostMapping("/create")
    public String noticeCreate(@ModelAttribute Notice notice) {
        noticeService.create(notice);
        return "redirect:/admin/notice";
    }

    @GetMapping("/delete/noticeID={id}")
    public String noticeDelete(@PathVariable("id") Integer id) {
        noticeService.delete(id);
        return "redirect:/admin/notice";
    }

    @GetMapping("/update/noticeID={id}")
    public String noticeUpdate(@PathVariable("id") Integer id, Model model) {
        Notice notice = noticeService.readdetail(id);
        model.addAttribute("notice", notice);
        return "admin/notice/update";
    }

    @PostMapping("/update/noticeID={id}")
    public String noticeUpdate(@ModelAttribute Notice notice, @PathVariable("id") Integer id) {
        noticeService.create(notice);
        return "redirect:/admin/notice/detail/noticeID=" + id;
    }
}
