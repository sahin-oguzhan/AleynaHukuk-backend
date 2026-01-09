package com.aleynahukuk.backend.controller;

import com.aleynahukuk.backend.entity.Article;
import org.springframework.web.bind.annotation.*;
import com.aleynahukuk.backend.repository.ArticleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {


    private ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleRepository.findAllByOrderByIdAsc();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id){
        return articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Makale bulunamadı"));
    }

    @PostMapping
    public Article addArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id ,@RequestBody Article articleDetails) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Makale bulunamadı id: " + id));

        article.setTitle(articleDetails.getTitle());
        article.setContent(articleDetails.getContent());
        article.setImageUrl(articleDetails.getImageUrl());

        return articleRepository.save(article);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
    }

}
