package com.enviro.assessment.grad001.andrewseanego.controller;

import com.enviro.assessment.grad001.andrewseanego.model.RecyclingTip;
import com.enviro.assessment.grad001.andrewseanego.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipService recyclingTipService;

    @Autowired
    public RecyclingTipController(RecyclingTipService recyclingTipService) {
        this.recyclingTipService = recyclingTipService;
    }

    // Create a new Recycling Tip
    @PostMapping
    public ResponseEntity<RecyclingTip> createRecyclingTip(@RequestBody RecyclingTip recyclingTip) {
        RecyclingTip createdRecyclingTip = recyclingTipService.createRecyclingTip(recyclingTip);
        return ResponseEntity.ok(createdRecyclingTip);
    }

    // Get all Recycling Tips
    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips() {
        List<RecyclingTip> recyclingTips = recyclingTipService.getAllRecyclingTips();
        return ResponseEntity.ok(recyclingTips);
    }

    // Get a single Recycling Tip by ID
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id) {
        RecyclingTip recyclingTip = recyclingTipService.getRecyclingTipById(id);
        return ResponseEntity.ok(recyclingTip);
    }

    // Update a Recycling Tip
    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id, @RequestBody RecyclingTip recyclingTip) {
        RecyclingTip updatedRecyclingTip = recyclingTipService.updateRecyclingTip(id, recyclingTip);
        return ResponseEntity.ok(updatedRecyclingTip);
    }

    // Delete a Recycling Tip
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecyclingTip(@PathVariable Long id) {
        recyclingTipService.deleteRecyclingTip(id);
        return ResponseEntity.ok("Recycling Tip deleted successfully!");
    }
}

