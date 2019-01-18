package com.kodilla.sudoku;

import com.kodilla.sudoku.SudokuBoard;

public class Backtrack {
    private SudokuBoard sudokuBoard;
    private int column;
    private int row;
    private int value;

    public Backtrack(SudokuBoard sudokuBoard, int column, int row, int value) {
        this.sudokuBoard = sudokuBoard;
        this.column = column;
        this.row = row;
        this.value = value;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Backtrack \n" +
                sudokuBoard + "\n" +
                value + " set at column: " + column + " row: " + row;

    }
}
