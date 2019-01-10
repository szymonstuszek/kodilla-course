package com.kodilla.sudoku;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    private SudokuBoard sudokuBoard;

    public Algorithm(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }


    private boolean isSudokuElementEmpty(int column, int row) {
        SudokuElement sudokuElement = sudokuBoard.getElementUnderGivenIndexes(column, row);
        if(sudokuElement.getValue() == Constants.EMPTY_FIELD) {
            return true;
        }
        System.out.println("Field is not empty");
        return false;
    }

    public static void removeValueFromList(int value, SudokuElement element) {
        element.getAvailableValues().remove(Integer.valueOf(value));
    }

    public static void removeValueFromListsInRow(int value, SudokuRow row) {
        for(SudokuElement element:  row.getElementRow()) {
            Algorithm.removeValueFromList(value, element);
        }
    }

    public static void removeValueFromListsInColumn(int value, int elementIndex, SudokuBoard board) {
        for (int i = 0; i < Constants.NUMBER_OF_ROWS; i++) {
            SudokuElement element = board.getBoard().get(i).getElementRow().get(elementIndex);
            removeValueFromList(value, element);
        }
    }

    public static void removeValueFromListsInBlock(int row, int col, int value, SudokuBoard sudokuBoard) {
        SudokuRow sudokuRow;
        SudokuElement sudokuElement;
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
//                System.out.print("Element of index: " + i + "," + j + " ");
                sudokuRow = sudokuBoard.getBoard().get(i);
                sudokuElement = sudokuRow.getElementRow().get(j);
                removeValueFromList(value, sudokuElement);
//                displayAvailableValuesForSudokuElement(sudokuElement);
            }
        }
    }

    public void checkSudokuBoard() {
        boolean anyActionMade = false;

        for(int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                System.out.println("Algorithm at column: " + column + " row " + row);
                if(isSudokuElementEmpty(column, row)) {

                }
            }
        }

    }

    public void removeNumberIfAlreadyInRow(List<Integer> values, int row) {
        SudokuRow sudokuRow = sudokuBoard.getBoard().get(row);

        for (int i = 0; i < 9; i++) {
            SudokuElement sudokuElement = sudokuRow.getElementRow().get(i);
            for(int j = 0; j < sudokuElement.getAvailableValues().size(); j++) {

            }
        }

    }

    public void checkSudokuElementsInRow() {

    }

    public void checkSudokuElementsInColumn() {

    }

    public void checkSudokuElementsInBlock() {

    }

    public static void displayAvailableValuesForSudokuElement(SudokuElement sudokuElement) {
        System.out.print("Available values: ");
        List<Integer> values = sudokuElement.getAvailableValues();
        values.forEach(System.out::print);
        System.out.println();
    }
}
