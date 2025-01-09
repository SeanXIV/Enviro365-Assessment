package com.enviro.assessment.grad001.andrewseanego.repository;

import com.enviro.assessment.grad001.andrewseanego.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
    // No need to do CRUD
}
