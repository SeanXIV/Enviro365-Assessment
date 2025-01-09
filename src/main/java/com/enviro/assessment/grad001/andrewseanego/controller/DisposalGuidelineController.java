package com.enviro.assessment.grad001.andrewseanego.controller;

import com.enviro.assessment.grad001.andrewseanego.model.DisposalGuideline;
import com.enviro.assessment.grad001.andrewseanego.service.DisposalGuidelineService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService service;

    public DisposalGuidelineController(DisposalGuidelineService service) {
        this.service = service;
    }

    // Create a new guideline
    @PostMapping
    public DisposalGuideline addGuideline(@RequestBody DisposalGuideline guideline) {
        return service.addGuideline(guideline);
    }

    // Get all guidelines
    @GetMapping
    public List<DisposalGuideline> getAllGuidelines() {
        return service.getAllGuidelines();
    }

    // Get a guideline by ID
    @GetMapping("/{id}")
    public DisposalGuideline getGuidelineById(@PathVariable Long id) {
        return service.getGuidelineById(id);
    }

    // Update a guideline
    @PutMapping("/{id}")
    public DisposalGuideline updateGuideline(
            @PathVariable Long id,
            @RequestBody DisposalGuideline updatedGuideline) {
        return service.updateGuideline(id, updatedGuideline);
    }

    // Delete a guideline
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuideline(@PathVariable Long id) {
        service.deleteGuideline(id);
        return ResponseEntity.ok("Guideline deleted successfully!");
    }
}

