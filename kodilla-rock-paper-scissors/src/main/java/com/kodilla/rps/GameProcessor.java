package com.kodilla.rps;

import java.util.Scanner;

public class GameProcessor {
    Scanner scanner;
    private Game game;
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;
    private int currentRound = 0;
    private boolean gameRunning = true;

    public GameProcessor(Game game, HumanPlayer humanPlayer,
                         ComputerPlayer computerPlayer, Scanner scanner) {
        this.game = game;
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        this.scanner = scanner;
    }

    public void startGame() {

        while (gameRunning) {
            System.out.println("Input your move.");
            String humanInput = scanner.nextLine();

            if(continuePlaying(humanInput)){
                int humanMove = Integer.parseInt(humanInput) - 1;
                int computerMove = computerPlayer.generateMove(game.getCountOfAllowedMoves());
                System.out.println("Player has chosen: " + humanPlayer.getMove(humanMove) +
                        " computer has chosen: " + computerPlayer.getMove(computerMove));

                RoundResult roundResult = game.getResult(humanMove, computerMove);

                switch (roundResult) {
                    case DRAW:
                        System.out.println("No one scores");
                        break;
                    case LOSS:
                        System.out.println("Player loses");
                        computerPlayer.addPoint();
                        break;
                    case WIN:
                        System.out.println("Player wins");
                        humanPlayer.addPoint();
                        break;
                    default:
                        System.out.println("Round result error");
                        break;
                }

                currentRound++;
                System.out.println("Current round: " + currentRound);
                if(currentRound >= game.getMaxRounds()) {
                    checkIfPlayerWantsToContinue();
                }
            }
        }
    }

    private void checkIfPlayerWantsToContinue() {
        boolean correctInput = false;

        while (!correctInput) {
            System.out.println("\n====================");
            System.out.println("Max rounds reached!");
            System.out.println("x - quit | n - start a new round ");
            System.out.println("Scores");
            humanPlayer.getPoints();
            computerPlayer.getPoints();
            System.out.println("====================");
            String endGameInput = scanner.nextLine();
            System.out.println("Your choice " + endGameInput);

            if (endGameInput.equals("x")) {
                gameRunning = false;
                correctInput = true;
            }

            if (endGameInput.equals("n")) {
                currentRound = 0;
                correctInput = true;
            }
        }
    }

    private boolean continuePlaying(String humanInput) {
        if (humanInput.equals("x")) {
            gameRunning = false;
            return false;
        }

        if (humanInput.equals("n")) {
            currentRound = 0;
            return false;
        }

        return true;
    }
}