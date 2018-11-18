package com.kodilla.rps;

public class ResultCalculator {

    public void checkWhoWinsGame() {
        if(GameScores.playerScore == 3) {
            GameMessages.displayMessage(GameMessages.SUCCESS);
            GameScores.resetScores();
            GameMessages.displayMessage(GameMessages.NEW_ROUND);
        }

        if(GameScores.computerScore == 3) {
            GameMessages.displayMessage(GameMessages.LOST);
            GameScores.resetScores();
            GameMessages.displayMessage(GameMessages.NEW_ROUND);
        }
    }

    public void checkWhoWinsRound(int playerMove, int computerMove) {

        if (playerMove == computerMove) {
            GameMessages.displayMessage(GameMessages.DRAW);
        }

        if(playerMove == 1 && computerMove == 2) {
            GameScores.computerScore++;
            GameMessages.displayMessage(GameMessages.COMPUTER_WINS);
        }

        if(playerMove == 1 && computerMove == 3) {
            GameScores.playerScore++;
            GameMessages.displayMessage(GameMessages.PLAYER_WINS);
        }

        if(playerMove == 2 && computerMove == 1) {
            GameScores.playerScore++;
            GameMessages.displayMessage(GameMessages.PLAYER_WINS);
        }

        if(playerMove == 2 && computerMove == 3) {
            GameScores.computerScore++;
            GameMessages.displayMessage(GameMessages.COMPUTER_WINS);
        }

        if(playerMove == 3 && computerMove == 1) {
            GameScores.computerScore++;
            GameMessages.displayMessage(GameMessages.COMPUTER_WINS);
        }

        if(playerMove == 3 && computerMove == 2) {
            GameScores.playerScore++;
            GameMessages.displayMessage(GameMessages.PLAYER_WINS);
        }
    }
}
