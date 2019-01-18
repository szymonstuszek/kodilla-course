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

        sudokuBoard = exampleBoards.createBoardForErrorChecks();

        while (!isBoardSolved && isThereASolution) {
            boolean isBoardValid = checker.checkIfBoardIsValid();
            System.out.println("Before guessing: " + sudokuBoard.toString());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(isBoardValid) {
                guessValue();
                System.out.println("Guessing: " + sudokuBoard.toString());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            } else {

                if(backtrack.size() > 0) {
                    goBack();
                    System.out.println("Going back: " + sudokuBoard.toString());

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                } else {
                    isThereASolution = false;
                    System.out.println("No solution");
                }
            }

            isBoardSolved = sudokuBoard.isBoardSolved();
        }
    }

    public void guessValue() {
        boolean canSetValueInElement = false;
        List<Integer> availableValues;
        SudokuElement element = null;

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

                sudokuBoard.setValueOnBoard(column, row, guessedValue);

                Backtrack backtrackEntry = new Backtrack(sudokuBoard, column, row, guessedValue);
                backtrack.add(backtrackEntry);
            }
        }
    }

    public void goBack() {
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