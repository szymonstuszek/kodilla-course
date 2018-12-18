package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        String firstLog = "First log test";

        //When
        Logger.getInstance().log(firstLog);
        String retrievedLog = Logger.getInstance().getLastLog();

        //Then
        Assert.assertEquals(firstLog, retrievedLog);
    }
}
