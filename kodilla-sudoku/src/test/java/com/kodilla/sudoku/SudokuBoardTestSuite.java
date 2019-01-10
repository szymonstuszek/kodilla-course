package com.kodilla.sudoku;

import org.junit.Test;

public class SudokuBoardTestSuite {

    @Test
    public void testDisplayBoard() {
        //Given
        SudokuBoard board = new SudokuBoard();
        //When

        //Then
        System.out.println(board.toString());
    }

    @Test
    public void testSetValueOnBoard() {
        //Given
        SudokuBoard board = new SudokuBoard();

        //When
        board.getBoard().get(1).getElementRow().get(4).setValue(4);

        //Then
        System.out.println(board.toString());
    }
}
