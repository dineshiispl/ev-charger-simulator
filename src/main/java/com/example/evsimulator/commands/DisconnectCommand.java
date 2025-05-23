package com.example.evsimulator.commands;

import com.example.evsimulator.ports.Command;
import com.example.evsimulator.services.ChargingService;

public class DisconnectCommand implements Command {
    private final ChargingService service;
    private final String chargerId;

    public DisconnectCommand(ChargingService service, String chargerId) {
        this.service = service;
        this.chargerId = chargerId;
    }

    public void execute() {
        service.disconnect(chargerId);
    }
}
