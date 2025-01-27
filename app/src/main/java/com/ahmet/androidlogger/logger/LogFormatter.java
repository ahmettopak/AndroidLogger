package com.ahmet.androidlogger.logger;

/**
 * Author: Ahmet TOPAK
 * Since: 1/27/2025
 */

// Interface for log formatting and timestamp generation
public interface LogFormatter {
    String format(String message, LogLevel level);
}
