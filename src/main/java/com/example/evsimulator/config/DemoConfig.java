package com.example.evsimulator.config;

import com.example.evsimulator.model.Charger;
import com.example.evsimulator.model.PowerGrid;
import com.example.evsimulator.model.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DemoConfig {
    @Bean
    public PowerGrid grid() {
        List<Charger> chargers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            chargers.add(new Charger("C" + i, 100));
        }
        return new PowerGrid(500, chargers);
    }

    @Bean
    public Map<String, Vehicle> vehicles() {
        Map<String, Vehicle> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put("V" + i, new Vehicle("V" + i, 50, 0, 50));
            map.put("V" + (i + 5), new Vehicle("V" + (i + 5), 50, 0, 200));
        }
        return map;
    }
}