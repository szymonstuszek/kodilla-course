package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {
   private Scanner scanner =  new Scanner(System.in);
   private SudokuBoard sudokuBoard = new SudokuBoard();
   private UserInput userInput = new UserInput(scanner);
   private SudokuSolver solver = new SudokuSolver(sudokuBoard);

   private boolean sudokuResolved = false;

    public SudokuGame() {

    }

    public void runGame() {

        while(!sudokuResolved) {
            System.out.println(sudokuBoard.toString());
            System.out.println(Constants.INSTRUCTIONS);

            String input = scanner.nextLine();

            if (userInput.isInputValid(input)) {
                int action = userInput.chooseAction(input);

                switch (action) {
                    case 0:
                        solver.solve();
                        sudokuResolved = true;
                        break;

                    case 1:
                        int column = userInput.getColumnIndex(input);
                        int row = userInput.getRowIndex(input);
                        int value = userInput.getValue(input);

                        sudokuBoard.setValueOnBoard(column, row, value);
                        solver.checkIfBoardIsValid();
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

        System.out.println(Constants.sudokuResolved);
    }

    public boolean finishGame() {
        System.out.println("Do you still want to play?");
        System.out.println("Type 'no' to quit");
        String response = scanner.nextLine();
        System.out.println("You have chosen: " + response);

        return response.equals("no");
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }
}
