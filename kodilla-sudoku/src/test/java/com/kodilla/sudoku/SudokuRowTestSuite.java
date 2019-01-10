package com.kodilla.sudoku;

import org.junit.Test;

public class SudokuRowTestSuite {
    @Test
    public void displaySudokuRow() {
        //Given
        SudokuRow sudokuRow = new SudokuRow();

        //When

        //Then
        System.out.println(sudokuRow.toString());
    }
}
