package com.example.growith.supportservice.notice;

import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NoticeService {
	private final NoticeRepository noticeRepository;
	// db에 있는 board 전체 갖고 오기
	public List<Notice> readList(){
		return noticeRepository.findAll();
	}
}
