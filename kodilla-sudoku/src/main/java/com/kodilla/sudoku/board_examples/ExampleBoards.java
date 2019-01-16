package com.kodilla.sudoku.board_examples;


import com.kodilla.sudoku.SudokuBoard;

public class ExampleBoards {

    public static SudokuBoard createFilledOutBoard() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initializeBoard();

        //first row
        sudokuBoard.getRows().get(0).getElements().get(0).setValue(1);
        sudokuBoard.getRows().get(0).getElements().get(1).setValue(2);
        sudokuBoard.getRows().get(0).getElements().get(2).setValue(3);
        sudokuBoard.getRows().get(0).getElements().get(3).setValue(4);
        sudokuBoard.getRows().get(0).getElements().get(4).setValue(5);
        sudokuBoard.getRows().get(0).getElements().get(5).setValue(6);
        sudokuBoard.getRows().get(0).getElements().get(6).setValue(7);
        sudokuBoard.getRows().get(0).getElements().get(7).setValue(8);
        sudokuBoard.getRows().get(0).getElements().get(8).setValue(9);

        //second row
        sudokuBoard.getRows().get(1).getElements().get(0).setValue(4);
        sudokuBoard.getRows().get(1).getElements().get(1).setValue(5);
        sudokuBoard.getRows().get(1).getElements().get(2).setValue(6);
        sudokuBoard.getRows().get(1).getElements().get(3).setValue(7);
        sudokuBoard.getRows().get(1).getElements().get(4).setValue(8);
        sudokuBoard.getRows().get(1).getElements().get(5).setValue(9);
        sudokuBoard.getRows().get(1).getElements().get(6).setValue(1);
        sudokuBoard.getRows().get(1).getElements().get(7).setValue(2);
        sudokuBoard.getRows().get(1).getElements().get(8).setValue(3);

        //third row
        sudokuBoard.getRows().get(2).getElements().get(0).setValue(7);
        sudokuBoard.getRows().get(2).getElements().get(1).setValue(8);
        sudokuBoard.getRows().get(2).getElements().get(2).setValue(9);
        sudokuBoard.getRows().get(2).getElements().get(3).setValue(1);
        sudokuBoard.getRows().get(2).getElements().get(4).setValue(2);
        sudokuBoard.getRows().get(2).getElements().get(5).setValue(3);
        sudokuBoard.getRows().get(2).getElements().get(6).setValue(4);
        sudokuBoard.getRows().get(2).getElements().get(7).setValue(5);
        sudokuBoard.getRows().get(2).getElements().get(8).setValue(6);

        //fourth row
        sudokuBoard.getRows().get(3).getElements().get(0).setValue(2);
        sudokuBoard.getRows().get(3).getElements().get(1).setValue(3);
        sudokuBoard.getRows().get(3).getElements().get(2).setValue(4);
        sudokuBoard.getRows().get(3).getElements().get(3).setValue(5);
        sudokuBoard.getRows().get(3).getElements().get(4).setValue(6);
        sudokuBoard.getRows().get(3).getElements().get(5).setValue(7);
        sudokuBoard.getRows().get(3).getElements().get(6).setValue(8);
        sudokuBoard.getRows().get(3).getElements().get(7).setValue(9);
        sudokuBoard.getRows().get(3).getElements().get(8).setValue(1);

        //fifth row
        sudokuBoard.getRows().get(4).getElements().get(0).setValue(5);
        sudokuBoard.getRows().get(4).getElements().get(1).setValue(6);
        sudokuBoard.getRows().get(4).getElements().get(2).setValue(7);
        sudokuBoard.getRows().get(4).getElements().get(3).setValue(8);
        sudokuBoard.getRows().get(4).getElements().get(4).setValue(9);
        sudokuBoard.getRows().get(4).getElements().get(5).setValue(1);
        sudokuBoard.getRows().get(4).getElements().get(6).setValue(2);
        sudokuBoard.getRows().get(4).getElements().get(7).setValue(3);
        sudokuBoard.getRows().get(4).getElements().get(8).setValue(4);

