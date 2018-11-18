package com.kodilla.rps;

public final class GameMessages {

    public GameMessages() {

    }

    public final static String PAPER = "You have chosen paper!";
    public final static String ROCK = "You have chosen rock!";
    public final static String SCISSORS = "You have chosen scissors!";
    public final static String INVALID_MOVE = "No such option!";

    public final static String DRAW = "No one scores.\n";
    public final static String PLAYER_WINS = "You win this round!\n";
    public final static String COMPUTER_WINS = "Computer wins this round.\n";


    public final static String CONFIRM_NEW_GAME = "Are you sure you want to end the current game and start a new one? \n" +
                                          "y - start new game \n" +
                                          "any button to cancel\n";

    public final static String CONFIRM_END_GAME = "Are you sure you want to end the game? \n" +
                                                  "y - confirm \n" +
                                                  "any button to continue playing\n";

    public final static String GAME_FINISHED = "x - end game \n" +
                                               "n - start a new round \n";

    public final static String END_GAME = "Thanks for playing!";

    public final static String GET_NAME = "Please enter your name.";
    public final static String GET_NUMBER_OF_ROUNDS = "Enter the number of rounds that you wish to play";

    public final static String GAME_INSTRUCTIONS =
            "Welcome to RPS game! \n" +
            "1 - play rock \n" +
            "2 - play paper \n" +
            "3 - play scissors\n" +
            "x - end game \n" +
            "n - start a new game";

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayScores(int playerScore, int computerScore) {
        System.out.println("Player score: " + playerScore + " Computer score: " + computerScore);
    }

}
