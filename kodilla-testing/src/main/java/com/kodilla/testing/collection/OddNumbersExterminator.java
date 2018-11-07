package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    public OddNumbersExterminator() {
    }

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {

        if(numbers.size() == 0) {
            System.out.println("List is empty");
        }

        ArrayList<Integer> listWithoutOddNumbers = new ArrayList<>();

        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) % 2 == 0) {
                listWithoutOddNumbers.add(numbers.get(i));
            }
        }

        return listWithoutOddNumbers;
    }
}
