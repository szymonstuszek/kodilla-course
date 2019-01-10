package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private ArrayList<SudokuRow> board;

    public SudokuBoard() {
        this.board = Constants.createBoard();
    }

    public ArrayList<SudokuRow> getBoard() {
        return board;
    }

    public SudokuElement getElementUnderGivenIndexes(int column, int row) {
        SudokuRow chosenRow = board.get(row);
        SudokuElement chosenElement = chosenRow.getElementRow().get(column);
        return chosenElement;
    }

    private boolean isFieldEmpty(int column, int row) {
        SudokuElement chosenElement = getElementUnderGivenIndexes(column, row);

        if(chosenElement.getValue() == -1) {
            return true;
        } else {
            System.out.println("There is already a value in this field!");
            return false;
        }
    }

    public void setValueOnBoard(int column, int row, int value) {
        if(isFieldEmpty(column, row)) {
            SudokuElement chosenElement = getElementUnderGivenIndexes(column, row);
            chosenElement.setValue(value);
        }
    }

    public void checkAvailableValues(int column, int row) {
        SudokuRow chosenRow = board.get(row);
        SudokuElement chosenElement = chosenRow.getElementRow().get(column);
        List<Integer> values = chosenElement.getAvailableValues();

        System.out.println("Available values are:");
        values.forEach(System.out::print);
        System.out.println();
    }

    @Override
    public String toString() {
        String boardString = "";

        for (int i = 0; i < board.size(); i++) {
            if(i == 8) {
                boardString += board.get(i).toString();
            } else {
                boardString += board.get(i).toString() + "\n";
            }

        }
        return "-------------------\n" +
                boardString + "\n" +
                "-------------------";
    }
}
