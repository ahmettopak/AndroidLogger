package com.ahmet.androidlogger.logger;

/**
 * Author: Ahmet TOPAK
 * Since: 5/11/2024
 */
public interface LogListener {
     void onLogReceived(LogRecord logRecord);

     void onLogRecorded(LogRecord logRecord);
}
