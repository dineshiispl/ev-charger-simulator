package com.example.evsimulator.commands;

import com.example.evsimulator.ports.Command;
import com.example.evsimulator.services.ChargingService;

public class AdvanceCommand implements Command {
    private final ChargingService service;
    private final int minutes;

    public AdvanceCommand(ChargingService service, int minutes) {
        this.service = service;
        this.minutes = minutes;
    }

    public void execute() {
        service.advance(minutes);
    }
}
