package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController(scanner);

        HumanPlayer humanPlayer = gameController.createPlayer();
        ComputerPlayer computerPlayer = gameController.createComputerPlayer();
        int maxRounds = gameController.setupMaxRounds();

        Game rpsGame = new RpsGame("Rock Paper Scissors", maxRounds, Rules.rpsRules);

        GameProcessor gameProcessor = new GameProcessor(rpsGame, humanPlayer, computerPlayer, scanner);
        gameProcessor.startGame();
    }
}