        //sixth row
        sudokuBoard.getRows().get(5).getElements().get(0).setValue(8);
        sudokuBoard.getRows().get(5).getElements().get(1).setValue(9);
        sudokuBoard.getRows().get(5).getElements().get(2).setValue(1);
        sudokuBoard.getRows().get(5).getElements().get(3).setValue(2);
        sudokuBoard.getRows().get(5).getElements().get(4).setValue(3);
        sudokuBoard.getRows().get(5).getElements().get(5).setValue(4);
        sudokuBoard.getRows().get(5).getElements().get(6).setValue(5);
        sudokuBoard.getRows().get(5).getElements().get(7).setValue(6);
        sudokuBoard.getRows().get(5).getElements().get(8).setValue(7);

        //seventh row
        sudokuBoard.getRows().get(6).getElements().get(0).setValue(3);
        sudokuBoard.getRows().get(6).getElements().get(1).setValue(4);
        sudokuBoard.getRows().get(6).getElements().get(2).setValue(5);
        sudokuBoard.getRows().get(6).getElements().get(3).setValue(6);
        sudokuBoard.getRows().get(6).getElements().get(4).setValue(7);
        sudokuBoard.getRows().get(6).getElements().get(5).setValue(8);
        sudokuBoard.getRows().get(6).getElements().get(6).setValue(9);
        sudokuBoard.getRows().get(6).getElements().get(7).setValue(1);
        sudokuBoard.getRows().get(6).getElements().get(8).setValue(2);

        //eighth row
        sudokuBoard.getRows().get(7).getElements().get(0).setValue(6);
        sudokuBoard.getRows().get(7).getElements().get(1).setValue(7);
        sudokuBoard.getRows().get(7).getElements().get(2).setValue(8);
        sudokuBoard.getRows().get(7).getElements().get(3).setValue(9);
        sudokuBoard.getRows().get(7).getElements().get(4).setValue(1);
        sudokuBoard.getRows().get(7).getElements().get(5).setValue(2);
        sudokuBoard.getRows().get(7).getElements().get(6).setValue(3);
        sudokuBoard.getRows().get(7).getElements().get(7).setValue(4);
        sudokuBoard.getRows().get(7).getElements().get(8).setValue(5);

        //ninth row
        sudokuBoard.getRows().get(8).getElements().get(0).setValue(9);
        sudokuBoard.getRows().get(8).getElements().get(1).setValue(1);
        sudokuBoard.getRows().get(8).getElements().get(2).setValue(2);
        sudokuBoard.getRows().get(8).getElements().get(3).setValue(3);
        sudokuBoard.getRows().get(8).getElements().get(4).setValue(4);
        sudokuBoard.getRows().get(8).getElements().get(5).setValue(5);
        sudokuBoard.getRows().get(8).getElements().get(6).setValue(6);
        sudokuBoard.getRows().get(8).getElements().get(7).setValue(7);
        sudokuBoard.getRows().get(8).getElements().get(8).setValue(8);



        return sudokuBoard;
    }

    public SudokuBoard createBoardForErrorChecks() {
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initializeBoard();

        sudokuBoard.getRows().get(0).getElements().get(0).setValue(1);
        sudokuBoard.getRows().get(0).getElements().get(1).setValue(2);
        sudokuBoard.getRows().get(0).getElements().get(2).setValue(3);
        sudokuBoard.getRows().get(0).getElements().get(3).setValue(4);
        sudokuBoard.getRows().get(0).getElements().get(4).setValue(5);
        sudokuBoard.getRows().get(0).getElements().get(5).setValue(6);
        sudokuBoard.getRows().get(0).getElements().get(6).setValue(7);
        sudokuBoard.getRows().get(0).getElements().get(7).setValue(8);
        sudokuBoard.getRows().get(0).getElements().get(8).setValue(9);

        sudokuBoard.getRows().get(1).getElements().get(0).setValue(4);
        sudokuBoard.getRows().get(1).getElements().get(1).setValue(5);
        sudokuBoard.getRows().get(1).getElements().get(2).setValue(6);

        return sudokuBoard;
    }
}
