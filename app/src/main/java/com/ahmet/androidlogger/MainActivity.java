package com.ahmet.androidlogger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ahmet.androidlogger.logger.LogRecord;
import com.ahmet.androidlogger.logger.Logger;
import com.ahmet.androidlogger.logger.simple.SimpleLogFormatter;
import com.ahmet.androidlogger.logger.simple.SimpleLogger;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleLogger logger = new SimpleLogger();


        logger.log(new LogRecord.Builder()
                .level(Logger.LogLevel.ERROR)
                .message("asas")
                .timestamp(new Date()).build());


    }
}