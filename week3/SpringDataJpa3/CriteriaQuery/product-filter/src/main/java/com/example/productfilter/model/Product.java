package com.example.productfilter.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double reviewRating;
    private int hardDiskSize;
    private int ramSize;
    private double cpuSpeed;
    private String os;
    private double weight;
    private String cpu;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getReviewRating() { return reviewRating; }
    public void setReviewRating(double reviewRating) { this.reviewRating = reviewRating; }

    public int getHardDiskSize() { return hardDiskSize; }
    public void setHardDiskSize(int hardDiskSize) { this.hardDiskSize = hardDiskSize; }

    public int getRamSize() { return ramSize; }
    public void setRamSize(int ramSize) { this.ramSize = ramSize; }

    public double getCpuSpeed() { return cpuSpeed; }
    public void setCpuSpeed(double cpuSpeed) { this.cpuSpeed = cpuSpeed; }

    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public String getCpu() { return cpu; }
    public void setCpu(String cpu) { this.cpu = cpu; }
}
