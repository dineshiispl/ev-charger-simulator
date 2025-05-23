package com.example.evsimulator.shell;

import com.example.evsimulator.ports.Command;

public class CommandExecutor {

    private final CommandFactory factory;

    public CommandExecutor(CommandFactory factory) {
        this.factory = factory;
    }

    public void executeCommand(String input) {
        Command command = factory.create(input);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Invalid command: " + input);
        }
    }
}
