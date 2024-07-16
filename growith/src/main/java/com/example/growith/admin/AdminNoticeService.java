package com.example.growith.admin;

import com.example.growith.supportservice.notice.Notice;
import com.example.growith.supportservice.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AdminNoticeService {
    private final NoticeService noticeService;

    public void create(Notice notice) {
        notice.setDate(LocalDateTime.now());
        noticeService.create(notice);
    }

    public void deleteNotice(Integer id) {
        noticeService.delete(id);
    }

    public void updateNotice(Notice notice) {
        notice.setDate(LocalDateTime.now());
        noticeService.create(notice);
    }
}
