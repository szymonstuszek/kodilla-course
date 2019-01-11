package com.kodilla.sudoku;

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
        sudokuBoard.getBoard().get(0).getElements().get(0).setValue(1);

        SudokuBoard clonedBoard = null;
        try{
            clonedBoard = sudokuBoard.deepCopy();
            System.out.println("What's inside: " + clonedBoard.getBoard().get(0).getElements().get(0).getValue());
        }catch(Exception e) {
            System.out.println("Could not copy board.");
        }

        sudokuBoard.getBoard().get(0).getElements().get(1).setValue(2);

        //When

        //Then
        System.out.println("Original board");
        System.out.println(sudokuBoard.toString());
        System.out.println("Cloned board");
        System.out.println(clonedBoard.toString());
        Assert.assertNotEquals(sudokuBoard, clonedBoard);
    }
}
