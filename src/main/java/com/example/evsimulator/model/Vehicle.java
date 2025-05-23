package com.example.evsimulator.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
public class Vehicle {
    @Id
    private String id;
    private double totalCapacity;
    private double currentCharge;
    private double maxChargingSpeed;

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