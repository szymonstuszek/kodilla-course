package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {

        System.out.println("Test for addition");
        Calculator calculator = new Calculator();

        //Given
        int a = 20;
        int b = 5;
        int addResult = a + b;


        //When
        int calculatorAddition = calculator.add(a, b);


        //Then
        if(addResult == calculatorAddition) {
            System.out.println("Addition OK");
        } else {
            System.out.println("Error while adding!");
        }


        System.out.println("Test for subtraction");
        //Given
        int c = 20;
        int d = 5;
        int subtractResult = c - d;


        //When
        int calculatorSubtraction = calculator.substract(a, b);


        //Then
        if(subtractResult == calculatorSubtraction) {
            System.out.println("Subtraction OK");
        } else {
            System.out.println("Error while subtracting!");
        }
    }
}
