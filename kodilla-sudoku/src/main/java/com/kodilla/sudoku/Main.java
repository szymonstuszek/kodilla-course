package com.kodilla.sudoku;

public class Main {
    public static void main(String[] args) {
        boolean gameFinished = false;

        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.finishGame();
        }
    }
}
