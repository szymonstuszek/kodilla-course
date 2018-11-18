package com.kodilla.rps;

public class ResultCalculator {
    private SessionInfo sessionInfo;

    public ResultCalculator(SessionInfo sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    public boolean checkIfGameIsOver() {
        if(GameScores.playerScore == sessionInfo.getNumberOfRounds()) {
            displayPlayerWinsMessage();
            GameScores.resetScores();
            GameMessages.displayMessage(GameMessages.GAME_FINISHED);
            return true;
        }

        if(GameScores.computerScore == sessionInfo.getNumberOfRounds()) {
            displayComputerWinsMessage();
            GameScores.resetScores();
            GameMessages.displayMessage(GameMessages.GAME_FINISHED);
            return true;
        }

        return false;
    }

    public void checkWhoWinsRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            GameMessages.displayMessage(GameMessages.DRAW);
        }

        if(playerMove.equals("1") && computerMove.equals("2")) {
            GameScores.computerScore++;
            GameMessages.displayMessage(GameMessages.COMPUTER_WINS);
        }

        if(playerMove.equals("1") && computerMove.equals("3")) {
            GameScores.playerScore++;
            GameMessages.displayMessage(GameMessages.PLAYER_WINS);
        }

        if(playerMove.equals("2") && computerMove.equals("1")) {
            GameScores.playerScore++;
            GameMessages.displayMessage(GameMessages.PLAYER_WINS);
        }

        if(playerMove.equals("2") && computerMove.equals("3")) {
            GameScores.computerScore++;
            GameMessages.displayMessage(GameMessages.COMPUTER_WINS);
        }

        if(playerMove.equals("3") && computerMove.equals("1")) {
            GameScores.computerScore++;
            GameMessages.displayMessage(GameMessages.COMPUTER_WINS);
        }

        if(playerMove.equals("3") && computerMove.equals("2")) {
            GameScores.playerScore++;
            GameMessages.displayMessage(GameMessages.PLAYER_WINS);
        }
    }

    private void displayPlayerWinsMessage() {
        System.out.println(
                "=========================== \n" +
                "=========================== \n" +
                sessionInfo.getPlayerName() + " has won with:\n" +
                GameScores.playerScore + " points\n" +
                "=========================== \n" +
                "==========================="
        );
    }

    private void displayComputerWinsMessage() {
        System.out.println(
                "=========================== \n" +
                "=========================== \n" +
                "Computer has won with:\n" +
                GameScores.computerScore + " points\n" +
                "=========================== \n" +
                "==========================="
        );
    }
}
