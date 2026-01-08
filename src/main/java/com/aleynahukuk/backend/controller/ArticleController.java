package com.aleynahukuk.backend.controller;

import com.aleynahukuk.backend.entity.Article;
import org.springframework.web.bind.annotation.*;
import com.aleynahukuk.backend.repository.ArticleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "http://localhost:5173")
public class ArticleController {


    private ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @PostMapping
    public Article addArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }



}
