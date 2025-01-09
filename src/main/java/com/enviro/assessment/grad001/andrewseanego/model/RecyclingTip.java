package com.enviro.assessment.grad001.andrewseanego.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Waste Type is required")
    @Size(max = 100, message = "Waste Type must not exceed 100 characters")
    private String wasteType;

    @Size(max = 255, message = "Tips must not exceed 255 characters")
    private String tips;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
