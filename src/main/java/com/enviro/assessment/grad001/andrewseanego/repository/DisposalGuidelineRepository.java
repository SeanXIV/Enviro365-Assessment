package com.enviro.assessment.grad001.andrewseanego.repository;

import com.enviro.assessment.grad001.andrewseanego.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
    // No additional methods needed for basic CRUD operations
}
