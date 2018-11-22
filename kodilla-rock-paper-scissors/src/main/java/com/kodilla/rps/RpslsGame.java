package com.kodilla.rps;

public class RpslsGame extends Game {
    public RpslsGame(String name, int maxRounds, int[][] rules) {
        super(name, maxRounds, rules);
    }

    @Override
    public RoundResult getResult(int player1, int player2) {
        int result = Rules.rpslsRules[player1][player2];

        String resultString = Integer.toString(result);
        RoundResult roundResult = null;

        for (int i = 0; i < RoundResult.values().length; i++) {
            if(resultString.equals(RoundResult.values()[i].getRoundResultId())) {
                roundResult = RoundResult.values()[i];
                break;
            }
        }

        return roundResult;
    }
}
