package com.kodilla.sudoku;

import com.kodilla.sudoku.board_examples.ExampleBoards;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolverTestSuite {

    ExampleBoards exampleBoards = new ExampleBoards();

    @Test
    public void testGetElementsInRow() {
        //Given
        SudokuBoard sudokuBoard = exampleBoards.createBoardForErrorChecks();
        Solver solver = new Solver(sudokuBoard);

        //When
        List<SudokuElement> elements = solver.getElementsInRow(6);

        //Then
    }

    @Test
    public void testGetElementsInColumn() {
        //Given
        SudokuBoard sudokuBoard = exampleBoards.createBoardForErrorChecks();
        Solver solver = new Solver(sudokuBoard);

        //When
        List<SudokuElement> elements = solver.getElementsInColumn(4);

        elements.forEach(element -> element.setValue(8));

        //Then
        System.out.println(sudokuBoard);
    }

    @Test
    public void testGetElementsInBlock() {
        //Given
        SudokuBoard sudokuBoard = exampleBoards.createBoardForErrorChecks();
        Solver solver = new Solver(sudokuBoard);

        //When
        List<SudokuElement> elements = solver.getElementsInBlock(8,1);

        elements.forEach(element -> element.setValue(9));

        //Then
        System.out.println(sudokuBoard);
    }

    @Test
    public void testCheckRow() {
        //Given
        SudokuBoard sudokuBoard = exampleBoards.createBoardForErrorChecks();
        Solver solver = new Solver(sudokuBoard);

        //When
        solver.checkRow(1);

        //Then
        System.out.println(sudokuBoard.getRows().get(1).getElements().get(5).getAvailableValues());
    }

    @Test
    public void testCheckBlocks() {
        //Given
        SudokuBoard sudokuBoard = exampleBoards.createBoardForErrorChecks();
        Solver solver = new Solver(sudokuBoard);

        //When
        solver.checkBlocks();

        //Then
    }
}
