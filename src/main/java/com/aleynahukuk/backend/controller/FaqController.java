package com.aleynahukuk.backend.controller;

import com.aleynahukuk.backend.entity.Faq;
import com.aleynahukuk.backend.repository.FaqRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faq")
public class FaqController {

    private FaqRepository faqRepository;

    public FaqController(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    @GetMapping
    public List<Faq> getAllFaqs() {
        return faqRepository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public Faq addFaq(@RequestBody Faq faq) {
        return faqRepository.save(faq);
    }

    @DeleteMapping("/{id}")
    public void deleteFaq(@PathVariable Long id) {
        faqRepository.deleteById(id);
    }
}
