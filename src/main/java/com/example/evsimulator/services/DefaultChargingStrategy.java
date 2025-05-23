package com.example.evsimulator.services;

import com.example.evsimulator.model.Charger;
import com.example.evsimulator.model.Vehicle;
import com.example.evsimulator.ports.ChargingStrategy;
import org.springframework.stereotype.Service;

@Service
public class DefaultChargingStrategy implements ChargingStrategy {
        public double calculateChargingSpeed(Vehicle v, Charger c, double available) {
            return Math.min(Math.min(v.getMaxChargingSpeed(), c.getMaxChargingSpeed()), available);
        }
    }
