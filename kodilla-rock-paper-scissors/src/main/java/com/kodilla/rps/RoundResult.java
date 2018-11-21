package com.kodilla.rps;

public enum RoundResult {
    LOSS("-1"), DRAW("0"), WIN("1");

    private String roundResultId;

    RoundResult(String roundResultId) {
        this.roundResultId = roundResultId;
    }

    public String getRoundResultId() {
        return roundResultId;
    }


}
