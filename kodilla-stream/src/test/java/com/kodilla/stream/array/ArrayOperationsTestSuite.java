package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int[] numbers = {5,10,15,20};

        //When
        double average = ArrayOperations.getAverage(numbers);

        //Then
        Assert.assertEquals(12.5, average, 0.001);

    }
}
