package com.kodilla.rps;

import java.util.Scanner;

public class Game {
    private Computer computer;
    private ResultCalculator resultCalculator;
    private SessionInfo sessionInfo;
    private Scanner sc;

    public Game() {
        computer = new Computer();
        sessionInfo = new SessionInfo();
        resultCalculator = new ResultCalculator(sessionInfo);
        sc = new Scanner(System.in);
    }

    private void setupGame() {
        GameMessages.displayMessage(GameMessages.GAME_INSTRUCTIONS);
        setupPlayerName();
        setupNumberOfRounds();
    }

    private void setupPlayerName() {
        GameMessages.displayMessage(GameMessages.GET_NAME);
        String playerName = sc.nextLine();
        sessionInfo.setPlayerName(playerName);
        sessionInfo.getGreeting();
    }

    private void setupNumberOfRounds() {
        GameMessages.displayMessage(GameMessages.GET_NUMBER_OF_ROUNDS);
        int numberOfRounds = sc.nextInt();
        sc.nextLine();
        sessionInfo.setNumberOfRounds(numberOfRounds);
        sessionInfo.displayNumberOfRounds();
    }

    public void initGame() {
        boolean running = true;
        String computerMove;

        setupGame();

        gameLoop:
        while(running) {

            System.out.print("New round starting - ");
            System.out.print("Choose your move: ");
            String playerInput = sc.nextLine();


            switch (playerInput) {

                case "x":
                    GameMessages.displayMessage(GameMessages.CONFIRM_END_GAME);
                    String endGameOption = sc.nextLine();

                    if (endGameOption.equals("y")) {
                        running = false;
                    }
                    break;

                case "n":
                    GameMessages.displayMessage(GameMessages.CONFIRM_NEW_GAME);
                    String newGameOption = sc.nextLine();

                    if (newGameOption.equals("y")) {
                        GameScores.resetScores();
                    }
                    break;

                case "1":
                    GameMessages.displayMessage(GameMessages.ROCK);
                    computerMove = computer.chooseMove();
                    resultCalculator.checkWhoWinsRound(playerInput, computerMove);
                    GameMessages.displayScores(GameScores.playerScore, GameScores.computerScore);
                    break;

                case "2":
                    GameMessages.displayMessage(GameMessages.PAPER);
                    computerMove = computer.chooseMove();
                    resultCalculator.checkWhoWinsRound(playerInput, computerMove);
                    GameMessages.displayScores(GameScores.playerScore, GameScores.computerScore);
                    break;

                case "3":
                    GameMessages.displayMessage(GameMessages.SCISSORS);
                    computerMove = computer.chooseMove();
                    resultCalculator.checkWhoWinsRound(playerInput, computerMove);
                    GameMessages.displayScores(GameScores.playerScore, GameScores.computerScore);
                    break;

                default:
                    GameMessages.displayMessage(GameMessages.INVALID_MOVE);
                    break;
            }


            if(resultCalculator.checkIfGameIsOver()) {
                String endgameInput = null;

                endgameLoop:
                while(endgameInput != "x" && endgameInput != "n") {
                    endgameInput = sc.nextLine();

                    switch (endgameInput) {
                        case "x":
                            break gameLoop;

                        case "n":
                            GameScores.resetScores();
                            break endgameLoop;

                        default:
                            System.out.println("Choose a correct option.");
                            break;
                    }
                }
            }
        }

        GameMessages.displayMessage(GameMessages.END_GAME);
    }
}
