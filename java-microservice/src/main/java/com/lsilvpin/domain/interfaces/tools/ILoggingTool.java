package com.lsilvpin.domain.interfaces.tools;

import com.lsilvpin.domain.interfaces.tools.common.IMyTool;

/**
 * This interface specifies how the logging tool of this application should be implemented.
 * The info method logs information, the warn method logs warnings, and the error method logs errors.
 * Each log entry is tagged with [INFO], [WARN], or [ERROR] respectively, along with the local date and time including the time zone.
 * The "LOG_LEVEL" environment variable is mandatory and must have values "info", "warn", or "error".
 * If the value is "info", the tool should log [INFO], [WARN], and [ERROR].
 * If the value is "warn", only [WARN] and [ERROR] should be logged.
 * If the value is "error", only [ERROR] should be logged.
 */
public interface ILoggingTool extends IMyTool {
    /**
     * Logs the given message as information.
     * The log entry is tagged with [INFO] and includes the local date and time with time zone.
     */
    public void info(String message);
    
    /**
     * Logs the given message as a warning.
     * The log entry is tagged with [WARN] and includes the local date and time with time zone.
     */
    public void warn(String message);
    
    /**
     * Logs the given message as an error.
     * The log entry is tagged with [ERROR] and includes the local date and time with time zone.
     */
    public void error(String message);
}
