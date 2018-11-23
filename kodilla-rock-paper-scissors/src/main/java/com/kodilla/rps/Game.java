package com.kodilla.rps;

public abstract class Game {
    public static final String RPS_GAME_NAME = "Rock paper scissors";
    public static final String RPSLS_GAME_NAME = "Rock paper scissors lizard spock";

    private String gameName;
    private int maxRounds;
    private int[][] rules;

    public Game(String gameName, int maxRounds, int[][] rules) {
        this.gameName = gameName;
        this.maxRounds = maxRounds;
        this.rules = rules;
    }

    public abstract RoundResult getResult(int player1, int player2);

    public int getMaxRounds() {
        return maxRounds;
    }

    public int getCountOfAllowedMoves() {
        return getRules().length;
    }

    public int[][] getRules() {
        return rules;
    }

}
