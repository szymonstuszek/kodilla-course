package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SudokuElementTestSuite {

    @Test
    public void testDisplayElement() {
        //Given
        SudokuElement sudokuElement = new SudokuElement();

        //When

        //Then
        System.out.println(sudokuElement.toString());
    }

    @Test
    public void testSetValueOfElement() {
        //Given
        SudokuElement sudokuElement = new SudokuElement();

        //When
        sudokuElement.setValue(3);

        //Then
        System.out.println(sudokuElement.toString());
    }

    @Test
    public void testMarkValueForRemoval() {
        //Given
        SudokuElement sudokuElement = new SudokuElement();

        //When
        sudokuElement.markValueForRemoval(3);

        int markedValue = sudokuElement.getAvailableValues().get(2);

        //Then
        System.out.println(sudokuElement.getAvailableValues());
        Assert.assertEquals(0, markedValue);

    }

    @Test
    public void testRemoveMarkedValues() {
        //Given
        SudokuElement sudokuElement = new SudokuElement();

        //When
        sudokuElement.markValueForRemoval(3);
        sudokuElement.markValueForRemoval(5);
        System.out.println(sudokuElement.getAvailableValues());

        sudokuElement.removeMarkedValues();

        //Then
        System.out.println(sudokuElement.getAvailableValues());
        Assert.assertEquals(7, sudokuElement.getAvailableValues().size());

    }
}
