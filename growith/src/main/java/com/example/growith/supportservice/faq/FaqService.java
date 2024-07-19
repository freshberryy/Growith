package com.example.growith.supportservice.faq;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FaqService {
	
	@Autowired
    private final FaqRepository faqRepository;

    public void create(Faq faq) {
        faq.setDate(LocalDateTime.now());
        faqRepository.save(faq);
    }

    public void delete(Integer id) {
		faqRepository.deleteById(id);
	}
	
	// db에 있는 board 전체 갖고 오기
	public List<Faq> readList(){
		return faqRepository.findAll();
	}
	
	public Faq readdetail(Integer id) {
		Optional<Faq> o = faqRepository.findById(id);
		
		return o.get(); 
	}
}
