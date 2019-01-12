package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Algorithm {
    private SudokuBoard sudokuBoard;
    private Random random = new Random();

    //refactor idea:
    //for column block checks
    //write separate method to gather elements to be checked
    // for example from column or from block
    //put them into an array and do the check?

    public Algorithm(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
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

                    //
                    //to check
                    //

                    updateSudokuBoard();

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

    public void updateSudokuBoard() {
        boolean isAnyActionMade = true;
        int count = 0;

        while(isAnyActionMade) {
            int actionsCount = 0;
            count++;

            for(int row = 0; row < 9; row++) {
                for (int column = 0; column < 9; column++) {
                    if(isSudokuElementEmpty(column, row)) {
//                    System.out.println("Algorithm at column: " + column + " row " + row);
                        SudokuElement sudokuElement = sudokuBoard.getElementUnderGivenIndexes(column, row);

                        //change names of methods
                        boolean anyActionInRows = checkElementsInRow(sudokuElement, row);
                        boolean anyActionInColumns = checkElementsInColumn(sudokuElement, column);
                        boolean anyActionInBlocks = checkElementsInBlock(sudokuElement, row, column);

                        //more elegant solution?
                        //if just one action taken - will return true, no need to check again
                        if (anyActionInRows || anyActionInColumns || anyActionInBlocks) actionsCount++;
                    }
                }
            }

            isAnyActionMade = actionsCount > 0;
            System.out.println("Board checked: " + count + " times.");
            System.out.println("Repeating the loop: " + isAnyActionMade);
        }

    }

    public boolean isSudokuResolved(SudokuBoard sudokuBoard) {
        boolean sudokuResolved = false;

        List<SudokuElement> allElements = sudokuBoard.getBoard().stream()
                .flatMap(row -> row.getElements().stream())
                .collect(Collectors.toList());

        sudokuResolved = allElements.stream()
                .noneMatch(element -> element.getValue() == -1);

        return sudokuResolved;
    }

    public void goBack() {
        //if field empty and no available value for it
        //if only option for field is already on board
        //use backtrack
    }

    private boolean checkElementsInRow(SudokuElement sudokuElement, int row) {
        boolean anyActionTaken = false;

        boolean firstCheck = checkIfValueIsAssignedInRow(sudokuElement, row);
        boolean secondCheck = checkIfValueIsAllowedInRow(sudokuElement, row);
        //if array is empty, and no value is assigned -> error -> backtrack

        if(firstCheck || secondCheck) {
            anyActionTaken = true;
        }

        return anyActionTaken;
    }

    private boolean checkIfValueIsAssignedInRow(SudokuElement sudokuElement, int row){
        boolean anyActionTaken = false;

        SudokuRow sudokuRow = sudokuBoard.getBoard().get(row);

        List<Integer> availableValues = sudokuElement.getAvailableValues();

        //check for error?


        for (int i = 0; i < availableValues.size(); i++) {
            for (int j = 0; j < 9; j++) {
                int valueInCurrentField = sudokuRow.getElements().get(j).getValue();
                if (availableValues.get(i) == valueInCurrentField) {
                    //boolean? if no value is marked, don't call remove method
                    sudokuElement.markValueForRemoval(availableValues.get(i));
                    anyActionTaken = true;
                }
            }
        }

        sudokuElement.removeMarkedValues();
        checkIfHasOnlyOneAvailableValue(sudokuElement);

        return anyActionTaken;
    }

    private boolean checkIfValueIsAllowedInRow(SudokuElement sudokuElement, int row) {
        boolean anyActionTaken = false;

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
                anyActionTaken = true;
            }
        }

        return anyActionTaken;
    }

    private boolean checkElementsInColumn(SudokuElement sudokuElement, int column) {
        boolean anyActionTaken = false;

        boolean firstCheck = checkIfValueIsAssignedInColumn(sudokuElement, column);
        boolean secondCheck = checkIfValueIsAllowedInColumn(sudokuElement, column);
        //if array is empty, and no value is assigned -> error -> backtrack

        if(firstCheck || secondCheck) {
            anyActionTaken = true;
        }

        return anyActionTaken;
    }

    private boolean checkIfValueIsAssignedInColumn(SudokuElement sudokuElement, int column) {
        boolean anyActionTaken = false;

        List<Integer> availableValues = sudokuElement.getAvailableValues();

        for (int i = 0; i < availableValues.size(); i++) {
            for (int row = 0; row < 9; row++) {
                int valueInCurrentField = sudokuBoard.getBoard().get(row).getElements().get(column).getValue();
                if(availableValues.get(i) == valueInCurrentField) {
                    sudokuElement.markValueForRemoval(availableValues.get(i));
                    anyActionTaken = true;
                }
            }
        }
        sudokuElement.removeMarkedValues();
        checkIfHasOnlyOneAvailableValue(sudokuElement);

        return anyActionTaken;
    }

    //duplicate method
    private boolean checkIfValueIsAllowedInColumn(SudokuElement sudokuElement, int column) {
        boolean anyActionTaken = false;

        List<Integer> availableValues = sudokuElement.getAvailableValues();

        //check for error?


        for (int i = 0; i < availableValues.size(); i++) {
            boolean isValueAvailableForAnotherField = false;

            for (int row = 0; row < 9; row++) {
                if (isSudokuElementEmpty(column, row)) {
                    SudokuElement currentElement = sudokuBoard.getElementUnderGivenIndexes(column, row);
                    List<Integer> possibleValuesInCurrentElement = currentElement.getAvailableValues();
//                    System.out.println();
                    if (possibleValuesInCurrentElement.contains(Integer.valueOf(availableValues.get(i)))) {
                        isValueAvailableForAnotherField = true;
                    }
                }
            }

            if (!isValueAvailableForAnotherField) {
                System.out.println("Value is not available for another field: ");
                System.out.println("Setting: " + availableValues.get(i) + " at column: " + column);
                sudokuElement.setValue(availableValues.get(i));
                anyActionTaken = true;
            }
        }

        return anyActionTaken;
    }


    private boolean checkElementsInBlock(SudokuElement sudokuElement, int row, int column) {
        boolean anyActionTaken = false;

        int r = row - row % 3;
        int c = column - column % 3;

        List<Integer> availableValues = sudokuElement.getAvailableValues();

        for (int k = 0; k < availableValues.size(); k++) {
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {
                    int valueInCurrentField = sudokuBoard.getBoard().get(i).getElements().get(j).getValue();
                    if(availableValues.get(k) == valueInCurrentField) {
                        sudokuElement.markValueForRemoval(availableValues.get(k));
                        anyActionTaken = true;
                    }
                }
            }
        }
        sudokuElement.removeMarkedValues();
        checkIfHasOnlyOneAvailableValue(sudokuElement);

        return anyActionTaken;
    }
}