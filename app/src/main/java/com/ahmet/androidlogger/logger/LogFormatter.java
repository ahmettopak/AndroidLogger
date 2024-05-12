package com.ahmet.androidlogger.logger;

import org.json.JSONObject;

import java.lang.reflect.Array;

/**
 * Author: Ahmet TOPAK
 * Since: 5/11/2024
 */
public interface LogFormatter {

    String formatStringToLog(String message);
    String formatJsonToLog(JSONObject jsonObject);
    String formatArrayToLog(Array array);

}
