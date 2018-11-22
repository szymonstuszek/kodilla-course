package com.kodilla.rps;

import java.util.Random;

public class ComputerPlayer extends Player {
    Random random = new Random();

    public ComputerPlayer(String username) {
        super(username);
    }

    public int generateMove(int countOfAllowedMoves) {
        return random.nextInt(countOfAllowedMoves);
    }

    public int generateCheatMoveStandardGame(int oponentInput) {
        int preferredMove = checkWhichMoveWinsStandardGame(oponentInput);
        int loosingMove = checkWhichMoveLoosesStandardGame(oponentInput);

        int chooseMove = random.nextInt(4);

        if (chooseMove == 0 || chooseMove == 1) {
            return preferredMove;
        }

        if (chooseMove == 2) {
            return loosingMove;
        }

        else {
            return oponentInput;
        }
    }

    private int checkWhichMoveWinsStandardGame(int moveId) {
        int winningMove = 0;
        if(moveId == 0) winningMove = 1;
        if(moveId == 1) winningMove = 2;
        return winningMove;
    }

    private int checkWhichMoveLoosesStandardGame(int moveId) {
        int loosingMove = 0;
        if(moveId == 0) loosingMove = 2;
        if(moveId == 2) loosingMove = 1;
        return loosingMove;
    }
}
