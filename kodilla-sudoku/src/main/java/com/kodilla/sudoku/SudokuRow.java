package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuRow {
    private ArrayList<SudokuElement> elementRow;

    public SudokuRow() {
        this.elementRow = Constants.createElementRow();
    }

    public ArrayList<SudokuElement> getElementRow() {
        return elementRow;
    }

    @Override
    public String toString() {
        String row = "";
        for (int i = 0; i < elementRow.size(); i++) {
            row += elementRow.get(i).toString();
        }

        return row + "|";
    }
}
