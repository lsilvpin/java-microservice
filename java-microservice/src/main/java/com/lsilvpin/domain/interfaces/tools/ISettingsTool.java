package com.lsilvpin.domain.interfaces.tools;

import java.io.IOException;

import com.lsilvpin.domain.interfaces.tools.common.IMyTool;

/**
 * This interface represents a settings tool that provides methods to retrieve configuration settings.
 * The retrieval of settings should follow a specific process. The method should first search for settings in environment variables,
 * and if not found, it should search in a configuration file. The configuration file can be either application.dev.properties,
 * application.hml.properties, or application.prd.properties, depending on the value of the "environment" environment variable.
 * The "environment" variable is mandatory and its value should be either "dev", "hml", or "prd".
 */
public interface ISettingsTool extends IMyTool {
    /**
     * Retrieves the setting value for the given key.
     * The retrieval process follows a specific order:
     * 1. Search for the setting in environment variables.
     * 2. If not found, search for the setting in the configuration file.
     *    The configuration file is determined by the value of the "environment" environment variable.
     *    The file name should be one of the following: application.dev.properties, application.hml.properties, or application.prd.properties.
     * 
     * @param key the key of the setting to retrieve
     * @return the value of the setting, or null if the setting is not found
     * @throws IOException 
     */
    public String getSetting(String key) throws IOException; 
}
