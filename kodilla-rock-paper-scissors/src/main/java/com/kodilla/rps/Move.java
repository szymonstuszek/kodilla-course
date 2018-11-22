package com.kodilla.rps;

public enum Move {
    ROCK("0"), PAPER("1"), SCISSORS("2"), LIZARD("3"), SPOCK("4");

    private String moveId;

    Move(String moveId) {
        this.moveId = moveId;
    }

    public String getMoveId() {
        return moveId;
    }


}
