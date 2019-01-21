package com.kodilla.sudoku;


import com.kodilla.sudoku.boards.examples.ExampleBoards;
import org.junit.Assert;
import org.junit.Test;

public class AlgorithmTestSuite {

    @Test
    public void testGuessValue() {
        //Given
        SudokuBoard fullBoard = ExampleBoards.createFilledOutBoard();
        SudokuSolver algorithm = new SudokuSolver(fullBoard);

        SudokuBoard sudokuBoard = ExampleBoards.createBoardForErrorChecks();
        SudokuSolver algorithm2 = new SudokuSolver(sudokuBoard);

        //When

        //Then
        System.out.println(fullBoard.toString());
        algorithm.guessValue();
        System.out.println(fullBoard.toString());

        System.out.println(sudokuBoard.toString());
        algorithm2.guessValue();
        System.out.println(sudokuBoard.toString());

    }

    @Test
    public void testGuessValueOnElementWithNoValuesAvailable() {
        //Given
        SudokuBoard sudokuBoard = ExampleBoards.createFilledOutBoard();
        SudokuSolver algorithm = new SudokuSolver(sudokuBoard);

        SudokuElement element = sudokuBoard.getElementUnderGivenIndexes(0, 0);
        element.setValue(-1);
        element.getAvailableValues().clear();

        //When
        algorithm.guessValue();

        //Then
        System.out.println(sudokuBoard.toString());
    }

    @Test
    public void testAddingEntriesToBacktracking() {
        //Given
        SudokuBoard sudokuBoard = ExampleBoards.createBoardForErrorChecks();
        SudokuSolver algorithm = new SudokuSolver(sudokuBoard);

        //When
        System.out.println(sudokuBoard.toString());
        algorithm.guessValue();
        System.out.println(sudokuBoard.toString());
        algorithm.guessValue();
        System.out.println(sudokuBoard.toString());

        //Then
        Assert.assertEquals(2, algorithm.getBacktrack().size());
    }

    @Test
    public void testGoBack() {
        //Given
        SudokuBoard sudokuBoard = ExampleBoards.createBoardForErrorChecks();
        SudokuSolver algorithm = new SudokuSolver(sudokuBoard);

        //When
        System.out.println(sudokuBoard.toString());
        algorithm.guessValue();
        System.out.println(sudokuBoard.toString());
        algorithm.guessValue();
        System.out.println(sudokuBoard.toString());
        algorithm.goBack();
        System.out.println(sudokuBoard.toString());

        //Then
        Assert.assertEquals(1, algorithm.getBacktrack().size());
    }

    @Test
    public void testGoBackWhenNoEntries() {
        //Given
        SudokuBoard sudokuBoard = ExampleBoards.createBoardForErrorChecks();
        SudokuSolver algorithm = new SudokuSolver(sudokuBoard);

        //When
        algorithm.solve();

        //Then
    }

}
