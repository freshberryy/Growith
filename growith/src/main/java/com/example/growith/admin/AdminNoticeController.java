package com.example.growith.admin;

import com.example.growith.HtmlSanitizerService;
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
    private final HtmlSanitizerService htmlSanitizerService;

    @GetMapping("/create")
    public String noticeCreate(Model model) {
        model.addAttribute("notice", new Notice());
        return "admin_notice_create";
    }

    @PostMapping("/create")
    public String noticeCreate(@ModelAttribute Notice notice) {
        adminNoticeService.createNotice(notice);
        return "redirect:/admin/notice";
    }

    @GetMapping("/delete/noticeID={id}")
    public String noticeDelete(@PathVariable("id") Integer id) {
        adminNoticeService.deleteNotice(id);
        return "redirect:/admin/notice";
    }

    @GetMapping("/update/noticeID={id}")
    public String noticeUpdate(@PathVariable("id") Integer id, Model model) {
        Notice notice = adminNoticeService.getNotice(id);
        model.addAttribute("notice", notice);
        return "admin_notice_create";
    }

    @PostMapping("/update")
    public String noticeUpdate(@ModelAttribute Notice notice) {
        String sanitizedContent = htmlSanitizerService.sanitizeHtml(notice.getContent());
        notice.setContent(sanitizedContent);
        adminNoticeService.updateNotice(notice);
        return "redirect:/admin/notice";
    }
}
