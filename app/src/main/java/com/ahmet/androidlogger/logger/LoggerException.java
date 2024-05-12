package com.ahmet.androidlogger.logger;

/**
 * Author: Ahmet TOPAK
 * Since: 5/12/2024
 */
public class LoggerException extends Exception{
    public LoggerException(String message){
        super("Logger Exception: " + message);
    }
}
