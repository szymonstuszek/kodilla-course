package com.kodilla.rps;

import java.util.Scanner;

public class GameController {
    private GameProcessor gameProcessor;
    Scanner scanner;

    GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public HumanPlayer createPlayer() {
        System.out.println("Input your name");
        String username = scanner.nextLine();
        HumanPlayer humanPlayer = new HumanPlayer(username);
        return humanPlayer;
    }

    public ComputerPlayer createComputerPlayer() {
        ComputerPlayer computerPlayer = new ComputerPlayer("Computer oponent");
        return computerPlayer;
    }

    public int setupMaxRounds() {
        System.out.println("How many rounds would you like to play?");
        int maxRounds = scanner.nextInt();
        scanner.nextLine();
        return maxRounds;
    }

}
