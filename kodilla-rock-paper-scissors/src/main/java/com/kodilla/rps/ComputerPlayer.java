package com.kodilla.rps;

import java.util.Random;

public class ComputerPlayer extends Player {
    Random random = new Random();

    public ComputerPlayer(String username) {
        super(username);
    }

    public int generateMove() {
        return random.nextInt(3);
    }

}
