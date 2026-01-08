package com.aleynahukuk.backend.repository;

import com.aleynahukuk.backend.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
