package com.kodilla.rps;

import java.util.Random;

public class Computer {
    Random r = new Random();

    public String chooseMove() {
        String moveType = "";
        int moveNumber = r.nextInt(3) + 1;

        displayMove(moveNumber);

        if(moveNumber == 1) moveType = "1";
        if(moveNumber == 2) moveType = "2";
        if(moveNumber == 3) moveType = "3";

        return moveType;
    }

    private void displayMove(int moveNumber) {
        if (moveNumber == 1) System.out.println("Computer has chosen rock!");
        if (moveNumber == 2) System.out.println("Computer has chosen paper!");
        if (moveNumber == 3) System.out.println("Computer has chosen scissors!");
    }
}
