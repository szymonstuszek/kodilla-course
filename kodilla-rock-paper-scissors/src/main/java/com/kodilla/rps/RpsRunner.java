package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController(scanner);

        HumanPlayer humanPlayer = gameController.createPlayer();
        ComputerPlayer computerPlayer = gameController.createComputerPlayer();
        int maxRounds = gameController.setupMaxRounds();

        Game rpslsGame = new RpslsGame("Rock Paper Scissors", maxRounds, Rules.rpslsRules);

        GameProcessor gameProcessor = new GameProcessor(rpslsGame, humanPlayer, computerPlayer, scanner);
        gameProcessor.startGame();
    }
}
