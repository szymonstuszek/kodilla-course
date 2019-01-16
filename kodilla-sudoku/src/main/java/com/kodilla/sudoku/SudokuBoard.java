package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuBoard extends Prototype {
    private List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {

    }

    public void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            SudokuRow row = new SudokuRow();
            for (int j = 0; j < 9; j++) {
                row.getElements().add(new SudokuElement());
            }
            rows.add(row);
        }
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    public SudokuElement getElementUnderGivenIndexes(int column, int row) {
        SudokuRow chosenRow = rows.get(row);
        SudokuElement chosenElement = chosenRow.getElements().get(column);
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

    private boolean isValidValue(int column, int row, int value) {
        SudokuElement sudokuElement = getElementUnderGivenIndexes(column, row);
        if (sudokuElement.getAvailableValues().contains(value)) {
            return true;
        } else {
            System.out.println("This is not a valid value!");
            return false;
        }
    }

    public void setValueOnBoard(int column, int row, int value) {
        if(isFieldEmpty(column, row) &&
                isValidValue(column, row, value)) {
            SudokuElement chosenElement = getElementUnderGivenIndexes(column, row);
            chosenElement.setValue(value);
        }
    }

    public void checkAvailableValues(int column, int row) {
        SudokuElement chosenElement = getElementUnderGivenIndexes(column, row);
        List<Integer> values = chosenElement.getAvailableValues();

        System.out.println("Number of available values: " + values.size() +  " :");
        values.forEach(System.out::print);
        System.out.println();
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard) super.clone();
        clonedBoard.rows = new ArrayList<>();

        for (SudokuRow row : rows) {
            SudokuRow clonedRow = new SudokuRow();

            for (SudokuElement element : row.getElements()) {
                SudokuElement clonedElement = new SudokuElement();

                clonedElement.setValue(element.getValue());
//                clonedElement.setAvailableValues(element.getAvailableValues());
                clonedRow.getElements().add(clonedElement);
            }
            clonedBoard.getRows().add(clonedRow);
        }

        return clonedBoard;
    }

    public List<SudokuElement> getAllElementsOnBoard() {
        List<SudokuElement> allElementsOnBoard = rows.stream()
                .flatMap(sudokuRow -> sudokuRow.getElements().stream())
                .collect(Collectors.toList());

        return allElementsOnBoard;
    }

    @Override
    public String toString() {
        String boardString = "";

        for (int i = 0; i < rows.size(); i++) {
            if(i == 8) {
                boardString += rows.get(i).toString();
            } else {
                boardString += rows.get(i).toString() + "\n";
            }

        }
        return "-------------------\n" +
                boardString + "\n" +
                "-------------------";
    }
}
