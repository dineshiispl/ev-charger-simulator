package com.example.evsimulator.commands;

import com.example.evsimulator.model.PowerGrid;
import com.example.evsimulator.ports.Command;
import com.example.evsimulator.ports.StatePrinter;

public class StateCommand implements Command {
    private final PowerGrid grid;
    private final StatePrinter printer;

    public StateCommand(PowerGrid grid, StatePrinter printer) {
        this.grid = grid;
        this.printer = printer;
    }

    public void execute() {
        printer.print(grid);
    }
}