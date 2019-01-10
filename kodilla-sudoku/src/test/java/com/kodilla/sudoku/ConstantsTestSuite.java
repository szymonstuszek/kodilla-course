package com.kodilla.sudoku;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ConstantsTestSuite {

    @Test
    public void testCreateValuesForEmptyFieldList() {
        //Given
        ArrayList<Integer> values = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            values.add(i+1);
        }

        //When
        ArrayList<Integer> listFromMethod = Constants.valuesForEmptyFieldList();

        //Then
        Assert.assertEquals(values, listFromMethod);
    }

    @Test
    public void testCreateElementRow() {
        //Given
        ArrayList<SudokuElement> elementRow = new ArrayList<>();

        //When
        elementRow = Constants.createElementRow();

        //Then
        Assert.assertEquals(9, elementRow.size());
    }

    @Test
    public void testCreateBoard() {
        //Given
        ArrayList<SudokuRow> board = new ArrayList<>();

        //When
        board = Constants.createBoard();

        //Then
        Assert.assertEquals(9, board.size());
    }
}
