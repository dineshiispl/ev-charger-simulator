package com.example.evsimulator.services;

import com.example.evsimulator.model.Charger;
import com.example.evsimulator.model.PowerGrid;
import com.example.evsimulator.model.Vehicle;
import com.example.evsimulator.ports.ChargingStrategy;
import com.example.evsimulator.repository.ChargerRepository;
import com.example.evsimulator.repository.VehicleRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class ChargingService {
    @Getter
    private final PowerGrid grid;
    private final VehicleRepository vehicleRepository;
    private final ChargerRepository chargerRepository;
    private final ChargingStrategy strategy;

    public ChargingService(PowerGrid grid, VehicleRepository vehicleRepository,
                           ChargerRepository chargerRepository, ChargingStrategy strategy) {
        this.grid = grid;
        this.vehicleRepository = vehicleRepository;
        this.chargerRepository = chargerRepository;
        this.strategy = strategy;
    }

    public void connect(String chargerId, String vehicleId) {
        Charger charger = chargerRepository.findById(chargerId).orElse(null);
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (charger != null && vehicle != null && !charger.isOccupied()) {
            charger.connectVehicle(vehicle);
            chargerRepository.save(charger);
        }
    }

    public void disconnect(String chargerId) {
        Charger charger = chargerRepository.findById(chargerId).orElse(null);
        if (charger != null && charger.isOccupied()) {
            charger.disconnectVehicle();
            chargerRepository.save(charger);
        }
    }

    public void advance(int minutes) {
        double available = grid.getPowerLimit();
        for (Charger c : chargerRepository.findAll()) {
            if (c.isOccupied()) {
                Vehicle v = c.getConnectedVehicle();
                double speed = strategy.calculateChargingSpeed(v, c, available);
                double energy = speed * minutes / 60.0;
                v.charge(energy);
                vehicleRepository.save(v);
                available -= speed;
            }
        }
    }

}