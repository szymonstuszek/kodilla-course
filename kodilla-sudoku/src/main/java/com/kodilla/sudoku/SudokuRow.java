package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuRow {
    private ArrayList<SudokuElement> elements;

    public SudokuRow() {
        this.elements = Constants.createElementRow();
    }

    public ArrayList<SudokuElement> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        String row = "";
        for (int i = 0; i < elements.size(); i++) {
            row += elements.get(i).toString();
        }

        return row + "|";
    }
}
