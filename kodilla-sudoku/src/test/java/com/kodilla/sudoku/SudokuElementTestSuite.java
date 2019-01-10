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
}
