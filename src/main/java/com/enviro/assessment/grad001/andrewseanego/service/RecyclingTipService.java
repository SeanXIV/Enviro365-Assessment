package com.enviro.assessment.grad001.andrewseanego.service;


import com.enviro.assessment.grad001.andrewseanego.model.RecyclingTip;
import com.enviro.assessment.grad001.andrewseanego.repository.RecyclingTipRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {

    private final RecyclingTipRepository repository;

    public RecyclingTipService(RecyclingTipRepository repository) {
        this.repository = repository;
    }

    // Create a new Recycling Tip
    public RecyclingTip createRecyclingTip(RecyclingTip recyclingTip){
        return repository.save(recyclingTip);
    }

    // Find all Recycling Tips
    public List<RecyclingTip> getAllRecyclingTips(){
        return repository.findAll();
    }

    // Find a Recycling Tip by Id
    public RecyclingTip getRecyclingTipById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Guideline not found with id: " + id));
    }

    // Update an existing Recycling Tip
    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip updatedRecyclingTip) {
        return repository.findById(id)
                .map(existingTip -> {
                    existingTip.setWasteType(updatedRecyclingTip.getWasteType());
                    existingTip.setTips(updatedRecyclingTip.getTips());
                    return repository.save(existingTip);
                })
                .orElseThrow(() -> new EntityNotFoundException("Recycling Tip not found with id: " + id));
    }

    // Delete an existing Recycling Tip
    public void deleteRecyclingTip(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Recycling Tip not found with id: " + id);
        }
    }
}
