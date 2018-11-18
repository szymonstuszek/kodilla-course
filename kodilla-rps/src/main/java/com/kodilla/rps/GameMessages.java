package com.kodilla.rps;

public final class GameMessages {

    public GameMessages() {

    }

    public final static String PAPER = "You have chosen paper!";
    public final static String ROCK = "You have chosen rock!";
    public final static String SCISSORS = "You have chosen scissors!";

    public final static String PLAYER_MOVE = "It is your turn!";
    public final static String INVALID_MOVE = "No such option!";

    public final static String NEW_ROUND = "New round starting!";

    public final static String DRAW = "No one scores";
    public final static String PLAYER_WINS = "You win this round!";
    public final static String COMPUTER_WINS = "Computer wins this round.";

    public final static String SUCCESS = "=========================== \n" +
                                         "--------You have won------- \n" +
                                         "===========================";

    public final static String LOST = "=========================== \n" +
                                      "--------You have lost------ \n" +
                                      "===========================";

    public final static String END_GAME = "Thanks for playing!";


    public final static String GAME_INSTRUCTIONS =
            "Welcome to RPS game! \n" +
            "1 - play rock \n" +
            "2 - play paper \n" +
            "3 - play scissors\n" +
            "0 - end game \n" +
            "Win 3 times to score!";

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayScores(int playerScore, int computerScore) {
        System.out.println("Player score: " + playerScore + " Computer score: " + computerScore);
    }

}
