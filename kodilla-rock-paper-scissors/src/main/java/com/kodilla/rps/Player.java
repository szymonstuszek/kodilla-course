package com.kodilla.rps;


public abstract class Player {
    private String username;
    private int points;

    public Player(String username) {
        this.username = username;
    }

    public Move getMove(int moveId) {
        Move move = Move.values()[moveId];
        return move;
    }

    public void addPoint() {
        points++;
    }

    private String getUsername() {
        return username;
    }

    private int getPoints() {
        return points;
    }

    public void displayPlayerPoints() {
        System.out.println(getUsername() + ": " + getPoints() + " points");
    }

}
