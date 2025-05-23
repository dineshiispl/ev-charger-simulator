package com.example.evsimulator.commands;

import com.example.evsimulator.ports.Command;
import com.example.evsimulator.services.ChargingService;

public class ConnectCommand implements Command {
        private final ChargingService service;
        private final String chargerId;
        private final String vehicleId;

        public ConnectCommand(ChargingService service, String chargerId, String vehicleId) {
            this.service = service;
            this.chargerId = chargerId;
            this.vehicleId = vehicleId;
        }

        public void execute() {
            service.connect(chargerId, vehicleId);
        }
    }
