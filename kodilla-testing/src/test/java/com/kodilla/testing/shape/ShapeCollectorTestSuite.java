package com.kodilla.testing.shape;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ShapeCollectorTestSuite {
    private static int testCounter  = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("Tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test#" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5);

        shapeCollector.addFigure(square);

        //When
        boolean result = shapeCollector.addFigure(square);
        int numberOfFigures = shapeCollector.showFigures();

        //Then
        assertEquals(2, numberOfFigures);
        assertTrue(result);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5);
        Shape circle = new Circle(5);

        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);

        shapeCollector.removeFigure(square);

        //When
        boolean result = shapeCollector.removeFigure(circle);

        int numberOfFigures = shapeCollector.showFigures();

        //Then
        assertEquals(0, numberOfFigures);
        assertTrue(result);
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5);

        shapeCollector.addFigure(square);

        //When
        Shape retrievedFigure = shapeCollector.getFigure(0);

        //Then
        assertEquals(square, retrievedFigure);
    }

    @Test
    public void testShowFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();


        //When
        int sizeOfTheFiguresList = shapeCollector.showFigures();

        //Then
        assertEquals(0, sizeOfTheFiguresList);
    }
}
