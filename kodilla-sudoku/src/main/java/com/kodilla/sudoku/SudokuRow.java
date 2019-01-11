package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> elements = new ArrayList<>();

    public SudokuRow() {

    }

    public List<SudokuElement> getElements() {
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
