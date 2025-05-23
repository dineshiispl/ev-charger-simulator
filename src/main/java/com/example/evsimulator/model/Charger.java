package com.example.evsimulator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Charger {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "power_grid_id")
    private PowerGrid powerGrid;
    private double maxChargingSpeed;
    @ManyToOne
    @JoinColumn(name = "connected_vehicle_id")
    private Vehicle connectedVehicle;

    public Charger(String id, double maxChargingSpeed) {
        this.id = id;
        this.maxChargingSpeed = maxChargingSpeed;
    }

    public void connectVehicle(Vehicle vehicle) { this.connectedVehicle = vehicle; }
    public void disconnectVehicle() { this.connectedVehicle = null; }
    public boolean isOccupied() { return connectedVehicle != null; }
}