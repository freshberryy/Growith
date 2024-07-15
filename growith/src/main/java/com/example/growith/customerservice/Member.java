package com.example.growith.customerservice;

import com.example.growith.customerservice.faq.Faq;
import com.example.growith.customerservice.notice.Notice;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

//관리자 entity
@Data
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private String email;
	
	private String role;

	@OneToMany(mappedBy = "author")
	private List<Notice> noticeList;

	@OneToMany(mappedBy = "author")
	private List<Faq> faqList;
}
