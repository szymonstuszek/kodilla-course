package com.kodilla.sudoku;

import org.junit.Test;

public class SudokuGameTestSuite {

    @Test
    public void testSetGame() {
        //Given
        SudokuGame sudokuGame = new SudokuGame();
        SudokuBoard sudokuBoard = sudokuGame.getSudokuBoard();
        SudokuSolver solver = new SudokuSolver(sudokuBoard);

        SudokuBoard boardToSet = new SudokuBoard();

        //When
        SudokuElement sudokuElement = boardToSet.getElementUnderGivenIndexes(0, 0);
        sudokuElement.setValue(9);

        System.out.println(sudokuGame.getSudokuBoard().toString());
        System.out.println(boardToSet.toString());

        //Then
    }

}
