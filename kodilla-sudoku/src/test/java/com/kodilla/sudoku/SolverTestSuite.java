package com.kodilla.sudoku;


import com.kodilla.sudoku.boards.examples.ExampleBoards;
import org.junit.Assert;
import org.junit.Test;

public class SolverTestSuite {

    @Test
    public void testGuessValue() {
        //Given
        SudokuBoard fullBoard = ExampleBoards.createFilledOutBoard();
        SudokuSolver solver = new SudokuSolver(fullBoard);

        SudokuBoard sudokuBoard = ExampleBoards.createBoardForErrorChecks();
        SudokuSolver solver2 = new SudokuSolver(sudokuBoard);

        //When

        //Then
        System.out.println(fullBoard.toString());
        solver.guessValue();
        System.out.println(fullBoard.toString());

        System.out.println(sudokuBoard.toString());
        solver2.guessValue();
        System.out.println(sudokuBoard.toString());

    }

    @Test
    public void testGuessValueOnElementWithNoValuesAvailable() {
        //Given
        SudokuBoard sudokuBoard = ExampleBoards.createFilledOutBoard();
        SudokuSolver solver = new SudokuSolver(sudokuBoard);

        SudokuElement element = sudokuBoard.getElementUnderGivenIndexes(0, 0);
        element.setValue(-1);
        element.getAvailableValues().clear();

        //When
        solver.guessValue();

        //Then
        System.out.println(sudokuBoard.toString());
    }

    @Test
    public void testAddingEntriesToBacktracking() {
        //Given
        SudokuBoard sudokuBoard = ExampleBoards.createBoardForErrorChecks();
        SudokuSolver solver = new SudokuSolver(sudokuBoard);

        //When
        System.out.println(sudokuBoard.toString());
        solver.guessValue();
        System.out.println(sudokuBoard.toString());
        solver.guessValue();
        System.out.println(sudokuBoard.toString());

        //Then
        Assert.assertEquals(2, solver.getBacktrack().size());
    }

    @Test
    public void testGoBack() {
        //Given
        SudokuBoard sudokuBoard = ExampleBoards.createBoardForErrorChecks();
        SudokuSolver solver = new SudokuSolver(sudokuBoard);

        //When
        System.out.println(sudokuBoard.toString());
        solver.guessValue();
        System.out.println(sudokuBoard.toString());
        solver.guessValue();
        System.out.println(sudokuBoard.toString());
        solver.goBack();
        System.out.println(sudokuBoard.toString());

        //Then
        Assert.assertEquals(1, solver.getBacktrack().size());
    }

    @Test
    public void testGoBackWhenNoEntries() {
        //Given
        SudokuBoard sudokuBoard = ExampleBoards.createBoardForErrorChecks();
        SudokuSolver solver = new SudokuSolver(sudokuBoard);

        //When
        solver.solve();

        //Then
    }

}
