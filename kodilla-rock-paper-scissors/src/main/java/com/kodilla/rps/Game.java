package com.kodilla.rps;

public abstract class Game {
    protected String gameName;
    protected int maxRounds;
    protected int[][] rules;

    public Game(String gameName, int maxRounds, int[][] rules) {
        this.gameName = gameName;
        this.maxRounds = maxRounds;
        this.rules = rules;
    }

    public abstract RoundResult getResult(int player1, int player2);

    public int getMaxRounds() {
        return maxRounds;
    }

    public void setMaxRounds(int maxRounds) {
        this.maxRounds = maxRounds;
    }
}
