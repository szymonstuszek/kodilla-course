package com.kodilla.sudoku;

import java.util.Collections;
import java.util.List;

public class SudokuElement {
    private int value;
    private List<Integer> availableValues;

    public SudokuElement() {
        this.value = Constants.EMPTY_FIELD;
        this.availableValues = Constants.valuesForEmptyFieldList();
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getAvailableValues() {
        return availableValues;
    }

    public void removeValueFromAvailableValues(int i) {
        availableValues.remove(Integer.valueOf(i));
    }

    public void markValueForRemoval(int valueToRemoveFromList) {
        if (availableValues.contains(Integer.valueOf(valueToRemoveFromList))) {
            int indexOfValueToRemove = availableValues.indexOf(Integer.valueOf(valueToRemoveFromList));
            availableValues.set(indexOfValueToRemove, 0);
        }
    }

    public void removeMarkedValues() {
        availableValues.removeAll(Collections.singleton(0));
    }

    public void emptyAvailableValues() {
        availableValues.clear();
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String fieldCharacter = " ";

        if(value != -1) {
            fieldCharacter = String.valueOf(value);
        }

        return "|" + fieldCharacter;
    }
}
