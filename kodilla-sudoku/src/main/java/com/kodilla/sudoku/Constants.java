package com.kodilla.sudoku;

public interface Constants {
    int SIZE_OF_BOARD = 9;
    int COUNT_OF_BLOCKS = 3;

    String INSTRUCTIONS =
            "Provide column, row number and value \n" +
            "for example 215 - column 2, row 1, value 5 \n" +
            "Type SUDOKU to resolve the board.\n";

    String sudokuResolved =
            "\n====================================\n" +
                    "     Sudoku resolved!!!    \n" +
                    "====================================\n\n";

}
