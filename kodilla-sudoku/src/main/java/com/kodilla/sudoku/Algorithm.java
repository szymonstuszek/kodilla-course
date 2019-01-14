package com.kodilla.sudoku;

import com.kodilla.sudoku.exceptions.Backtrack;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Algorithm {
    private SudokuBoard sudokuBoard;
    private List<Backtrack> backtrack = new ArrayList<>();
    private Random random = new Random();

    public boolean solve() {
        boolean isSolved = isSudokuSolved();

        if (!isSolved) {
            guessValue();
            boolean isBoardValid = checkIfBoardIsValid();

            if(isBoardValid) {
                solve();
                isSolved = isSudokuSolved();

            } else {
                Backtrack previousBacktrack = backtrack.get(backtrack.size() - 1);
                setSudokuBoard(previousBacktrack.getSudokuBoard());

                SudokuElement sudokuElement =
                        sudokuBoard.getElementUnderGivenIndexes(previousBacktrack.getColumn(), previousBacktrack.getRow());
                List<Integer> availableValues = sudokuElement.getAvailableValues();

                int lastGuessedValue = previousBacktrack.getValue();
                availableValues.remove(Integer.valueOf(lastGuessedValue));


            }
        }

        System.out.println("Is it really solved: " + isSolved);
        return isSolved;
    }

    private boolean checkIfBoardIsValid() {
        boolean isBoardValid = true;
        boolean hasErrors;

        updateSudokuBoard();
        hasErrors = checkIfBoardHasErrors();

        if(hasErrors) {
            System.out.println("Board has errors");
            isBoardValid = false;
        }

        return isBoardValid;
    }

    private boolean checkIfBoardHasErrors() {
        boolean hasErrors = false;
        int errorCount = 0;

        //check if empty and no value assigned

        //check if value is only possibility in field
        //and is already assigned to another field
        for(int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                SudokuElement sudokuElement = sudokuBoard.getElementUnderGivenIndexes(column, row);
                if (sudokuElement.getValue() == -1) {
                    List<Integer> availableValues = sudokuElement.getAvailableValues();
                    if (availableValues.size() == 0) {
                        errorCount++;
                    }

                    if (availableValues.size() == 1) {
                        for (int i = 0; i < availableValues.size(); i++) {

                        }
                    }

                }
            }
        }

        return errorCount > 0;
    }



    private void guessValue() {
        SudokuElement sudokuElement = getNextEmptyElement();

        if (sudokuElement != null) {
            List<Integer> availableValues = sudokuElement.getAvailableValues();

            if (availableValues.size() > 0) {
                int indexOfGuessedValue = random.nextInt(availableValues.size());
                int guessedValue = availableValues.get(indexOfGuessedValue);
                int column = getNextEmptyColumnIndex();
                int row = getNextEmptyRowIndex();

                System.out.println("Putting into backtrack:");
                System.out.println(sudokuBoard.toString());

                SudokuBoard clonedBoard = null;
                try {
                    clonedBoard = sudokuBoard.deepCopy();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

                Backtrack backtrackEntry = new Backtrack(clonedBoard, column, row, guessedValue);
                backtrack.add(backtrackEntry);
                sudokuElement.setValue(guessedValue);

            }
        }
    }

    private SudokuElement getNextEmptyElement() {
        SudokuElement sudokuElement = null;

        for(int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                sudokuElement = sudokuBoard.getElementUnderGivenIndexes(column, row);
                if (sudokuElement.getValue() == -1) {
                    return sudokuElement;
                }
            }
        }

        return sudokuElement;
    }

    private int getNextEmptyColumnIndex() {
        SudokuElement sudokuElement = null;

        for(int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                sudokuElement = sudokuBoard.getElementUnderGivenIndexes(column, row);
                if (sudokuElement.getValue() == -1) {
                    return column;
                }
            }
        }

        return 0;
    }

    private int getNextEmptyRowIndex() {
        SudokuElement sudokuElement = null;

        for(int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                sudokuElement = sudokuBoard.getElementUnderGivenIndexes(column, row);
                if (sudokuElement.getValue() == -1) {
                    return row;
                }
            }
        }

        return 0;
    }

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


    public void updateSudokuBoard() {
        boolean isAnyActionMade = true;
        int count = 0;

        while(isAnyActionMade) {
            int actionsCount = 0;
            count++;

            //integer errorCount

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

    public boolean isSudokuSolved() {
        boolean sudokuResolved;

        List<SudokuElement> allElements = sudokuBoard.getBoard().stream()
                .flatMap(row -> row.getElements().stream())
                .collect(Collectors.toList());

        sudokuResolved = allElements.stream()
                .noneMatch(element -> element.getValue() == -1);

        if(sudokuResolved) System.out.println("All elements filled out");

        return sudokuResolved;
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