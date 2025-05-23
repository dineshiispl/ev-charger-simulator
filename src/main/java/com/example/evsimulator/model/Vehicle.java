package com.example.evsimulator.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vehicle {
    private final String id;
    private final double totalCapacity;
    private double currentCharge;
    private final double maxChargingSpeed;

    public Vehicle(String id, double totalCapacity, double currentCharge, double maxChargingSpeed) {
        this.id = id;
        this.totalCapacity = totalCapacity;
        this.currentCharge = currentCharge;
        this.maxChargingSpeed = maxChargingSpeed;
    }

    public void charge(double amount) {
        this.currentCharge = Math.min(totalCapacity, currentCharge + amount);
    }
}