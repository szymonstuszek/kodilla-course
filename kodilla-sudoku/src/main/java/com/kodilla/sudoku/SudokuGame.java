package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean gameFinished = false;

        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.resolveSudoku();
        }
    }

    private boolean resolveSudoku() {
        System.out.println("Do you still want to play?");
        System.out.println("Type 'no' to quit");
        String response = scanner.nextLine();
        System.out.println("You have chosen: " + response);

        if(response.equals("no")) {
            return true;
        } else {
            return false;
        }
    }
}
