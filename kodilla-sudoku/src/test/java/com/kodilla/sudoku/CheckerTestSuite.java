package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckerTestSuite {

    @Test
    public void checkUpdateBoard() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        Checker checker = new Checker(sudokuBoard);

        SudokuElement element1 = sudokuBoard.getElementUnderGivenIndexes(1, 1);
        SudokuElement element2 = sudokuBoard.getElementUnderGivenIndexes(8, 0);
        SudokuElement element3 = sudokuBoard.getElementUnderGivenIndexes(5, 8);
        SudokuElement element4 = sudokuBoard.getElementUnderGivenIndexes(4, 2);

        SudokuElement elementToCheckColumn1Row0 = sudokuBoard.getElementUnderGivenIndexes(1, 0);
        SudokuElement elementToCheckColumn0Row1 = sudokuBoard.getElementUnderGivenIndexes(0, 1);
        SudokuElement elementToCheckColumn8Row1 = sudokuBoard.getElementUnderGivenIndexes(8, 1);
        SudokuElement elementToCheckColumn3Row1 = sudokuBoard.getElementUnderGivenIndexes(3, 1);
        SudokuElement elementToCheckColumn4Row7 = sudokuBoard.getElementUnderGivenIndexes(4, 7);
        SudokuElement elementToCheckColumn5Row1 = sudokuBoard.getElementUnderGivenIndexes(5, 1);

        element1.setValue(8);
        element2.setValue(5);
        element3.setValue(2);
        element4.setValue(7);

        System.out.println(sudokuBoard.toString());
        System.out.println("Values available before check elementToCheckColumn1Row0: " + elementToCheckColumn1Row0.getAvailableValues());
        System.out.println("Values available before check elementToCheckColumn0Row1: " + elementToCheckColumn0Row1.getAvailableValues());
        System.out.println("Values available before check elementToCheckColumn8Row1: " + elementToCheckColumn8Row1.getAvailableValues());
        System.out.println("Values available before check elementToCheckColumn3Row1: " + elementToCheckColumn3Row1.getAvailableValues());
        System.out.println("Values available before check elementToCheckColumn4Row7: " + elementToCheckColumn4Row7.getAvailableValues());
        System.out.println("Values available before check elementToCheckColumn5Row1: " + elementToCheckColumn5Row1.getAvailableValues());
        //When

        //Then
        checker.checkIfBoardIsValid();
        System.out.println("Values available before check elementToCheckColumn1Row0: " + elementToCheckColumn1Row0.getAvailableValues());
        System.out.println("Values available before check elementToCheckColumn0Row1: " + elementToCheckColumn0Row1.getAvailableValues());
        System.out.println("Values available before check elementToCheckColumn8Row1: " + elementToCheckColumn8Row1.getAvailableValues());
        System.out.println("Values available before check elementToCheckColumn3Row1: " + elementToCheckColumn3Row1.getAvailableValues());
        System.out.println("Values available before check elementToCheckColumn4Row7: " + elementToCheckColumn4Row7.getAvailableValues());
        System.out.println("Values available before check elementToCheckColumn5Row1: " + elementToCheckColumn5Row1.getAvailableValues());
    }

    @Test
    public void checkUpdateBoardForLastAvailableValue() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        Checker checker = new Checker(sudokuBoard);

        SudokuElement element1 = sudokuBoard.getElementUnderGivenIndexes(0, 0);
        SudokuElement element2 = sudokuBoard.getElementUnderGivenIndexes(1, 0);
        SudokuElement element3 = sudokuBoard.getElementUnderGivenIndexes(2, 0);
        SudokuElement element4 = sudokuBoard.getElementUnderGivenIndexes(8, 6);
        SudokuElement element5 = sudokuBoard.getElementUnderGivenIndexes(8, 7);
        SudokuElement element6 = sudokuBoard.getElementUnderGivenIndexes(8, 8);
        SudokuElement element7 = sudokuBoard.getElementUnderGivenIndexes(6, 2);
        SudokuElement element8 = sudokuBoard.getElementUnderGivenIndexes(7, 2);
        SudokuElement elementToCheck = sudokuBoard.getElementUnderGivenIndexes(8, 8);

        element1.setValue(1);
        element2.setValue(2);
        element3.setValue(3);
        element4.setValue(4);
        element5.setValue(5);
        element6.setValue(6);
        element7.setValue(7);
        checker.checkIfBoardIsValid();
        System.out.println(sudokuBoard.toString());
        System.out.println("Values available for col 8 row 8 " + elementToCheck.getAvailableValues());

        //When
        element8.setValue(8);
        checker.checkIfBoardIsValid();

        //Then
        System.out.println(sudokuBoard.toString());
        System.out.println("Values available for col 8 row 8 " + elementToCheck.getAvailableValues());
    }

    @Test
    public void testCheckForValuesRepeatedInRows() {
        //Given
        SudokuBoard correctSudokuBoard = new SudokuBoard();
        Checker checker = new Checker(correctSudokuBoard);

        SudokuBoard boardWithError = new SudokuBoard();
        Checker checker2 = new Checker(boardWithError);


        SudokuElement element1 = correctSudokuBoard.getElementUnderGivenIndexes(4, 0);
        SudokuElement element2 = correctSudokuBoard.getElementUnderGivenIndexes(5, 0);

        SudokuElement element3 = boardWithError.getElementUnderGivenIndexes(4, 0);
        SudokuElement element4 = boardWithError.getElementUnderGivenIndexes(5, 0);
        SudokuElement element5 = boardWithError.getElementUnderGivenIndexes(0, 8);
        SudokuElement element6 = boardWithError.getElementUnderGivenIndexes(1, 8);

        element1.setValue(7);
        element2.setValue(8);

        element3.setValue(5);
        element4.setValue(5);
        element5.setValue(1);
        element6.setValue(1);

        System.out.println(correctSudokuBoard);
        System.out.println(boardWithError);


        //When
        boolean isValid = checker.checkIfBoardIsValid();
        boolean isValid2 = checker2.checkIfBoardIsValid();

        //Then
        Assert.assertEquals(true, isValid);
        Assert.assertEquals(false, isValid2);
    }


    @Test
    public void testCheckForValuesRepeatedInColumns() {
        //Given
        SudokuBoard correctSudokuBoard = new SudokuBoard();
        Checker checker = new Checker(correctSudokuBoard);

        SudokuBoard boardWithError = new SudokuBoard();
        Checker checker2 = new Checker(boardWithError);


        SudokuElement element1 = correctSudokuBoard.getElementUnderGivenIndexes(0, 0);
        SudokuElement element2 = correctSudokuBoard.getElementUnderGivenIndexes(0, 1);
        SudokuElement element3 = correctSudokuBoard.getElementUnderGivenIndexes(0, 3);

        SudokuElement element4 = boardWithError.getElementUnderGivenIndexes(0, 0);
        SudokuElement element5 = boardWithError.getElementUnderGivenIndexes(0, 1);
        SudokuElement element6 = boardWithError.getElementUnderGivenIndexes(5, 3);
        SudokuElement element7 = boardWithError.getElementUnderGivenIndexes(5, 4);

        element1.setValue(7);
        element2.setValue(8);
        element3.setValue(5);


        element4.setValue(5);
        element5.setValue(5);
        element6.setValue(8);
        element7.setValue(8);

        System.out.println(correctSudokuBoard);
        System.out.println(boardWithError);

        //When
        boolean isValid = checker.checkIfBoardIsValid();
        boolean isValid2 = checker2.checkIfBoardIsValid();

        //Then
        Assert.assertEquals(true, isValid);
        Assert.assertEquals(false, isValid2);
    }

    @Test
    public void testCheckForValuesRepeatedInBlock() {
        //Given
        SudokuBoard correctSudokuBoard = new SudokuBoard();
        Checker checker = new Checker(correctSudokuBoard);

        SudokuBoard boardWithError = new SudokuBoard();
        Checker checker2 = new Checker(boardWithError);


        SudokuElement element1 = correctSudokuBoard.getElementUnderGivenIndexes(0, 0);
        SudokuElement element2 = correctSudokuBoard.getElementUnderGivenIndexes(1, 1);
        SudokuElement element3 = correctSudokuBoard.getElementUnderGivenIndexes(2, 2);

        SudokuElement element4 = boardWithError.getElementUnderGivenIndexes(0, 0);
        SudokuElement element5 = boardWithError.getElementUnderGivenIndexes(1, 1);
        SudokuElement element6 = boardWithError.getElementUnderGivenIndexes(8, 8);
        SudokuElement element7 = boardWithError.getElementUnderGivenIndexes(7, 7);

        element1.setValue(1);
        element2.setValue(2);
        element3.setValue(3);

        element4.setValue(5);
        element5.setValue(5);
        element6.setValue(9);
        element7.setValue(9);

        System.out.println(correctSudokuBoard);
        System.out.println(boardWithError);

        //When
        boolean isValid = checker.checkIfBoardIsValid();
        boolean isValid2 = checker2.checkIfBoardIsValid();

        //Then
        Assert.assertEquals(true, isValid);
        Assert.assertEquals(false, isValid2);
    }

    @Test
    public void testCheckForEmptyFieldsWithNoAvailableVaues() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        Checker checker = new Checker(sudokuBoard);

        List<Integer> listWithNoAvailableValues = new ArrayList<>();

        SudokuElement elementWithError = sudokuBoard.getElementUnderGivenIndexes(0, 0);

        elementWithError.setAvailableValues(listWithNoAvailableValues);

        //When

        //Then
        boolean isValid = checker.checkIfBoardIsValid();

        Assert.assertEquals(false, isValid);
    }
}
