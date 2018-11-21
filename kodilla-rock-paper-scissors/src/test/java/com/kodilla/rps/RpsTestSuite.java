package com.kodilla.rps;


import org.junit.Assert;
import org.junit.Test;


public class RpsTestSuite {

    @Test
    public void testPlayer1RockPlayer2RockResult() {
        //Given
        Game rpsGame = new RpsGame("Rock Paper Scissors", 1, Rules.rpsRules);
        int player1Move = 0;
        int player2Move = 0;

        //When
        RoundResult roundResult = rpsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.DRAW);
    }
}
