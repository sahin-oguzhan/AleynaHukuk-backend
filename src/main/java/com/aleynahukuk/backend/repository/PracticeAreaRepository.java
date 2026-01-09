package com.aleynahukuk.backend.repository;

import com.aleynahukuk.backend.entity.PracticeArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PracticeAreaRepository extends JpaRepository<PracticeArea,Long> {
    List<PracticeArea> findAllByOrderByIdAsc();
}
