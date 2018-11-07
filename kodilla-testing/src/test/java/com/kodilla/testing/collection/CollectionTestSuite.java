package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CollectionTestSuite {

    @Before
    public void before() {
        System.out.println("Starting test case");
    }

    @After
    public void after() {
        System.out.println("Test case finished");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        System.out.println("Empty list");

        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> emptyList = new ArrayList<>();
        ArrayList<Integer> processedList = exterminator.exterminate(emptyList);

        Assert.assertEquals(emptyList, processedList);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        System.out.println("Normal list");

        OddNumbersExterminator exterminator = new OddNumbersExterminator();

        ArrayList<Integer> listWithOddAndEvenNumbers = new ArrayList<>();
        ArrayList<Integer> listWithEvenNumbers = new ArrayList<>();

        listWithOddAndEvenNumbers.add(1);
        listWithOddAndEvenNumbers.add(2);
        listWithOddAndEvenNumbers.add(3);
        listWithOddAndEvenNumbers.add(4);
        listWithOddAndEvenNumbers.add(5);

        listWithEvenNumbers.add(2);
        listWithEvenNumbers.add(4);

        ArrayList<Integer> processedList = exterminator.exterminate(listWithOddAndEvenNumbers);

        Assert.assertEquals(listWithEvenNumbers, processedList);
    }
}
