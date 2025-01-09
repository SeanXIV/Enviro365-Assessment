package com.enviro.assessment.grad001.andrewseanego.service;

import com.enviro.assessment.grad001.andrewseanego.model.WasteCategory;
import com.enviro.assessment.grad001.andrewseanego.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryServiceImpl implements WasteCategoryService {

    private final WasteCategoryRepository repository;

    // Constructor injection (best practice for Spring components)
    public WasteCategoryServiceImpl(WasteCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public WasteCategory createWasteCategory(WasteCategory wasteCategory) {
        return repository.save(wasteCategory); // Save to database
    }

    @Override
    public List<WasteCategory> getAllWasteCategories() {
        return repository.findAll(); // Retrieve all records
    }

    @Override
    public Optional<WasteCategory> getWasteCategoryById(Long id) {
        return repository.findById(id); // Find by ID
    }

    @Override
    public WasteCategory updateWasteCategory(Long id, WasteCategory updatedWasteCategory) {
        // Check if the WasteCategory exists
        WasteCategory existingWasteCategory = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("WasteCategory not found"));

        // Update fields
        existingWasteCategory.setName(updatedWasteCategory.getName());
        existingWasteCategory.setDescription(updatedWasteCategory.getDescription());

        return repository.save(existingWasteCategory); // Save updated entity
    }

    @Override
    public void deleteWasteCategory(Long id) {
        repository.deleteById(id); // Delete by ID
    }
}
