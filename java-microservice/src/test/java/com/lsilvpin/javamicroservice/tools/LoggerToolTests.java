package com.lsilvpin.javamicroservice.tools;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerToolTests {
    @Rule
    public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

    @Test
    public void testShouldLogInfoMessage() {
        // Arrange
        LoggerTool logger = new LoggerTool();
        String message = "This is an info message";

        // Act
        logger.info(message);

        // Assert
        // Verify that the message is logged
        // You can use any assertion library to validate the output
    }

    @Test
    public void testShouldLogWarningMessage() {
        // Arrange
        LoggerTool logger = new LoggerTool();
        String message = "This is a warning message";

        // Act
        logger.warn(message);

        // Assert
        // Verify that the message is logged
        // You can use any assertion library to validate the output
    }

    @Test
    public void testShouldLogErrorMessage() {
        // Arrange
        LoggerTool logger = new LoggerTool();
        Exception exception = new Exception("This is an error message");

        // Act
        logger.error(exception);

        // Assert
        // Verify that the exception and its stack trace are logged
        // You can use any assertion library to validate the output
    }

    @Test
    public void testShouldReturnTrueWhenLogLevelEnabled() {
        // Arrange
        LoggerTool logger = new LoggerTool();
        String logLevel = "Info";
        environmentVariables.set("LOG_LEVEL", logLevel);

        // Act
        boolean isLogLevelEnabled = logger.isLogLevelEnabled(logLevel);

        // Assert
        Assertions.assertTrue(isLogLevelEnabled);
    }

    @Test
    public void testShouldReturnFalseWhenLogLevelDisabled() {
        // Arrange
        LoggerTool logger = new LoggerTool();
        String logLevel = "Info";
        environmentVariables.set("LOG_LEVEL", "Warn");

        // Act
        boolean isLogLevelEnabled = logger.isLogLevelEnabled(logLevel);

        // Assert
        Assertions.assertFalse(isLogLevelEnabled);
    }

    @Test
    public void testShouldFormatLogMessage() {
        // Arrange
        LoggerTool logger = new LoggerTool();
        String logLevel = "INFO";
        String message = "This is a log message";
        String expectedFormattedLog = "[" 
            + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) 
            + "] " + logLevel + " " + message;

        // Act
        String formattedLog = logger.getFormattedLog(logLevel, message);

        // Assert
        Assertions.assertEquals(expectedFormattedLog, formattedLog);
    }
}