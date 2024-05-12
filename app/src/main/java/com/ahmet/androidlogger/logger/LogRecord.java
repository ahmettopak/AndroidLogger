package com.ahmet.androidlogger.logger;

/**
 * Author: Ahmet TOPAK
 * Since: 5/11/2024
 */


import android.util.Log;

import java.util.Date;
import com.ahmet.androidlogger.logger.Logger.LogLevel;
public class LogRecord {
    private final Date timestamp;
    private final String message;
    private final LogLevel level;

    // Private kurucu method
    private LogRecord(Date timestamp, String message, LogLevel level) {
        this.timestamp = timestamp;
        this.message = message;
        this.level = level;
    }

    // Getter methodları
    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public LogLevel getLevel() {
        return level;
    }

    // Builder sınıfı
    public static class Builder {
        private Date timestamp = new Date();
        private String message = "Not set message";
        private LogLevel level = LogLevel.VERBOSE;

        public Builder timestamp(Date timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder level(LogLevel level) {
            this.level = level;
            return this;
        }

        public LogRecord build() {
            if (timestamp == null || message == null || level == null) {
                throw new IllegalStateException("Missing required fields");
            }
            return new LogRecord(timestamp, message, level);
        }
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + "[" + level + "] " + message;
    }
}
