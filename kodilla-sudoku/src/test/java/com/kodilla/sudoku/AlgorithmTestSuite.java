package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AlgorithmTestSuite {

    @Test
    public void testRemoveValuesFromList() {
        //Given
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //When
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Removing: " + i);
            list.remove(i);
            System.out.println("List size: " + list.size());
        }

        System.out.println(list.size());
        //Then
    }

    @Test
    public void testGuessValue() {
        //Given
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //When


        //Then
        for (int i = 0; i < 1000; i++) {
            int guessedValue = r.nextInt(list.size());
            System.out.println(list.get(guessedValue));
        }
    }

    //setup for test situation:
    //correct row: 123456789
    //given situation:123__678_
    //setting 9 in last column below, so 9 is no longer available for the last field
    //setting 4: 1234_5678_
    //algoritm should fill out the row now
    @Test
    public void testCheckIfValueIsAllowedInRow() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initializeBoard();
        Algorithm algorithm = new Algorithm(sudokuBoard);

        sudokuBoard.getBoard().get(0).getElements().get(0).setValue(1);
        sudokuBoard.getBoard().get(0).getElements().get(1).setValue(2);
        sudokuBoard.getBoard().get(0).getElements().get(2).setValue(3);
        sudokuBoard.getBoard().get(0).getElements().get(5).setValue(6);
        sudokuBoard.getBoard().get(0).getElements().get(6).setValue(7);
        sudokuBoard.getBoard().get(0).getElements().get(7).setValue(8);

        System.out.println("Entry point:");
        System.out.println(sudokuBoard.toString());

        //When
        sudokuBoard.getBoard().get(8).getElements().get(8).setValue(9);
        algorithm.updateSudokuBoard();
        System.out.println(sudokuBoard.toString());
        System.out.println("Available values for field 9,1");
        System.out.println(sudokuBoard.getBoard().get(0).getElements().get(8).getAvailableValues());

        sudokuBoard.getBoard().get(0).getElements().get(3).setValue(4);
        algorithm.updateSudokuBoard();
        System.out.println(sudokuBoard.toString());
        System.out.println(sudokuBoard.getBoard().get(0).getElements().get(4).getAvailableValues());
        algorithm.updateSudokuBoard();
        System.out.println(sudokuBoard.toString());

        //Then
    }

    @Test
    public void checkWinningCondition() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initializeBoard();
        Algorithm algorithm = new Algorithm(sudokuBoard);

        //first row
        sudokuBoard.getBoard().get(0).getElements().get(0).setValue(1);
        sudokuBoard.getBoard().get(0).getElements().get(1).setValue(2);
        sudokuBoard.getBoard().get(0).getElements().get(2).setValue(3);
        sudokuBoard.getBoard().get(0).getElements().get(3).setValue(4);
        sudokuBoard.getBoard().get(0).getElements().get(4).setValue(5);
        sudokuBoard.getBoard().get(0).getElements().get(5).setValue(6);
        sudokuBoard.getBoard().get(0).getElements().get(6).setValue(7);
        sudokuBoard.getBoard().get(0).getElements().get(7).setValue(8);
        sudokuBoard.getBoard().get(0).getElements().get(8).setValue(9);

        //second row
        sudokuBoard.getBoard().get(1).getElements().get(0).setValue(4);
        sudokuBoard.getBoard().get(1).getElements().get(1).setValue(5);
        sudokuBoard.getBoard().get(1).getElements().get(2).setValue(6);
        sudokuBoard.getBoard().get(1).getElements().get(3).setValue(7);
        sudokuBoard.getBoard().get(1).getElements().get(4).setValue(8);
        sudokuBoard.getBoard().get(1).getElements().get(5).setValue(9);
        sudokuBoard.getBoard().get(1).getElements().get(6).setValue(1);
        sudokuBoard.getBoard().get(1).getElements().get(7).setValue(2);
        sudokuBoard.getBoard().get(1).getElements().get(8).setValue(3);

        //third row
        sudokuBoard.getBoard().get(2).getElements().get(0).setValue(7);
        sudokuBoard.getBoard().get(2).getElements().get(1).setValue(8);
        sudokuBoard.getBoard().get(2).getElements().get(2).setValue(9);
        sudokuBoard.getBoard().get(2).getElements().get(3).setValue(1);
        sudokuBoard.getBoard().get(2).getElements().get(4).setValue(2);
        sudokuBoard.getBoard().get(2).getElements().get(5).setValue(3);
        sudokuBoard.getBoard().get(2).getElements().get(6).setValue(4);
        sudokuBoard.getBoard().get(2).getElements().get(7).setValue(5);
        sudokuBoard.getBoard().get(2).getElements().get(8).setValue(6);

        //fourth row
        sudokuBoard.getBoard().get(3).getElements().get(0).setValue(2);
        sudokuBoard.getBoard().get(3).getElements().get(1).setValue(3);
        sudokuBoard.getBoard().get(3).getElements().get(2).setValue(4);
        sudokuBoard.getBoard().get(3).getElements().get(3).setValue(5);
        sudokuBoard.getBoard().get(3).getElements().get(4).setValue(6);
        sudokuBoard.getBoard().get(3).getElements().get(5).setValue(7);
        sudokuBoard.getBoard().get(3).getElements().get(6).setValue(8);
        sudokuBoard.getBoard().get(3).getElements().get(7).setValue(9);
        sudokuBoard.getBoard().get(3).getElements().get(8).setValue(1);

        //fifth row
        sudokuBoard.getBoard().get(4).getElements().get(0).setValue(5);
        sudokuBoard.getBoard().get(4).getElements().get(1).setValue(6);
        sudokuBoard.getBoard().get(4).getElements().get(2).setValue(7);
        sudokuBoard.getBoard().get(4).getElements().get(3).setValue(8);
        sudokuBoard.getBoard().get(4).getElements().get(4).setValue(9);
        sudokuBoard.getBoard().get(4).getElements().get(5).setValue(1);
        sudokuBoard.getBoard().get(4).getElements().get(6).setValue(2);
        sudokuBoard.getBoard().get(4).getElements().get(7).setValue(3);
        sudokuBoard.getBoard().get(4).getElements().get(8).setValue(4);

        //sixth row
        sudokuBoard.getBoard().get(5).getElements().get(0).setValue(8);
        sudokuBoard.getBoard().get(5).getElements().get(1).setValue(9);
        sudokuBoard.getBoard().get(5).getElements().get(2).setValue(1);
        sudokuBoard.getBoard().get(5).getElements().get(3).setValue(2);
        sudokuBoard.getBoard().get(5).getElements().get(4).setValue(3);
        sudokuBoard.getBoard().get(5).getElements().get(5).setValue(4);
        sudokuBoard.getBoard().get(5).getElements().get(6).setValue(5);
        sudokuBoard.getBoard().get(5).getElements().get(7).setValue(6);
        sudokuBoard.getBoard().get(5).getElements().get(8).setValue(7);

        //seventh row
        sudokuBoard.getBoard().get(6).getElements().get(0).setValue(3);
        sudokuBoard.getBoard().get(6).getElements().get(1).setValue(4);
        sudokuBoard.getBoard().get(6).getElements().get(2).setValue(5);
        sudokuBoard.getBoard().get(6).getElements().get(3).setValue(6);
        sudokuBoard.getBoard().get(6).getElements().get(4).setValue(7);
        sudokuBoard.getBoard().get(6).getElements().get(5).setValue(8);
        sudokuBoard.getBoard().get(6).getElements().get(6).setValue(9);
        sudokuBoard.getBoard().get(6).getElements().get(7).setValue(1);
        sudokuBoard.getBoard().get(6).getElements().get(8).setValue(2);

        //eighth row
        sudokuBoard.getBoard().get(7).getElements().get(0).setValue(6);
        sudokuBoard.getBoard().get(7).getElements().get(1).setValue(7);
        sudokuBoard.getBoard().get(7).getElements().get(2).setValue(8);
        sudokuBoard.getBoard().get(7).getElements().get(3).setValue(9);
        sudokuBoard.getBoard().get(7).getElements().get(4).setValue(1);
        sudokuBoard.getBoard().get(7).getElements().get(5).setValue(2);
        sudokuBoard.getBoard().get(7).getElements().get(6).setValue(3);
        sudokuBoard.getBoard().get(7).getElements().get(7).setValue(4);
        sudokuBoard.getBoard().get(7).getElements().get(8).setValue(5);

        //ninth row
        sudokuBoard.getBoard().get(8).getElements().get(0).setValue(9);
        sudokuBoard.getBoard().get(8).getElements().get(1).setValue(1);
        sudokuBoard.getBoard().get(8).getElements().get(2).setValue(2);
        sudokuBoard.getBoard().get(8).getElements().get(3).setValue(3);
        sudokuBoard.getBoard().get(8).getElements().get(4).setValue(4);
        sudokuBoard.getBoard().get(8).getElements().get(5).setValue(5);
        sudokuBoard.getBoard().get(8).getElements().get(6).setValue(6);
        sudokuBoard.getBoard().get(8).getElements().get(7).setValue(7);
        sudokuBoard.getBoard().get(8).getElements().get(8).setValue(8);

        System.out.println(sudokuBoard.toString());

    }

    //write streams
    @Test
    public void testCheckIfValidSudokuSolution() {
        //Given
        //When
        //Then
    }

    @Test
    public void testIsSudokuResolved() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initializeBoard();
        Algorithm algorithm = new Algorithm(sudokuBoard);

        //When
        boolean resolved = algorithm.isSudokuSolved();

        //Then
        Assert.assertEquals(false, resolved);
    }

    @Test
    public void testIfBoardWithOneEmptyElementIsResolved() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initializeBoard();
        Algorithm algorithm = new Algorithm(sudokuBoard);

        //When
        List<SudokuElement> allElements = sudokuBoard.getBoard().stream()
                .flatMap(row -> row.getElements().stream())
                .collect(Collectors.toList());

        allElements.stream()
                .forEach(sudokuElement -> sudokuElement.setValue(5));

        allElements.get(0).setValue(-1);

        boolean resolved = algorithm.isSudokuSolved();

        //Then
        System.out.println(sudokuBoard);
        Assert.assertEquals(false, resolved);
    }

    @Test
    public void testIfFilledBoardIsResolved() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initializeBoard();
        Algorithm algorithm = new Algorithm(sudokuBoard);

        //When
        List<SudokuElement> allElements = sudokuBoard.getBoard().stream()
                .flatMap(row -> row.getElements().stream())
                .collect(Collectors.toList());

        allElements.stream()
                .forEach(sudokuElement -> sudokuElement.setValue(5));

        boolean resolved = algorithm.isSudokuSolved();

        //Then
        System.out.println(sudokuBoard);
        Assert.assertEquals(true, resolved);
    }

}
