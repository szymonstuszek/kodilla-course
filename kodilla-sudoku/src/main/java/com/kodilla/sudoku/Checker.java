package com.kodilla.sudoku;

public class Checker {
    private SudokuBoard sudokuBoard;

    public Checker(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public boolean checkIfBoardIsValid() {
        updateBoard();

        return checkIfThereAreErrors();
    }

    public void updateBoard() {
        boolean anyActionTaken = false;
        int actionCount = 0;

        while(!anyActionTaken) {
            updateRows();
            updateColumns();
            updateBlock();
        }

    }

    public boolean checkIfThereAreErrors() {
        boolean anyErrors = false;
        int errorCount = 0;

        checkIfThereAreFieldsWithErrors();

        checkRowConstraints();
        checkColumnConstraints();
        checkBlockConstraints();

        return false;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }
}
