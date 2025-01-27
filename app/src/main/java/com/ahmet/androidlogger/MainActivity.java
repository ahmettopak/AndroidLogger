package com.ahmet.androidlogger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ahmet.androidlogger.logger.DefaultLogFormatter;
import com.ahmet.androidlogger.logger.LogManager;
import com.ahmet.androidlogger.logger.LogSaver;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    LogGenerator logGenerator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // Initialize LogSaver with DefaultLogFormatter
            LogSaver logSaver = new LogSaver(this, new DefaultLogFormatter());
            LogManager logManager = new LogManager(logSaver);

            // Log various messages
//            logManager.logInfo("Application started successfully.");
//            logManager.logDebug("Debugging user flow.");
//            logManager.logWarning("Low memory warning.");
//            logManager.logError("Failed to load user profile.");


            logGenerator = new LogGenerator(logManager);
            logGenerator.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}