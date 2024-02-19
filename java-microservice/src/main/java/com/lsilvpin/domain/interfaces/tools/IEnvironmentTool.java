package com.lsilvpin.domain.interfaces.tools;

import com.lsilvpin.domain.interfaces.tools.common.IMyTool;

/**
 * This interface represents a tool for accessing environment variables.
 */
public interface IEnvironmentTool extends IMyTool {
    /**
     * Retrieves the value of the environment variable with the specified key.
     *
     * @param key the key of the environment variable
     * @return the value of the environment variable, or null if the variable is not found
     */
    public String get(String key);
}
