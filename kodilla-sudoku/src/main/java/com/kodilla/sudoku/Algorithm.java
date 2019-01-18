package com.kodilla.sudoku;

import com.kodilla.sudoku.board_examples.ExampleBoards;
import com.kodilla.sudoku.exceptions.Backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Algorithm {
    private Random random = new Random();
    private ExampleBoards exampleBoards = new ExampleBoards();
    private SudokuBoard sudokuBoard;
    private Checker checker;
    private ArrayDeque<Backtrack> backtrack = new ArrayDeque<>();
    private List<Backtrack> backtrackHistory = new ArrayList<>();
    private int backtrackStepsCount = 0;
    private int totalSteps = 0;

    private SudokuBoard entryBoard;
    private boolean entryBoardSaved = false;

    public Algorithm(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        this.checker = new Checker(sudokuBoard);
    }

    public boolean checkIfBoardIsValid() {
        boolean isValid = checker.checkIfBoardIsValid();
        return isValid;
    }

    public void solve() {
        boolean isThereASolution = true;
        boolean isBoardSolved = false;

        while (!isBoardSolved && isThereASolution) {
            boolean isBoardValid = checker.checkIfBoardIsValid();

            if(isBoardValid) {
                guessValue();
            } else {

                if(backtrack.size() > 0 && totalSteps < 1000) {
                    goBack();

                } else {
                    isThereASolution = false;
                    System.out.println("No solution");
                }
            }
            isBoardSolved = sudokuBoard.isBoardSolved();
        }
        System.out.println(sudokuBoard.toString());
        System.out.println("Finished in: " + totalSteps + " steps");
    }


    public void guessValue() {
        boolean canSetValueInElement = false;
        List<Integer> availableValues;
        SudokuElement element = null;
        totalSteps++;

        int column = -1, row = -1, guessedValueIndex, guessedValue, countOfAvailableValues;

        if(sudokuBoard.isAnyElementEmpty()) {
            while (!canSetValueInElement) {
                column = random.nextInt(Constants.SIZE_OF_BOARD);
                row = random.nextInt(Constants.SIZE_OF_BOARD);

                element = sudokuBoard.getElementUnderGivenIndexes(column, row);
                canSetValueInElement = element.isEmpty();
            }

            availableValues = element.getAvailableValues();

            if (availableValues.size() > 0) {
                countOfAvailableValues = availableValues.size();
                guessedValueIndex = random.nextInt(countOfAvailableValues);
                guessedValue = availableValues.get(guessedValueIndex);

                SudokuBoard clonedBoard = null;
                try {
                    clonedBoard = sudokuBoard.deepCopy();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }


                if (!entryBoardSaved) {
                    SudokuBoard clonedEntryBoard = null;
                    try {
                        clonedEntryBoard = sudokuBoard.deepCopy();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }

                    entryBoard = clonedEntryBoard;
                    entryBoardSaved = true;
                }


                sudokuBoard.setValueOnBoard(column, row, guessedValue);

                Backtrack backtrackEntry = new Backtrack(clonedBoard, column, row, guessedValue);
                backtrack.add(backtrackEntry);
            }
        }
    }

    public void goBack() {
        backtrackStepsCount++;

        if (backtrack.size() > 0) {
            Backtrack lastBacktrack = backtrack.pollLast();
            SudokuBoard lastBoard = lastBacktrack.getSudokuBoard();
            int column = lastBacktrack.getColumn();
            int row = lastBacktrack.getRow();
            int lastGuessedValue = lastBacktrack.getValue();

            setSudokuBoard(lastBoard);
            checker.setSudokuBoard(lastBoard);

            SudokuElement currentElement = sudokuBoard.getElementUnderGivenIndexes(column, row);
            currentElement.setValue(-1);
            currentElement.removeValueFromAvailableValues(lastGuessedValue);
        }



        if (backtrackStepsCount > 10) {
            System.out.println("!!!!!!!!!Starting over!!!!!!!!");

            SudokuBoard restartBoard = null;
            try {
                restartBoard = backtrack.getFirst().getSudokuBoard().deepCopy();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }


            setSudokuBoard(restartBoard);
            checker.setSudokuBoard(restartBoard);

            backtrackStepsCount = 0;
        }
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public ArrayDeque<Backtrack> getBacktrack() {
        return backtrack;
    }

    public void setBacktrack(ArrayDeque<Backtrack> backtrack) {
        this.backtrack = backtrack;
    }

    public List<Backtrack> getBacktrackHistory() {
        return backtrackHistory;
    }

    public void setBacktrackHistory(List<Backtrack> backtrackHistory) {
        this.backtrackHistory = backtrackHistory;
    }
}