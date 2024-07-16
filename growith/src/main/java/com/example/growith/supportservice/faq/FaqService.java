package com.example.growith.supportservice.faq;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FaqService {
    private final FaqRepository faqRepository;

    public void create(Faq faq) {
        faq.setDate(LocalDateTime.now());
        faqRepository.save(faq);
    }

    public void delete(Integer id) {
        faqRepository.deleteById(id);
    }

    public List<Faq> getAllFaq() {
        return faqRepository.findAll();
    }
}
