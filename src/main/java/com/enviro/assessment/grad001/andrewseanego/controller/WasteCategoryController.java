package com.enviro.assessment.grad001.andrewseanego.controller;

import com.enviro.assessment.grad001.andrewseanego.model.WasteCategory;
import com.enviro.assessment.grad001.andrewseanego.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService service;

    // Constructor injection
    public WasteCategoryController(WasteCategoryService service) {
        this.service = service;
    }

    // Create a new waste category
    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        WasteCategory createdCategory = service.createWasteCategory(wasteCategory);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    // Get all waste categories
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        List<WasteCategory> categories = service.getAllWasteCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // Get a specific waste category by ID
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        return service.getWasteCategoryById(id)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a waste category by ID
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(
            @PathVariable Long id,
            @Valid @RequestBody WasteCategory wasteCategory) {
        try {
            WasteCategory updatedCategory = service.updateWasteCategory(id, wasteCategory);
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a waste category by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        service.deleteWasteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
