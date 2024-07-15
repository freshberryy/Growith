package com.example.growith.support;

import java.time.LocalDateTime;

import com.example.growith.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

//공지사항 entity
@Data
@Entity
public class Support {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	@Column(columnDefinition="TEXT")
	private String content;
	
	//파일 이름과 경로 저장
	private String fileName;
    private String filePath;
	
    @ManyToOne
	private Member author;
	
	private LocalDateTime date;
}
