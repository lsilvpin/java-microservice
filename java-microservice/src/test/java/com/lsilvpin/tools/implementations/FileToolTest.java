package com.lsilvpin.tools.implementations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lsilvpin.domain.interfaces.tools.IFileTool;
import com.lsilvpin.tools.implementation.FileTool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class FileToolTest {

    private IFileTool fileTool;

    @BeforeEach
    public void setUp() {
        fileTool = new FileTool();
    }

    @Test
    public void testShouldReadValidJsonFileAsHashMapAndReturnObject() throws IOException {
        // Arrange
        String jsonContent = "{\"name\":\"John\",\"age\":\"30\"}";

        // Create a temporary file with valid JSON content
        Path tempFile = Files.createTempFile(null, ".json");
        Files.write(tempFile, jsonContent.getBytes());
        String filePath = tempFile.toString();
        HashMap<String, String> map = fileTool.readJsonAsMap(filePath);
    
        // Assert
        assertNotNull(map);
        assertEquals(map.get("name"), "John");
        assertEquals(map.get("age"), "30");
    }

    @Test
    public void testShouldReadValidJsonFileAndReturnObject() throws IOException {
        // Arrange
        String jsonContent = "{\"name\":\"John\",\"age\":30}";

        // Create a temporary file with valid JSON content
        Path tempFile = Files.createTempFile(null, ".json");
        Files.write(tempFile, jsonContent.getBytes());

        try {
            // Act
            String filePath = tempFile.toString();
            TestObject result = fileTool.readJson(filePath, TestObject.class);

            // Assert
            assertNotNull(result);
            assertEquals("John", result.getName());
            assertEquals(30, result.getAge());
        } finally {
            // Clean up
            Files.deleteIfExists(tempFile);
        }
    }

    @Test
    public void testShouldReadInvalidJsonFileAndThrowIllegalArgumentException() throws IOException {
        // Arrange
        String invalidJsonContent = "{\"name\":\"John\",\"age\":30,}";

        // Create a temporary file with invalid JSON content
        Path tempFile = Files.createTempFile(null, ".json");
        Files.write(tempFile, invalidJsonContent.getBytes());

        try {
            // Act and Assert
            assertThrows(IllegalArgumentException.class, () -> {
                fileTool.readJson(tempFile.toString(), TestObject.class);
            });
        } finally {
            // Clean up
            Files.deleteIfExists(tempFile);
        }
    }

    @Test
    public void testShouldReadNonJsonFileAndThrowIllegalArgumentException() throws IOException {
        // Arrange
        String nonJsonContent = "This is not a JSON file.";

        // Create a temporary file with non-JSON content
        Path tempFile = Files.createTempFile(null, ".json");
        Files.write(tempFile, nonJsonContent.getBytes());

        try {
            // Act and Assert
            assertThrows(IllegalArgumentException.class, () -> {
                fileTool.readJson(tempFile.toString(), TestObject.class);
            });
        } finally {
            // Clean up
            Files.deleteIfExists(tempFile);
        }
    }

    // Helper class for testing
    private static class TestObject {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
