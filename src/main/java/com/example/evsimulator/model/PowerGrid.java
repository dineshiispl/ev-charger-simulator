package com.example.evsimulator.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PowerGrid {
    private final double powerLimit;
    private final List<Charger> chargers;

    public PowerGrid(double powerLimit, List<Charger> chargers) {
        this.powerLimit = powerLimit;
        this.chargers = chargers;
    }

}