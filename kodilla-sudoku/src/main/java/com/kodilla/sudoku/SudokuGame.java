package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {
   private Scanner scanner;
   private SudokuBoard sudokuBoard;
   private UserInput userInput;
   private Algorithm algorithm;

   private boolean sudokuResolved = false;

    public SudokuGame() {
        this.scanner =  new Scanner(System.in);
        this.sudokuBoard = new SudokuBoard();
        this.userInput = new UserInput(scanner);
        this.algorithm = new Algorithm(sudokuBoard);

        runGame();
    }

    private void runGame() {
        while(!sudokuResolved) {
            System.out.println(sudokuBoard.toString());
            System.out.println(Constants.INSTRUCTIONS);

            String input = scanner.nextLine();

            if (userInput.isInputValid(input)) {
                int action = userInput.chooseAction(input);

                switch (action) {
                    case 0:
                        sudokuResolved = true;
                        break;
                    case 1:
                        int column = userInput.getColumnIndex(input);
                        int row = userInput.getRowIndex(input);
                        int value = userInput.getValue(input);

                        sudokuBoard.setValueOnBoard(column, row, value);
                        algorithm.checkSudokuBoard();
                        break;
                    case 2:
                        column = userInput.getColumnIndex(input);
                        row = userInput.getRowIndex(input);

                        sudokuBoard.checkAvailableValues(column, row);
                        break;
                    default:
                        System.out.println("No such action");
                        break;
                }
            }
        }
        System.out.println("Finished game - left loop");
    }

    //check if still playing
    //put into user input?
    public boolean finishGame() {
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
