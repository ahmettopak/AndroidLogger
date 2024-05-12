package com.ahmet.androidlogger.logger.simple;

import com.ahmet.androidlogger.logger.LogRecord;
import com.ahmet.androidlogger.logger.LogRecorder;
import com.ahmet.androidlogger.logger.Logger;
import com.ahmet.androidlogger.logger.LoggerException;

/**
 * Author: Ahmet TOPAK
 * Since: 5/11/2024
 */
public class SimpleLogger extends Logger {


    @Override
    public void log(LogRecord logRecord) {

        try{
            recordLog(logRecord);

        }
        catch (LoggerException ignored){

        }
    }
}
