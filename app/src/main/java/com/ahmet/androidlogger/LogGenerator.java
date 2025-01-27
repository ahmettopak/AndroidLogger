package com.ahmet.androidlogger;

import com.ahmet.androidlogger.logger.LogManager;

import java.util.Random;

/**
 * Author: Ahmet TOPAK
 * Since: 1/27/2025
 */
public class LogGenerator {
    private static final String[] LOG_MESSAGES = {
            "User logged in.",
            "Button clicked.",
            "Data sync started.",
            "Network request failed.",
            "Memory usage increased.",
            "Database updated successfully.",
            "Cache cleared.",
            "File upload completed.",
            "Invalid user input.",
            "Permission granted."
    };

    private final LogManager logManager;
    private final Random random;
    private boolean isLoggingActive;

    public LogGenerator(LogManager logManager) {
        this.logManager = logManager;
        this.random = new Random();
        this.isLoggingActive = true;
    }

    // Başlatma işlemi
    public void start() {
        new Thread(() -> {
            while (isLoggingActive) {
                try {
                    // Rastgele bir log seviyesi ve mesaj oluştur
                    int logLevel = random.nextInt(4);
                    String message = LOG_MESSAGES[random.nextInt(LOG_MESSAGES.length)];

                    // Seviyeye göre loglama yap
                    switch (logLevel) {
                        case 0:
                            logManager.logInfo(message);
                            break;
                        case 1:
                            logManager.logDebug(message);
                            break;
                        case 2:
                            logManager.logWarning(message);
                            break;
                        case 3:
                            logManager.logError(message);
                            break;
                    }

                    // Bir saniye bekle
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    stop();
                }
            }
        }).start();
    }

    // Durdurma işlemi
    public void stop() {
        isLoggingActive = false;
    }
}