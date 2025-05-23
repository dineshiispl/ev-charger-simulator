package com.example.evsimulator.shell;

import com.example.evsimulator.ports.Command;
import com.example.evsimulator.commands.*;
import com.example.evsimulator.ports.StatePrinter;
import com.example.evsimulator.services.ChargingService;

public class CommandFactory {
    private final ChargingService service;
    private final StatePrinter printer;

    public CommandFactory(ChargingService service, StatePrinter printer) {
        this.service = service;
        this.printer = printer;
    }

    public Command create(String input) {
        String[] parts = input.trim().split("\\s+");

        switch (parts[0]) {
            case "connect":
                return new ConnectCommand(service, parts[1], parts[2]);
            case "disconnect":
                return new DisconnectCommand(service, parts[1]);
            case "advance":
                return new AdvanceCommand(service, Integer.parseInt(parts[1]));
            case "state":
                return new StateCommand(service.getGrid(), printer);
            default:
                return () -> System.out.println("Invalid command: " + input);
        }
    }
}
