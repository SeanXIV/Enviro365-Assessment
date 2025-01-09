package com.enviro.assessment.grad001.andrewseanego.service;

import com.enviro.assessment.grad001.andrewseanego.model.WasteCategory;
import java.util.List;
import java.util.Optional;

public interface WasteCategoryService {
    WasteCategory createWasteCategory(WasteCategory wasteCategory); // Create

    List<WasteCategory> getAllWasteCategories(); // Read all

    Optional<WasteCategory> getWasteCategoryById(Long id); // Read by ID

    WasteCategory updateWasteCategory(Long id, WasteCategory wasteCategory); // Update

    void deleteWasteCategory(Long id); // Delete
}
