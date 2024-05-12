package com.ahmet.androidlogger.logger.simple;

import com.ahmet.androidlogger.logger.LogFormatter;
import com.ahmet.androidlogger.logger.LogRecord;

import org.json.JSONObject;

import java.lang.reflect.Array;

/**
 * Author: Ahmet TOPAK
 * Since: 5/11/2024
 */
public class SimpleLogFormatter implements LogFormatter {


    @Override
    public String formatStringToLog(String message) {
        return null;
    }

    @Override
    public String formatJsonToLog(JSONObject jsonObject) {
        return null;
    }

    @Override
    public String formatArrayToLog(Array array) {
        return null;
    }
}
