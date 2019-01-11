package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype {
    private ArrayList<SudokuRow> board;

    public SudokuBoard() {
        this.board = Constants.createBoard();
    }

    public ArrayList<SudokuRow> getBoard() {
        return board;
    }

    public SudokuElement getElementUnderGivenIndexes(int column, int row) {
        SudokuRow chosenRow = board.get(row);
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
//            chosenElement.emptyAvailableValues();
        }
    }

    public List<Integer> getValuesAlreadyAssignedInRow(int row) {
        List<Integer> valuesAlreadyAssignedInRow = new ArrayList<>();
        SudokuRow sudokuRow = board.get(row);
        for (int i = 0; i < 9; i++) {
            int valueInCurrentField = sudokuRow.getElements().get(i).getValue();
            if(valueInCurrentField != -1 &&
                    !valuesAlreadyAssignedInRow.contains(Integer.valueOf(valueInCurrentField))) {
                valuesAlreadyAssignedInRow.add(valueInCurrentField);
            }
        }
        System.out.println("Number of values in row: " + valuesAlreadyAssignedInRow.size());
        return valuesAlreadyAssignedInRow;
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
        clonedBoard.board = new ArrayList<>();

        for (SudokuRow row : board) {
            SudokuRow clonedRow = new SudokuRow();
            for (SudokuElement element : row.getElements()) {
                clonedRow.getElements().add(element);

            }
            clonedBoard.getBoard().add(clonedRow);
        }

        return clonedBoard;
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
