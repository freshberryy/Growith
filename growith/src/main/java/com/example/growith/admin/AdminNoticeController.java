package com.example.growith.admin;

import com.example.growith.supportservice.notice.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin/notice")
@RequiredArgsConstructor
@Controller
public class AdminNoticeController {
    private final AdminNoticeService adminNoticeService;

//    @GetMapping("/manage")
//    public String readList(Model model) {
//        model.addAttribute("notices", adminNoticeService.getAllNotices());
//        return "admin_notice_manager";
//    }

    @GetMapping("/create")
    public String noticeCreate() {
        return "admin_notice_create";
    }

    @PostMapping("/create")
    public String noticeCreate(@ModelAttribute Notice notice) {
        adminNoticeService.createNotice(notice);
        return "redirect:/admin/notice/manage";
    }

    @GetMapping("/delete/noticeID={id}")
    public String noticeDelete(@PathVariable("id") Integer id) {
        adminNoticeService.deleteNotice(id);
        return "redirect:/admin/notice/manage";
    }

    @GetMapping("/update/noticeID={id}")
    public String noticeUpdate(@PathVariable("id") Integer id, Model model) {
        Notice notice = adminNoticeService.getNotice(id);
        model.addAttribute("notice", notice);
        return "admin_notice_create";
    }

    @PostMapping("/update/noticeID={id}")
    public String noticeUpdate(@ModelAttribute Notice notice, @PathVariable("id") Integer id) {
        adminNoticeService.updateNotice(notice);
        return "redirect:/admin/notice/manage";
    }
}
