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

                    boolean isMetricLog = random.nextBoolean(); // Grafik verisi mi, normal log mu

                    if (isMetricLog) {
                        String metricLog = generateMetricLog();
                        logManager.logInfo(metricLog); // Metric logları bilgi seviyesinde loglanıyor
                    } else {
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

    // Grafik verisi oluşturma metodu
    private String generateMetricLog() {
        int current = random.nextInt(100); // 0-99 arası değer
        int bus = random.nextInt(100);
        int volt = random.nextInt(100);
        int rpm = random.nextInt(5000); // 0-4999 arası değer
        int targetSpeed = random.nextInt(5000); // 0-4999 arası değer
        int metricNumber = random.nextInt(10); // 0-4999 arası değer

        return String.format("Motor %d - Current: %d, Bus: %d, Volt: %d, RPM: %d, TargetSpeed: %d", metricNumber , current, bus, volt, rpm , targetSpeed);
    }
}
