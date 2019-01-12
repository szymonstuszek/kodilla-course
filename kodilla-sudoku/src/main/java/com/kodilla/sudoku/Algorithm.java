package com.kodilla.sudoku;

import java.util.List;
import java.util.Random;

public class Algorithm {
    private SudokuBoard sudokuBoard;
    private Random random = new Random();

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

    public void solveSudoku() {
        int emptyFieldCount = 0;

        for(int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (isSudokuElementEmpty(column, row)) {
                    SudokuElement sudokuElement = sudokuBoard.getElementUnderGivenIndexes(column, row);
                    System.out.println("Field " + (column + 1) + " " + (row + 1));
                    sudokuBoard.checkAvailableValues(column, row);
                    guessValue(sudokuElement);
                    System.out.println(sudokuBoard.toString());
                    checkSudokuBoard();

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void guessValue(SudokuElement sudokuElement) {
        List<Integer> availableValues = sudokuElement.getAvailableValues();
        System.out.println("Guessing value from: " + availableValues.size());
        availableValues.forEach(System.out::print);
        int guessedValue = random.nextInt(availableValues.size());
        sudokuElement.setValue(availableValues.get(guessedValue));
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

    public void goBack() {
        //if field empty and no available value for it
        //if only option for field is already on board
        //use backtrack
    }

    public void checkElementsInRow(SudokuElement sudokuElement, int row) {
        checkIfValueIsAssignedInRow(sudokuElement, row);
        checkIfValueIsAllowedInRow(sudokuElement, row);



        //if array is empty, and no value is assigned -> error -> backtrack
    }

    private void checkIfValueIsAssignedInRow(SudokuElement sudokuElement, int row){
        SudokuRow sudokuRow = sudokuBoard.getBoard().get(row);

        List<Integer> availableValues = sudokuElement.getAvailableValues();

        //check for error?


        //separate method to check if the value is assigned to another field
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

    private void checkIfValueIsAllowedInRow(SudokuElement sudokuElement, int row) {
        List<Integer> availableValues = sudokuElement.getAvailableValues();

        //check for error?

        for (int i = 0; i < availableValues.size(); i++) {
            boolean isValueAvailableForAnotherField = false;

            for (int column = 0; column < 9; column++) {
                if (isSudokuElementEmpty(column, row)) {
                    SudokuElement currentElement = sudokuBoard.getElementUnderGivenIndexes(column, row);
                    List<Integer> possibleValuesInCurrentElement = currentElement.getAvailableValues();
                    if (possibleValuesInCurrentElement.contains(Integer.valueOf(availableValues.get(i)))) {
                        isValueAvailableForAnotherField = true;
                    }
                }
            }

            if (!isValueAvailableForAnotherField) {
                System.out.println("Value is not available for another field: ");
                System.out.println("Setting: " + availableValues.get(i) + " at row: " + row);
                sudokuElement.setValue(availableValues.get(i));
            }
        }
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

    private void checkIfValueIsPossibleForAnotherField() {

    }

    public void removeNumberIfAlreadyInRow(List<Integer> values, int row) {
        SudokuRow sudokuRow = sudokuBoard.getBoard().get(row);

        for (int i = 0; i < 9; i++) {
            SudokuElement sudokuElement = sudokuRow.getElements().get(i);
            for(int j = 0; j < sudokuElement.getAvailableValues().size(); j++) {

            }
        }
    }

    public static void displayAvailableValuesForSudokuElement(SudokuElement sudokuElement) {
        System.out.print("Available values: ");
        List<Integer> values = sudokuElement.getAvailableValues();
        values.forEach(System.out::print);
        System.out.println();
    }
}