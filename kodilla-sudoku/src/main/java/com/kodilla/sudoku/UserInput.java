package com.kodilla.sudoku;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    //to implement
    public boolean isInputValid(String input) {
        return true;
    }

    //how to fix return statement?
    public int chooseAction(String input) {
        if (input.equals("SUDOKU")) {
            return 0;
        }

        if(input.length() == 3) {
            return 1;
        }

        if(input.length() == 2) {
            return 2;
        }
        return 9;
    }

    public int getRowIndex(String input) {
        String rowIndex = input.substring(1, 2);
        System.out.println("Row index: " + rowIndex);
        return Integer.valueOf(rowIndex) - 1;
    }

    public int getColumnIndex(String input) {
        String columnIndex = input.substring(0, 1);
        System.out.println("Column index: " + columnIndex);
        return Integer.valueOf(columnIndex) - 1;
    }

    public int getValue(String input) {
        String value = input.substring(2, 3);
        System.out.println("Value: " + value);
        return Integer.valueOf(value);
    }

}
