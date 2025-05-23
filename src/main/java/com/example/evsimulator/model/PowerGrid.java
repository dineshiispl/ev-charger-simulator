package com.example.evsimulator.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
public class PowerGrid {

    @Id
    private String id;
    private double powerLimit;
    @OneToMany(mappedBy = "powerGrid", cascade = CascadeType.ALL)
    private List<Charger> chargers;
    public PowerGrid(String id, double powerLimit, List<Charger> chargers) {
        this.id = id;
        this.powerLimit = powerLimit;
        this.chargers = chargers;
    }

}