package ru.arsentiev.restserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
public class ServerController {

    @GetMapping
    public ResponseEntity<String> getData() {
        try {
            Thread.sleep(2000); // 2 секунды задержки
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return ResponseEntity.ok("Data from Server");
    }
}
