package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

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

        boolean containsRemovedValue = row.getElements().contains(Integer.valueOf(value));

        for(int i = 0; i < row.getElements().size(); i++) {
            System.out.print("Row - element index: " + i + " avaiable values: ");
            row.getElements().get(i).getAvailableValues().forEach(System.out::print);
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
                .getElements().get(elementIndex)
                .getAvailableValues().size();

        //use streams?
        for(int i = 0; i < Constants.NUMBER_OF_ROWS; i++) {
            System.out.print("Column - element index: " + i + " avaiable values: ");
            sudokuBoard.getBoard().get(i)
                    .getElements().get(elementIndex)
                        .getAvailableValues().forEach(System.out::print);
            System.out.println();
        }

        //Then
        Assert.assertEquals(8, numberOfAvailableValues);
    }

    @Test
    public void testCheckElementsInBlock() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        Algorithm algorithm = new Algorithm(sudokuBoard);

        int column = 0;
        int row = 0;
        SudokuElement sudokuElement = sudokuBoard.getElementUnderGivenIndexes(0, 0);

        //When
        algorithm.checkElementsInBlock(sudokuElement, 0,0);

        //Then
    }

    @Test
    public void testRemoveValuesFromList() {
        //Given
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //When
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Removing: " + i);
            list.remove(i);
            System.out.println("List size: " + list.size());
        }

        System.out.println(list.size());
        //Then
    }
}
