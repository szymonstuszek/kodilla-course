package com.kodilla.sudoku;

import com.kodilla.sudoku.boards.examples.ExampleBoards;
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
        board.getRows().get(1).getElements().get(4).setValue(4);

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
        sudokuBoard.getRows().get(0).getElements().get(0).setValue(1);

        SudokuBoard clonedBoard = null;
        try{
            clonedBoard = sudokuBoard.deepCopy();
        }catch(Exception e) {
            System.out.println("Could not copy board.");
        }

        sudokuBoard.getRows().get(0).getElements().get(1).setValue(2);
        sudokuBoard.getRows().get(0).getElements().get(2).setValue(3);

        //When
        int valueInFirstElementInOriginalBoard = sudokuBoard.getRows().get(0).getElements().get(0).getValue();
        int valueInFirstElementInClonedBoard = clonedBoard.getRows().get(0).getElements().get(0).getValue();

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

    @Test
    public void testGetElementsInRow() {
        //Given
        SudokuBoard sudokuBoard = ExampleBoards.createBoardForErrorChecks();

        //When
        List<SudokuElement> elements = sudokuBoard.getElementsInRow(3);

        elements.stream()
                .forEach(e -> e.setValue(5));

        //Then
        System.out.println(sudokuBoard.toString());
    }

    @Test
    public void testGetElementsInColumn() {
        //Given
        SudokuBoard sudokuBoard = ExampleBoards.createBoardForErrorChecks();

        //When
        List<SudokuElement> elements = sudokuBoard.getElementsInColumn(3);

        elements.stream()
                .forEach(e -> e.setValue(5));

        //Then
        System.out.println(sudokuBoard.toString());
    }

    @Test
    public void testGetElementsInBlock() {
        //Given
        SudokuBoard sudokuBoard = ExampleBoards.createBoardForErrorChecks();

        //When
        List<SudokuElement> elements = sudokuBoard.getElementsInBlock(8,1);

        elements.forEach(element -> element.setValue(9));

        //Then
        System.out.println(sudokuBoard);
    }

    @Test
    public void testIsAnyElementEmpty() {
        //Given
        SudokuBoard sudokuBoard = ExampleBoards.createBoardForErrorChecks();
        SudokuBoard fullBoard = ExampleBoards.createFilledOutBoard();

        //When


        //Then
        Assert.assertEquals(true, sudokuBoard.isAnyElementEmpty());
        Assert.assertEquals(false, fullBoard.isAnyElementEmpty());

    }
}
