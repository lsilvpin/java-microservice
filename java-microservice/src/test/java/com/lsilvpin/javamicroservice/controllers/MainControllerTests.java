package com.lsilvpin.javamicroservice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainControllerTests {

    @Test
    public void testShouldReturnJsonObjectWithCode200() {
        // Arrange
        MainController mainController = new MainController();

        // Act
        ResponseEntity<Object> responseEntity = mainController.Home();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(HashMap.class, responseEntity.getBody().getClass());

        @SuppressWarnings("unchecked")
        Map<String, String> response = (Map<String, String>) responseEntity.getBody();
        assertEquals("Welcome to the Java Microservice!", response.get("message"));
    }
}
