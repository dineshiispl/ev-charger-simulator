package com.example.evsimulator.config;

import com.example.evsimulator.model.PowerGrid;
import com.example.evsimulator.model.Vehicle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class SimulationRunner {

    private final PowerGrid grid;
    private final Map<String, Vehicle> vehicles;

    public SimulationRunner(PowerGrid grid, Map<String, Vehicle> vehicles) {
        this.grid = grid;
        this.vehicles = vehicles;
    }

    @PostConstruct
    public void runSimulation() {
        System.out.println("🚀 Starting EV Simulation...");

        System.out.println("⚡ PowerGrid: " + grid.getId() + ", Capacity: " + grid.getPowerLimit());
        System.out.println("🔌 Chargers:");
        grid.getChargers().forEach(c -> System.out.println(" - " + c.getId() + " [" + c.getMaxChargingSpeed() + "]"));

        System.out.println("🚗 Vehicles:");
        vehicles.forEach((id, vehicle) -> {
            System.out.println(" - " + id + ": chargingSpeed=" + vehicle.getMaxChargingSpeed()
                    + ", capacity=" + vehicle.getTotalCapacity());
        });
    }
}
