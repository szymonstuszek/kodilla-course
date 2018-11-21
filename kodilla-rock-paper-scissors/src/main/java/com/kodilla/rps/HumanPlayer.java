package com.kodilla.rps;

public class HumanPlayer extends Player {


    public HumanPlayer(String username) {
        super(username);
    }

    public boolean isMoveIdCorrect(int humanPlayerInput) {
        if(humanPlayerInput >= 0 && humanPlayerInput <=2) return true;

        return false;
    }
}
