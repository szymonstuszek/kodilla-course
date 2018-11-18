package com.kodilla.rps;

import java.util.Scanner;

public class Game {
    private Computer computer;
    private ResultCalculator resultCalculator;
    private Scanner sc;

    public Game() {
        computer = new Computer();
        resultCalculator = new ResultCalculator();
        sc = new Scanner(System.in);
        initGame();
    }

    private void initGame() {
        boolean running = true;

        GameMessages.displayMessage(GameMessages.GAME_INSTRUCTIONS);

        while(running) {

            resultCalculator.checkWhoWinsGame();

            System.out.print("Choose your move: ");
            int playerInput = sc.nextInt();
            int computerMove;

            switch (playerInput) {

                case 0:
                    running = false;
                    break;

                case 1:
                    GameMessages.displayMessage(GameMessages.ROCK);
                    computerMove = computer.chooseMove();
                    resultCalculator.checkWhoWinsRound(playerInput, computerMove);
                    GameMessages.displayScores(GameScores.playerScore, GameScores.computerScore);
                    break;

                case 2:
                    GameMessages.displayMessage(GameMessages.PAPER);
                    computerMove = computer.chooseMove();
                    resultCalculator.checkWhoWinsRound(playerInput, computerMove);
                    GameMessages.displayScores(GameScores.playerScore, GameScores.computerScore);
                    break;

                case 3:
                    GameMessages.displayMessage(GameMessages.SCISSORS);
                    computerMove = computer.chooseMove();
                    resultCalculator.checkWhoWinsRound(playerInput, computerMove);
                    GameMessages.displayScores(GameScores.playerScore, GameScores.computerScore);
                    break;

                default:
                    GameMessages.displayMessage(GameMessages.INVALID_MOVE);
                    break;
            }
        }

        GameMessages.displayMessage(GameMessages.END_GAME);
    }
}
