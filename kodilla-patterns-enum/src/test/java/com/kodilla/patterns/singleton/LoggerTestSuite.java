package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        // Given
        String logMessage = "Test log message";

        // When
        Logger.INSTANCE.log(logMessage);
        String lastLog = Logger.INSTANCE.getLastLog();

        // Then
        Assertions.assertEquals(logMessage, lastLog);
    }

    @Test
    public void testSingletonInstance() {
        // Given
        Logger logger1 = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;

        // When & Then
        Assertions.assertSame(logger1, logger2);
    }
}

