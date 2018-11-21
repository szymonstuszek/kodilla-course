package com.kodilla.rps;


public abstract class Player {
    protected String username;
    protected int points;

    public Player(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Move getMove(int moveId) {
        Move move = Move.values()[moveId];
        return move;
    }

    public void addPoint() {
        points++;
    }

    public void getPoints() {
        System.out.println(username + ": " + points + " points");
    }

}
