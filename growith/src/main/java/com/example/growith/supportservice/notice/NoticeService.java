package com.example.growith.supportservice.notice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	@Autowired
	private NoticeRepository noticeRepository;
	
	public void create(Notice notice) {
		notice.setDate(LocalDateTime.now());
		noticeRepository.save(notice);
	}

	public void delete(Integer id) {
		noticeRepository.deleteById(id);
	}
	
	// db에 있는 board 전체 갖고 오기
	public List<Notice> readList(){
		return noticeRepository.findAll();
	}
	
	public Notice readdetail(Integer id) {
		Notice notice = noticeRepository.findById(id).orElse(null);
		
		return notice;
	}
}
