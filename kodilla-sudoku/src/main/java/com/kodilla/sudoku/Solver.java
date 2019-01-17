package com.kodilla.sudoku;

import com.kodilla.sudoku.exceptions.Backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solver {
//    private SudokuBoard sudokuBoard;
//    private ArrayDeque<Backtrack> backtrack = new ArrayDeque<>();
//    private Random random = new Random();
//    private int backtrackStepsCount = 0;
//
//    public Solver(SudokuBoard sudokuBoard) {
//        this.sudokuBoard = sudokuBoard;
//    }
//
//    public boolean checkBoard() {
//        boolean wereUpdatesDone = false;
//
////        if (checkRows() || checkColumns() || checkBlocks()) {
////            wereUpdatesDone = true;
////        }
//
//        return wereUpdatesDone;
//    }
//
//    public void checkBlocks() {
//        for (int rowSection = 0; rowSection < 3; rowSection++) {
//            for (int columnSection = 0; columnSection < 3; columnSection++) {
//                checkBlock(columnSection * 3, rowSection * 3);
//            }
//        }
//    }
//
//    public void checkColumns() {
//        for (int i = 0; i < 9; i++) {
//            checkColumn(i);
//        }
//    }
//
//    public boolean checkRows() {
//        int countOfUpdates = 0;
//
//        for (int i = 0; i < 9; i++) {
//            if (checkRow(i)) {
//                countOfUpdates++;
//            }
//        }
//
//        return countOfUpdates > 0;
//    }
//
//    public void checkBlock(int column, int row) {
//        List<SudokuElement> elementsInBlock = getElementsInBlock(column, row);
//
//        for (int i = 0; i < 9; i++) {
//            int currentValue = elementsInBlock.get(i).getValue();
//            if(currentValue != -1) {
//                elementsInBlock.forEach(element ->
//                        element.getAvailableValues().remove(Integer.valueOf(currentValue)));
//            }
//        }
//
//        for (SudokuElement element : elementsInBlock) {
//            if (element.getAvailableValues().size() == 1) {
//                int lastAvailableValue = element.getAvailableValues().get(0);
//                element.setValue(lastAvailableValue);
//            }
//        }
//    }
//
//    public void checkColumn(int column) {
//        List<SudokuElement> elementsInColumn = getElementsInColumn(column);
//
//        for (int i = 0; i < 9; i++) {
//            int currentValue = elementsInColumn.get(i).getValue();
//            if(currentValue != -1) {
//                elementsInColumn.forEach(element ->
//                        element.getAvailableValues().remove(Integer.valueOf(currentValue)));
//            }
//        }
//
//        for (SudokuElement element : elementsInColumn) {
//            if (element.getAvailableValues().size() == 1) {
//                int lastAvailableValue = element.getAvailableValues().get(0);
//                element.setValue(lastAvailableValue);
//            }
//        }
//    }
//
//    public boolean checkRow(int row) {
//        boolean isAnyActionTaken = false;
//        List<SudokuElement> elementsInRow = getElementsInRow(row);
//
//        for (int i = 0; i < 9; i++) {
//            int currentValue = elementsInRow.get(i).getValue();
//            if(currentValue != -1) {
//                for (SudokuElement element : elementsInRow) {
//                    if (element.getAvailableValues().contains(Integer.valueOf(currentValue))) {
//                        element.getAvailableValues().remove(Integer.valueOf(currentValue));
//                        isAnyActionTaken = true;
//                    }
//                }
//            }
//        }
//
//        if(isAnyActionTaken) checkElementsForLastAvailableValue(elementsInRow);
//
//        return isAnyActionTaken;
//    }
//
//    public void checkElementsForLastAvailableValue(List<SudokuElement> elements) {
//        for (SudokuElement element : elements) {
//            checkForLastAvailableValue(element);
//        }
//    }
//
//    public void checkForLastAvailableValue(SudokuElement element) {
//        if (element.getAvailableValues().size() == 1) {
//            int lastAvailableValue = element.getAvailableValues().get(0);
//            element.setValue(lastAvailableValue);
//        }
//    }
//
//    public void checkAllElements() {
//        List<SudokuElement> elements = sudokuBoard.getAllElementsOnBoard();
//    }
//
//
//    public SudokuBoard getSudokuBoard() {
//        return sudokuBoard;
//    }
//
//    public void setSudokuBoard(SudokuBoard sudokuBoard) {
//        this.sudokuBoard = sudokuBoard;
//    }
}
