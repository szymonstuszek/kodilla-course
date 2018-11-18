package com.kodilla.rps;

import java.util.Random;

public class Computer {
    Random r = new Random();

    public int chooseMove() {
        int moveType = r.nextInt(3) + 1;

        displayMove(moveType);

        return moveType;
    }

    private void displayMove(int moveType) {
        if (moveType == 1) {
            System.out.println("Computer has chosen rock!");
        }
        if (moveType == 2) {
            System.out.println("Computer has chosen paper!");
        }
         if (moveType == 3) {
            System.out.println("Computer has chosen scissors!");
        }
    }
}
