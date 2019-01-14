package com.kodilla.sudoku;

import com.kodilla.sudoku.board_examples.ExampleBoards;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
        board.getBoard().get(1).getElements().get(4).setValue(4);

        //Then
        System.out.println(board.toString());
    }

    @Test
    public void testCheckAvailableValues() {
        //Given
        SudokuBoard board = new SudokuBoard();
        SudokuElement sudokuElement = board.getElementUnderGivenIndexes(1,1);

        //When
        sudokuElement.removeValueFromAvailableValues(2);
        sudokuElement.removeValueFromAvailableValues(3);

        List<Integer> values = sudokuElement.getAvailableValues();

        //Then
        Assert.assertEquals(7, sudokuElement.getAvailableValues().size());
    }

    @Test
    public void testDeepClone() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initializeBoard();
        sudokuBoard.getBoard().get(0).getElements().get(0).setValue(1);

        SudokuBoard clonedBoard = null;
        try{
            clonedBoard = sudokuBoard.deepCopy();
        }catch(Exception e) {
            System.out.println("Could not copy board.");
        }

        sudokuBoard.getBoard().get(0).getElements().get(1).setValue(2);
        sudokuBoard.getBoard().get(0).getElements().get(2).setValue(3);

        //When
        int valueInFirstElementInOriginalBoard = sudokuBoard.getBoard().get(0).getElements().get(0).getValue();
        int valueInFirstElementInClonedBoard = clonedBoard.getBoard().get(0).getElements().get(0).getValue();

        //Then
        System.out.println("Original board");
        System.out.println(sudokuBoard.toString());
        System.out.println("Cloned board");
        System.out.println(clonedBoard.toString());
        Assert.assertEquals(valueInFirstElementInOriginalBoard, valueInFirstElementInClonedBoard);
    }

    @Test
    public void testCreateFilledOutBoard() {
        //Given
        SudokuBoard sudokuBoard = ExampleBoards.createFilledOutBoard();

        //When

        //Then
        System.out.println(sudokuBoard.toString());
    }
}
