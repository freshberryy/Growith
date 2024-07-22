package com.example.growith.supportservice.faq;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FaqService {
    private final FaqRepository faqRepository;

    // db에 있는 board 전체 갖고 오기
    public List<Faq> readList() {
        return faqRepository.findAll();
    }
}
