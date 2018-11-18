package com.kodilla.rps;

public class SessionInfo {
    private String playerName;
    private int numberOfRounds;

    public SessionInfo() {

    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void getGreeting() {
        System.out.println("Hello " + playerName);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void displayNumberOfRounds() {
        System.out.println("You have chosen to play: " + numberOfRounds + " rounds per game");
    }
}
