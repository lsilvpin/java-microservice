package com.lsilvpin.javamicroservice.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class represents the Main Controller for the Java Microservice.
 * It contains the "Home" action which implements a GET endpoint "/Home"
 * that returns information about the microservice.
 */
@RestController
public class MainController {

    /**
     * This action handles the GET request to "/Home" endpoint.
     * It returns a JSON object with code 200 and information about the microservice.
     *
     * @return ResponseEntity with JSON object and code 200.
     */
    @GetMapping("/Home")
    public ResponseEntity<Object> Home() {
        // Create the JSON object with information about the microservice
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to the Java Microservice!");

        // Return the JSON object with code 200
        return ResponseEntity.ok(response);
    }
}
