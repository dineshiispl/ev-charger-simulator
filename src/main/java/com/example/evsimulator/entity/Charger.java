package com.example.evsimulator.entity;

import com.example.evsimulator.model.Vehicle;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Charger {
    @Id
    private String id;
    private double maxChargingSpeed;

    @OneToOne(fetch = FetchType.LAZY)
    private Vehicle connectedVehicle;

    public Charger() {
    }

    public Charger(String id, double maxChargingSpeed) {
        this.id = id;
        this.maxChargingSpeed = maxChargingSpeed;
    }
}