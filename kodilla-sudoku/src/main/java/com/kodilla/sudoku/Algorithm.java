package com.kodilla.sudoku;

import com.kodilla.sudoku.board_examples.ExampleBoards;
import com.kodilla.sudoku.exceptions.Backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Algorithm {
    private ExampleBoards exampleBoards = new ExampleBoards();
    private SudokuBoard sudokuBoard;
    private ArrayDeque<Backtrack> backtrack = new ArrayDeque<>();
    private Backtrack backtrackHistory;
    private Random random = new Random();
    private int backtrackStepsCount = 0;
    private boolean entryBoardSaved = false;

    public boolean solve() {
        boolean isSolved = false;

        sudokuBoard = exampleBoards.createBoardForErrorChecks();
        updateSudokuBoard();
        System.out.println("Start:");
        System.out.println(sudokuBoard.toString());

        while (!isSolved) {
            isSolved = isSudokuSolved();

            if (!isSolved) {
                guessValue();
                boolean isBoardValid = checkIfBoardIsValid();


                if(isBoardValid) {
                    isSolved = isSudokuSolved();

                } else {
                    backtrackStepsCount++;
                    Backtrack previousBacktrack = backtrack.pollLast();
                    SudokuBoard boardFromBacktrack = previousBacktrack.getSudokuBoard();
                    SudokuElement sudokuElement =
                            boardFromBacktrack.getElementUnderGivenIndexes(previousBacktrack.getColumn(), previousBacktrack.getRow());

                    List<Integer> availableValues = sudokuElement.getAvailableValues();


                    int lastGuessedValue = previousBacktrack.getValue();
                    availableValues.remove(Integer.valueOf(lastGuessedValue));

                    sudokuElement.setValue(-1);

                    setSudokuBoard(boardFromBacktrack);
                    updateSudokuBoard();

                    //no solution, start over
                    if(backtrackStepsCount > 50) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        SudokuBoard history = backtrackHistory.getSudokuBoard();

                        System.out.println("!!!!!!!!!!!!!!!!!!!1111");
                        System.out.println("Entry board " + backtrack.size());
                        System.out.println(history.toString());

                        sudokuElement =
                                history.getElementUnderGivenIndexes(backtrackHistory.getColumn(), backtrackHistory.getRow());
                        int historicalValue = backtrackHistory.getValue();

                        sudokuElement.setValue(-1);

                        setSudokuBoard(history);
                        updateSudokuBoard();
                        backtrackStepsCount = 0;
                        backtrack = new ArrayDeque<>();
                    }

                }
            }
        }
        return isSolved;
    }

    private boolean checkIfBoardIsValid() {
        boolean isBoardValid = true;
        boolean hasErrors;

        updateSudokuBoard();
        hasErrors = checkIfBoardHasErrors();

        if(hasErrors) {
            isBoardValid = false;
        }

        return isBoardValid;
    }

    private boolean checkIfBoardHasErrors() {
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
                        System.out.println("Error at column: " + column + " row: " + row + " no values to choose from");
                    }

                    if (availableValues.size() == 1) {
                        int onlyValue = availableValues.get(0);

                        //row
                        for (int i = 0; i < Constants.SIZE_OF_BOARD; i++) {
                            SudokuElement currentElement = sudokuBoard.getElementUnderGivenIndexes(i, row);
                            int valueInCurrentElement = currentElement.getValue();
                            if(valueInCurrentElement == onlyValue) {
                                errorCount++;
                            }
                        }

                        //column
                        for (int j = 0; j < Constants.SIZE_OF_BOARD; j++) {
                            SudokuElement currentElement = sudokuBoard.getElementUnderGivenIndexes(column, j);
                            int valueInCurrentElement = currentElement.getValue();
                            System.out.println();
                            if(valueInCurrentElement == onlyValue) {
                                errorCount++;
                            }
                        }

                        //block
                        int r = row - row % 3;
                        int c = column - column % 3;

                        for (int i = r; i < r + 3; i++) {
                            for (int j = c; j < c + 3; j++) {
                                int valueInCurrentField = sudokuBoard.getRows().get(i).getElements().get(j).getValue();
                                if(onlyValue == valueInCurrentField) {
                                    errorCount++;
                                }
                            }
                        }
                        System.out.println("Error at column: " + column + " row: " + row + " value already present");

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

                SudokuBoard clonedBoard = null;


                try {
                    clonedBoard = sudokuBoard.deepCopy();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

                Backtrack backtrackEntry = new Backtrack(clonedBoard, column, row, guessedValue);

                if(!entryBoardSaved) {
                    SudokuBoard boardForHistory = null;
                    try {
                        boardForHistory = sudokuBoard.deepCopy();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Putting into history:");
                    guessedValue = -1;
                    Backtrack backtrackEntryHistory = new Backtrack(boardForHistory, column, row, guessedValue);
                    this.backtrackHistory = backtrackEntryHistory;
                    entryBoardSaved = true;
                }


                backtrack.add(backtrackEntry);
                sudokuElement.setValue(guessedValue);

                System.out.println("Guessing value");
                System.out.println(sudokuBoard.toString());
                System.out.println("History");
                System.out.println(backtrackHistory.getSudokuBoard().toString());
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
        }

    }

    public boolean isSudokuSolved() {
        boolean sudokuResolved;

        List<SudokuElement> allElements = sudokuBoard.getRows().stream()
                .flatMap(row -> row.getElements().stream())
                .collect(Collectors.toList());

        sudokuResolved = allElements.stream()
                .noneMatch(element -> element.getValue() == -1);

        return sudokuResolved;
    }

    private boolean checkElementsInRow(SudokuElement sudokuElement, int row) {
        boolean anyActionTaken = false;

        boolean firstCheck = checkIfValueIsAssignedInRow(sudokuElement, row);
        boolean secondCheck = checkIfValueIsAllowedInRow(sudokuElement, row);

        if(firstCheck || secondCheck) {
            anyActionTaken = true;
        }

        return anyActionTaken;
    }

    private boolean checkIfValueIsAssignedInRow(SudokuElement sudokuElement, int row){
        boolean anyActionTaken = false;

        SudokuRow sudokuRow = sudokuBoard.getRows().get(row);

        List<Integer> availableValues = sudokuElement.getAvailableValues();

        //check for error?


        for (int i = 0; i < availableValues.size(); i++) {
            for (int j = 0; j < 9; j++) {
                int valueInCurrentField = sudokuRow.getElements().get(j).getValue();
                if (availableValues.get(i) == valueInCurrentField) {
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
                int valueInCurrentField = sudokuBoard.getRows().get(row).getElements().get(column).getValue();
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
                    int valueInCurrentField = sudokuBoard.getRows().get(i).getElements().get(j).getValue();
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