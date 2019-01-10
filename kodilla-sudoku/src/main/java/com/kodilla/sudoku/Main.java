package com.kodilla.sudoku;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean gameFinished = false;

        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.finishGame();
        }
    }
}
