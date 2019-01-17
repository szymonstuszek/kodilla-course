package com.kodilla.sudoku;


import com.kodilla.sudoku.board_examples.ExampleBoards;
import org.junit.Assert;
import org.junit.Test;

public class AlgorithmTestSuite {

    @Test
    public void testGuessValue() {
        //Given
        SudokuBoard fullBoard = ExampleBoards.createFilledOutBoard();
        Algorithm algorithm = new Algorithm(fullBoard);

        SudokuBoard sudokuBoard = ExampleBoards.createBoardForErrorChecks();
        Algorithm algorithm2 = new Algorithm(sudokuBoard);

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
        Algorithm algorithm = new Algorithm(sudokuBoard);

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
        Algorithm algorithm = new Algorithm(sudokuBoard);

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
        Algorithm algorithm = new Algorithm(sudokuBoard);

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
        Algorithm algorithm = new Algorithm(sudokuBoard);

        //When
        algorithm.solve();

        //Then
    }

}
