package com.aleynahukuk.backend.controller;

import com.aleynahukuk.backend.entity.PracticeArea;
import com.aleynahukuk.backend.repository.PracticeAreaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/practices")
public class PracticeAreaController {

    private PracticeAreaRepository practiceAreaRepository;

    public PracticeAreaController(PracticeAreaRepository practiceAreaRepository) {
        this.practiceAreaRepository = practiceAreaRepository;
    }

    @GetMapping
    public List<PracticeArea> findAll() {
        return practiceAreaRepository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public PracticeArea addPractice(@RequestBody PracticeArea practiceArea) {
        return practiceAreaRepository.save(practiceArea);
    }

    @DeleteMapping("/{id}")
    public void deletePractice(@PathVariable Long id) {
        practiceAreaRepository.deleteById(id);
    }
}
