package com.kodilla.sudoku;

import java.util.ArrayList;

public class Constants {
    public static final int EMPTY_FIELD = -1;
    public static final int NUMBER_OF_FIELDS_IN_ROW = 9;
    public static final int NUMBER_OF_ROWS = 9;
    public static final int NUMBER_OF_ELEMENTS_IN_BLOCK_ROW = 3;
    public static final int NUMBER_OF_ELEMENTS_IN_BLOCK_COLUMN = 3;

    public static final String INSTRUCTIONS =
            "Provide column, row number and value \n" +
            "for example 215 - column 2, row 1, value 5 \n" +
            "Type SUDOKU to resolve the board.\n";

    public static final String sudokuResolved =
            "\n====================================\n" +
                    "     Sudoku resolved!!!    \n" +
                    "====================================\n\n";

    public static ArrayList<Integer> valuesForEmptyFieldList() {
        ArrayList<Integer> values = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            values.add(i+1);
        }

        return values;
    }

    public static ArrayList<SudokuElement> createElementRow() {
        ArrayList<SudokuElement> elementRow = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            elementRow.add(new SudokuElement());
        }
        return elementRow;
    }

    public static ArrayList<SudokuRow> createBoard() {
        ArrayList<SudokuRow> board = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            board.add(new SudokuRow());
        }
        return board;
    }
}
