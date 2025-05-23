package com.example.evsimulator.ports;

import com.example.evsimulator.model.Charger;
import com.example.evsimulator.model.Vehicle;

public interface ChargingStrategy {
        double calculateChargingSpeed(Vehicle vehicle, Charger charger, double availableGridPower);
    }
