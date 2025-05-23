package com.example.evsimulator.services;

import com.example.evsimulator.model.Charger;
import com.example.evsimulator.model.PowerGrid;
import com.example.evsimulator.ports.StatePrinter;

public class ConsoleStatePrinter implements StatePrinter {
        public void print(PowerGrid grid) {
            System.out.println("--- Grid State ---");
            for (Charger charger : grid.getChargers()) {
                String vehicleId = charger.isOccupied() ? charger.getConnectedVehicle().getId() : "None";
                double charge = charger.isOccupied() ? charger.getConnectedVehicle().getCurrentCharge() : 0;
                System.out.printf("Charger %s: Vehicle=%s, SoC=%.2f kWh%n", charger.getId(), vehicleId, charge);
            }
        }
    }