package com.lsilvpin.javamicroservice.tools;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The LoggerTool class provides logging functionality based on the log level.
 * The log level is determined by the environment variable "LOG_LEVEL".
 * If the log level is "Info", all methods can log.
 * If the log level is "Warn", only the warn and error methods can log.
 * If the log level is "Error", only the error method can log.
 */
public class LoggerTool {
    /**
     * Logs an informational message with the current date and time.
     *
     * @param msg The message to be logged.
     */
    public void info(String msg) {
        if (isLogLevelEnabled("Info")) {
            // Log the message with the current date and time
            System.out.println(getFormattedLog("[INFO]", msg));
        }
    }

    /**
     * Logs a warning message with the current date and time.
     *
     * @param msg The message to be logged.
     */
    public void warn(String msg) {
        if (isLogLevelEnabled("Warn")) {
            // Log the message with the current date and time
            System.out.println(getFormattedLog("[WARN]", msg));
        }
    }

    /**
     * Logs an error message with the exception stack trace and the current date and time.
     *
     * @param ex The exception to be logged.
     */
    public void error(Exception ex) {
        if (isLogLevelEnabled("Error")) {
            // Log the exception with the current date and time
            System.err.println(getFormattedLog("[ERROR]", ex.getMessage()));
            ex.printStackTrace();
        }
    }

    /**
     * Checks if the given log level is enabled based on the environment variable "LOG_LEVEL".
     *
     * @param logLevel The log level to check.
     * @return True if the log level is enabled, false otherwise.
     */
    public boolean isLogLevelEnabled(String logLevel) {
        String envLogLevel = System.getenv("LOG_LEVEL");
        return envLogLevel != null && envLogLevel.equalsIgnoreCase(logLevel);
    }

    /**
     * Formats the log message with the current date and time.
     *
     * @param logLevel The log level.
     * @param msg The message to be logged.
     * @return The formatted log message.
     */
    public String getFormattedLog(String logLevel, String msg) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        return "[" + formattedDateTime + "] " + logLevel + " " + msg;
    }
}
