package com.kodilla.rps;

public abstract class Game {
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

    public void setMaxRounds(int maxRounds) {
        this.maxRounds = maxRounds;
    }

    public String getGameName() {
        return gameName;
    }
}
