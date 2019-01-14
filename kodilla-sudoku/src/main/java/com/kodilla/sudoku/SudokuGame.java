package com.kodilla.sudoku;

import com.kodilla.sudoku.exceptions.Backtrack;

import java.util.ArrayList;
import java.util.List;
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
        sudokuBoard.initializeBoard();

        while(!sudokuResolved) {
            System.out.println(sudokuBoard.toString());
            System.out.println(Constants.INSTRUCTIONS);

            String input = scanner.nextLine();

            if (userInput.isInputValid(input)) {
                int action = userInput.chooseAction(input);

                switch (action) {
                    case 0:
                        sudokuResolved = false;

                        while (!sudokuResolved) {
                            sudokuResolved = algorithm.solve();
                        }
                        break;

                    case 1:
                        int column = userInput.getColumnIndex(input);
                        int row = userInput.getRowIndex(input);
                        int value = userInput.getValue(input);

//                        addIntoBacktrack(column, row, value);
                        sudokuBoard.setValueOnBoard(column, row, value);
                        algorithm.updateSudokuBoard();

                        sudokuResolved = algorithm.isSudokuSolved();
                        break;

                    case 2:
                        column = userInput.getColumnIndex(input);
                        row = userInput.getRowIndex(input);

                        sudokuBoard.checkAvailableValues(column, row);
                        break;

                    case 3:
//                        Backtrack backtrackEntry = backtrack.get(backtrack.size()-1);
//                        System.out.println(backtrackEntry);
                        break;

                        //test case how to write in tests?
                    case 4:
//                        SudokuBoard boardToSet = new SudokuBoard();
//                        boardToSet.initializeBoard();
//
//                        SudokuElement sudokuElement = boardToSet.getElementUnderGivenIndexes(0, 0);
//                        sudokuElement.setValue(9);

//                        System.out.println("Before");
//                        System.out.println("Board to insert");
//                        System.out.println(sudokuBoard.toString());
//                        System.out.println("Original board");
//                        System.out.println(algorithm.sudokuBoard.toString());
//
//                        algorithm.setSudokuBoard(boardToSet);
//
//                        System.out.println("After");
//                        System.out.println("Board to insert");
//                        System.out.println(sudokuBoard.toString());
//                        System.out.println("Original board");
//                        System.out.println(algorithm.sudokuBoard.toString());
                        break;

                    default:
                        System.out.println("No such action");
                        break;
                }
            }
        }

        System.out.println(sudokuBoard.toString());
        System.out.println(Constants.sudokuResolved);
    }

    private void addIntoBacktrack(int column, int row, int value) {
        SudokuBoard clonedBoard = null;

        try {
            clonedBoard = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Backtrack backtrackEntry = new Backtrack(clonedBoard, column, row, value);
//        backtrack.add(backtrackEntry);
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

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }
}
