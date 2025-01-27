package com.ahmet.androidlogger.logger;

/**
 * Author: Ahmet TOPAK
 * Since: 1/27/2025
 */

// High-level manager for logging actions
public class LogManager {
    private final LogSaver logSaver;

    public LogManager(LogSaver logSaver) {
        this.logSaver = logSaver;
    }

    public void log(LogLevel level, String message) {
        logSaver.saveLog(message, level);
    }

    public void logInfo(String message) {
        log(LogLevel.INFO, message);
    }

    public void logDebug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void logWarning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void logError(String message) {
        log(LogLevel.ERROR, message);
    }
}