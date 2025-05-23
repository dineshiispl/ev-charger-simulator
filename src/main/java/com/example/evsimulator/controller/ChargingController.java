package com.example.evsimulator.controller;

import com.example.evsimulator.ports.StatePrinter;
import com.example.evsimulator.services.ChargingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RestController
@RequestMapping("/api")
public class ChargingController {

    private final ChargingService service;
    private final StatePrinter printer;

    public ChargingController(ChargingService service, StatePrinter printer) {
        this.service = service;
        this.printer = printer;
    }

    @PostMapping("/chargers/{chargerId}/connect/{vehicleId}")
    public ResponseEntity<String> connect(@PathVariable String chargerId, @PathVariable String vehicleId) {
        service.connect(chargerId, vehicleId);
        return ResponseEntity.ok("Vehicle connected");
    }

    @PostMapping("/chargers/{chargerId}/disconnect")
    public ResponseEntity<String> disconnect(@PathVariable String chargerId) {
        service.disconnect(chargerId);
        return ResponseEntity.ok("Vehicle disconnected");
    }

    @PostMapping("/advance/{minutes}")
    public ResponseEntity<String> advance(@PathVariable int minutes) {
        service.advance(minutes);
        return ResponseEntity.ok("Simulation advanced by " + minutes + " minute(s)");
    }

    @GetMapping("/state")
    public ResponseEntity<String> getState() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);
        PrintStream old = System.out;
        System.setOut(ps);
        printer.print(service.getGrid());
        System.out.flush();
        System.setOut(old);
        return ResponseEntity.ok(out.toString());
    }
}