package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

public class AlgorithmTestSuite {

    @Test
    public void testRemoveValueFromList() {
        //Given
        SudokuElement element = new SudokuElement();

        //When
        Algorithm.removeValueFromList(4, element);

        //Then
        Assert.assertEquals(8, element.getAvailableValues().size());
    }

    @Test
    public void testRemoveValueFromListsInRow() {
        //Given
        SudokuRow row = new SudokuRow();
        int value = 8;

        //When
        Algorithm.removeValueFromListsInRow(value, row);

        boolean containsRemovedValue = row.getElementRow().contains(Integer.valueOf(value));

        for(int i = 0; i < row.getElementRow().size(); i++) {
            System.out.print("Row - element index: " + i + " avaiable values: ");
            row.getElementRow().get(i).getAvailableValues().forEach(System.out::print);
            System.out.println();
        }

        //Then
        Assert.assertEquals(false, containsRemovedValue);
    }

    @Test
    public void testRemoveValueFromListsInColumn() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        int value = 8;
        int elementIndex = 1;
        int rowToCheck = 4;

        //When
        Algorithm.removeValueFromListsInColumn(value, elementIndex, sudokuBoard);
        int numberOfAvailableValues = sudokuBoard.getBoard().get(rowToCheck)
                .getElementRow().get(elementIndex)
                .getAvailableValues().size();

        //use streams?
        for(int i = 0; i < Constants.NUMBER_OF_ROWS; i++) {
            System.out.print("Column - element index: " + i + " avaiable values: ");
            sudokuBoard.getBoard().get(i)
                    .getElementRow().get(elementIndex)
                        .getAvailableValues().forEach(System.out::print);
            System.out.println();
        }

        //Then
        Assert.assertEquals(8, numberOfAvailableValues);
    }

    @Test
    public void testRemoveValueFromListsInBlock() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        int value = 3;
        int columnIndex = 0;
        int rowIndex = 0;

        //When
        Algorithm.removeValueFromListsInBlock(rowIndex, columnIndex, value, sudokuBoard);

        //Then
    }
}
