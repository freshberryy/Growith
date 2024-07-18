package com.example.growith.admin;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.growith.supportservice.faq.Faq;
import com.example.growith.supportservice.faq.FaqService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminFaqService {
    private final FaqService faqService;

    public void create(Faq faq) {
        faq.setDate(LocalDateTime.now());
        faqService.create(faq);
    }

    public void deleteFaq(Integer id) {
        faqService.delete(id);
    }

    public void updateFaq(Faq faq) {
        faq.setDate(LocalDateTime.now());
        faqService.create(faq);
    }
}
