package com.lsilvpin.tools.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lsilvpin.domain.interfaces.tools.IPathTool;
import com.lsilvpin.tools.implementation.PathTool;

public class PathToolTest {

    private IPathTool _pathTool;

    @BeforeEach
    public void setUp() {
        _pathTool = new PathTool();
    }

    @Test
    public void testGetRootPath() {
        // Arrange
        String expectedRootPath = "/workspaces/java-microservice/java-microservice";

        // Act
        String actualRootPath = _pathTool.getRootPath();

        // Assert
        assertEquals(expectedRootPath, actualRootPath);
    }
}