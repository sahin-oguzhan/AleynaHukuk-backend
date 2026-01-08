package com.aleynahukuk.backend.controller;

import com.aleynahukuk.backend.entity.About;
import com.aleynahukuk.backend.repository.AboutRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/about")
@CrossOrigin(origins = "http://localhost:5173")
public class AboutController {

    private AboutRepository aboutRepository;

    public AboutController(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    @GetMapping
    public About getAbout() {
        return aboutRepository.findAll().stream().findFirst().orElse(new About());
    }

    @PostMapping
    public About updateAbout(@RequestBody About about){
        About existing = getAbout();

        existing.setDescription(about.getDescription());
        existing.setImageUrl(about.getImageUrl());

        return aboutRepository.save(existing);

    }
}
