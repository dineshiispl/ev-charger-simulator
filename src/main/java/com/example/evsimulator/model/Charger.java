package com.example.evsimulator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Charger {
    private final String id;
    private final double maxChargingSpeed;
    private Vehicle connectedVehicle;

    public Charger(String id, double maxChargingSpeed) {
        this.id = id;
        this.maxChargingSpeed = maxChargingSpeed;
    }

    public void connectVehicle(Vehicle vehicle) { this.connectedVehicle = vehicle; }
    public void disconnectVehicle() { this.connectedVehicle = null; }
    public boolean isOccupied() { return connectedVehicle != null; }
}