package com.kodilla.sudoku;

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
        return false;
    }

    private boolean checkIfHasOnlyOneAvailableValue(SudokuElement sudokuElement) {
        if (sudokuElement.getAvailableValues().size() == 1) {
            int availableValue = sudokuElement.getAvailableValues().get(0);
            sudokuElement.setValue(availableValue);
            return true;
        }
        return false;
    }

    public static void removeValueFromList(int value, SudokuElement element) {
        element.getAvailableValues().remove(Integer.valueOf(value));
    }

    public static void removeValueFromListsInRow(int value, SudokuRow row) {
        for(SudokuElement element:  row.getElements()) {
            Algorithm.removeValueFromList(value, element);
        }
    }

    public static void removeValueFromListsInColumn(int value, int elementIndex, SudokuBoard board) {
        for (int i = 0; i < Constants.NUMBER_OF_ROWS; i++) {
            SudokuElement element = board.getBoard().get(i).getElements().get(elementIndex);
            removeValueFromList(value, element);
        }
    }

    public void checkSudokuBoard() {
        boolean anyActionMade = false;

        for(int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                if(isSudokuElementEmpty(column, row)) {
//                    System.out.println("Algorithm at column: " + column + " row " + row);
                    SudokuElement sudokuElement = sudokuBoard.getElementUnderGivenIndexes(column, row);

                    checkElementsInRow(sudokuElement, row);
                    checkElementsInColumn(sudokuElement, column);
                    checkElementsInBlock(sudokuElement, row, column);
                }
            }
        }
    }

    public void checkElementsInRow(SudokuElement sudokuElement, int row) {
        SudokuRow sudokuRow = sudokuBoard.getBoard().get(row);

        List<Integer> availableValues = sudokuElement.getAvailableValues();

        for (int i = 0; i < availableValues.size(); i++) {
            for (int j = 0; j < 9; j++) {
                int valueInCurrentField = sudokuRow.getElements().get(j).getValue();
                if (availableValues.get(i) == valueInCurrentField) {
                    sudokuElement.markValueForRemoval(availableValues.get(i));
                }
            }
        }

        sudokuElement.removeMarkedValues();
        checkIfHasOnlyOneAvailableValue(sudokuElement);
    }

    public void checkElementsInColumn(SudokuElement sudokuElement, int column) {
        List<Integer> availableValues = sudokuElement.getAvailableValues();

        for (int i = 0; i < availableValues.size(); i++) {
            for (int row = 0; row < 9; row++) {
                int valueInCurrentField = sudokuBoard.getBoard().get(row).getElements().get(column).getValue();
                if(availableValues.get(i) == valueInCurrentField) {
                    sudokuElement.markValueForRemoval(availableValues.get(i));
                }
            }
        }
        sudokuElement.removeMarkedValues();
        checkIfHasOnlyOneAvailableValue(sudokuElement);
    }


    public void checkElementsInBlock(SudokuElement sudokuElement, int row, int column) {
        int r = row - row % 3;
        int c = column - column % 3;

        List<Integer> availableValues = sudokuElement.getAvailableValues();

        for (int k = 0; k < availableValues.size(); k++) {
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {
                    int valueInCurrentField = sudokuBoard.getBoard().get(i).getElements().get(j).getValue();
                    if(availableValues.get(k) == valueInCurrentField) {
                        sudokuElement.markValueForRemoval(availableValues.get(k));
                    }
                }
            }
        }
        sudokuElement.removeMarkedValues();
        checkIfHasOnlyOneAvailableValue(sudokuElement);
    }

    public void removeNumberIfAlreadyInRow(List<Integer> values, int row) {
        SudokuRow sudokuRow = sudokuBoard.getBoard().get(row);

        for (int i = 0; i < 9; i++) {
            SudokuElement sudokuElement = sudokuRow.getElements().get(i);
            for(int j = 0; j < sudokuElement.getAvailableValues().size(); j++) {

            }
        }

    }



    public void checkSudokuElementsInColumn() {

    }


    public static void displayAvailableValuesForSudokuElement(SudokuElement sudokuElement) {
        System.out.print("Available values: ");
        List<Integer> values = sudokuElement.getAvailableValues();
        values.forEach(System.out::print);
        System.out.println();
    }
}
