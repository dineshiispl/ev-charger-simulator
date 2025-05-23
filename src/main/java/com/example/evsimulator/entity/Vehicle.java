package com.example.evsimulator.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {
    @Id
    private String id;
    private double totalCapacity;
    private double currentCharge;
    private double maxChargingSpeed;

    public Vehicle() {
    }

    public Vehicle(String id, double totalCapacity, double currentCharge, double maxChargingSpeed) {
        this.id = id;
        this.totalCapacity = totalCapacity;
        this.currentCharge = currentCharge;
        this.maxChargingSpeed = maxChargingSpeed;
    }

    // Getters, Setters, charge() method
}