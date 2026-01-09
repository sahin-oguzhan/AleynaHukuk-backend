package com.aleynahukuk.backend.repository;

import com.aleynahukuk.backend.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaqRepository extends JpaRepository<Faq, Long> {
    List<Faq> findAllByOrderByIdAsc();
}
