package com.ahmet.androidlogger.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Author: Ahmet TOPAK
 * Since: 1/27/2025
 */
// Default implementation of LogFormatter
public class DefaultLogFormatter implements LogFormatter {
    private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    @Override
    public String format(String message, LogLevel level) {

        return String.format("%s [%s]: %s",new SimpleDateFormat(TIMESTAMP_FORMAT, Locale.getDefault()).format(new Date()), level.name(), message);
    }
}