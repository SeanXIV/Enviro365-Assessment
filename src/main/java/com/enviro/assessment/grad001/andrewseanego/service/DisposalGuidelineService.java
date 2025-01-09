package com.enviro.assessment.grad001.andrewseanego.service;

import com.enviro.assessment.grad001.andrewseanego.model.DisposalGuideline;
import com.enviro.assessment.grad001.andrewseanego.repository.DisposalGuidelineRepository;
import org.springframework.stereotype.*;
import java.util.List;

@Service
public class DisposalGuidelineService {

    private final DisposalGuidelineRepository repository;

    public DisposalGuidelineService(DisposalGuidelineRepository repository) {
        this.repository = repository;
    }

    // Add a new guideline
    public DisposalGuideline addGuideline(DisposalGuideline guideline) {
        return repository.save(guideline);
    }

    // Get all guidelines
    public List<DisposalGuideline> getAllGuidelines() {
        return repository.findAll();
    }

    // Get a guideline by ID
    public DisposalGuideline getGuidelineById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Guideline not found with id: " + id));
    }

    // Update a guideline
    public DisposalGuideline updateGuideline(Long id, DisposalGuideline updatedGuideline) {
        DisposalGuideline existingGuideline = getGuidelineById(id);
        existingGuideline.setWasteType(updatedGuideline.getWasteType());
        existingGuideline.setGuidelines(updatedGuideline.getGuidelines());
        return repository.save(existingGuideline);
    }

    // Delete a guideline
    public void deleteGuideline(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Guideline not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

