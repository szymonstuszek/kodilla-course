package com.kodilla.testing.shape;

import org.junit.*;


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
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5);

        shapeCollector.addFigure(square);

        boolean result = shapeCollector.addFigure(square);

        int numberOfFigures = shapeCollector.showFigures();

        Assert.assertEquals(2, numberOfFigures);
        Assert.assertTrue(result);
    }

    @Test
    public void testRemoveFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5);
        Shape circle = new Circle(5);

        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);

        shapeCollector.removeFigure(square);
        boolean result = shapeCollector.removeFigure(circle);

        int numberOfFigures = shapeCollector.showFigures();

        Assert.assertEquals(0, numberOfFigures);
        Assert.assertTrue(result);
    }

    @Test
    public void testGetFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5);

        shapeCollector.addFigure(square);

        Shape retrievedFigure = shapeCollector.getFigure(0);

        Assert.assertEquals(square, retrievedFigure);
    }

    @Test
    public void testShowFigures() {
        ShapeCollector shapeCollector = new ShapeCollector();

        int sizeOfTheFiguresList = shapeCollector.showFigures();

        Assert.assertEquals(0, sizeOfTheFiguresList);
    }
}
