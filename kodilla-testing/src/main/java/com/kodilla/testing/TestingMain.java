package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if(result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - pierwszy test jednostkowy");


        Calculator calculator = new Calculator();
        int a = 20;
        int b = 5;
        int addResult = a + b;
        int subtractResult = a - b;

        int calculatorAddition = calculator.add(a, b);
        int calculatorSubtraction = calculator.substract(a, b);

        System.out.println("Test for addition");

        if(addResult == calculatorAddition) {
            System.out.println("Addition OK");
        } else {
            System.out.println("Error while adding!");
        }

        System.out.println("Test for subtraction");

        if(subtractResult == calculatorSubtraction) {
            System.out.println("Subtraction OK");
        } else {
            System.out.println("Error while subtracting!");
        }


    }
}
