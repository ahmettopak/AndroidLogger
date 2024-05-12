package com.ahmet.androidlogger.logger;

/**
 * Author: Ahmet TOPAK
 * Since: 5/11/2024
 */
public abstract class Logger {
    public enum LogLevel {
        VERBOSE,
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }
    private LogRecorder logRecorder;

    public void log(LogRecord logRecord){}

    public void recordLog(LogRecord logRecord) throws LoggerException {

        if(logRecorder == null){

            throw new LoggerException("Log recorder is null!");
        }
        else{
            logRecorder.recordLog(logRecord);
        }
    }

    public void setLogRecorder(LogRecorder logRecorder){
        this.logRecorder = logRecorder;
    }
    public LogRecorder getLogRecorder(){
        return logRecorder;
    }
}
