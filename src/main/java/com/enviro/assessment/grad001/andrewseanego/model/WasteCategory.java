package com.enviro.assessment.grad001.andrewseanego.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name; // Waste category name

    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description; // Description of the waste category

    // Default constructor (required by JPA)
    public WasteCategory() {}

    // Constructor with fields
    public WasteCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
