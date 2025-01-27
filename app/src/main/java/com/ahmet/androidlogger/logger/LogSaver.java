package com.ahmet.androidlogger.logger;

import android.content.Context;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Ahmet TOPAK
 * Since: 1/27/2025
 */

// Class responsible for saving logs to a file
public class LogSaver {
    private final File logFile;
    private final LogFormatter logFormatter;

    public LogSaver(Context context, String fileName, LogFormatter logFormatter) throws IOException {
        this.logFormatter = logFormatter;

        // Create the log directory if it doesn't exist
        File logDir = new File(context.getFilesDir(), "logs");
        if (!logDir.exists() && !logDir.mkdirs()) {
            throw new IOException("Failed to create log directory.");
        }

        // Create the log file if it doesn't exist
        logFile = new File(logDir, fileName);
        if (!logFile.exists() && !logFile.createNewFile()) {
            throw new IOException("Failed to create log file.");
        }
    }
    public LogSaver (Context context, LogFormatter logFormatter) throws IOException {
        this.logFormatter = logFormatter;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String timestamp = dateFormat.format(new Date());

        String logFileName = "ahmet_" + timestamp + ".log";

        // Create the log directory if it doesn't exist
        File logDir = new File(context.getFilesDir(), "logs");
        if (!logDir.exists() && !logDir.mkdirs()) {
            throw new IOException("Failed to create log directory.");
        }

        // Create the log file if it doesn't exist
        logFile = new File(logDir, logFileName);
        if (!logFile.exists() && !logFile.createNewFile()) {
            throw new IOException("Failed to create log file.");
        }
    }

    public void saveLog(String message, LogLevel level) {
        String formattedMessage = logFormatter.format(message, level);
        writeToFile(formattedMessage);
    }

    private void writeToFile(String logMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write(logMessage);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getLogFile() {
        return logFile;
    }
}