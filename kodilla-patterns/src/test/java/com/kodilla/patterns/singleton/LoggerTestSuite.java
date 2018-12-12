package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        Logger logger = new Logger();
        String firstLog = "First log test";

        //When
        logger.log(firstLog);
        String retrievedLog = logger.getLastLog();

        //Then
        Assert.assertEquals(firstLog, retrievedLog);
    }
}
