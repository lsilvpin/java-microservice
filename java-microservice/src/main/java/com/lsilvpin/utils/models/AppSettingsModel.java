package com.lsilvpin.utils.models;

/**
 * This class represents the application settings model.
 */
public class AppSettingsModel {
    private String environment;
    private String log_level;

    /**
     * Gets the environment.
     * @return The environment.
     */
    public String getEnvironment() {
        return environment;
    }

    /**
     * Sets the environment.
     * @param environment The environment to set.
     */
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     * Gets the log level.
     * @return The log level.
     */
    public String getLog_level() {
        return log_level;
    }

    /**
     * Sets the log level.
     * @param log_level The log level to set.
     */
    public void setLog_level(String log_level) {
        this.log_level = log_level;
    }
}