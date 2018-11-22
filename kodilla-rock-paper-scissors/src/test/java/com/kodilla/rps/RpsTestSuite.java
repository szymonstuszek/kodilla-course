package com.kodilla.rps;


import org.junit.Assert;
import org.junit.Test;


public class RpsTestSuite {

    @Test
    public void testPlayer1PlaysRockPlayer2PlaysRockResult() {
        //Given
        Game rpsGame = new RpsGame("Rock Paper Scissors", 1, Rules.rpsRules);
        int player1Move = 0;
        int player2Move = 0;

        //When
        RoundResult roundResult = rpsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.DRAW);
    }

    @Test
    public void testPlayer1PlaysPaperPlayer2PlaysRockResult() {
        //Given
        Game rpsGame = new RpsGame("Rock Paper Scissors", 1, Rules.rpsRules);
        int player1Move = 1;
        int player2Move = 0;

        //When
        RoundResult roundResult = rpsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.WIN);
    }

    @Test
    public void testPlayer1PlaysScissorsPlayer2PlaysRockResult() {
        //Given
        Game rpsGame = new RpsGame("Rock Paper Scissors", 1, Rules.rpsRules);
        int player1Move = 2;
        int player2Move = 0;

        //When
        RoundResult roundResult = rpsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.LOSS);
    }

    @Test
    public void testPlayer1PlaysRockPlayer2PlaysPaperResult() {
        //Given
        Game rpsGame = new RpsGame("Rock Paper Scissors", 1, Rules.rpsRules);
        int player1Move = 0;
        int player2Move = 1;

        //When
        RoundResult roundResult = rpsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.LOSS);
    }

    @Test
    public void testPlayer1PlaysPaperPlayer2PlaysPaperResult() {
        //Given
        Game rpsGame = new RpsGame("Rock Paper Scissors", 1, Rules.rpsRules);
        int player1Move = 1;
        int player2Move = 1;

        //When
        RoundResult roundResult = rpsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.DRAW);
    }

    @Test
    public void testPlayer1PlaysScissorsPlayer2PlaysPaperResult() {
        //Given
        Game rpsGame = new RpsGame("Rock Paper Scissors", 1, Rules.rpsRules);
        int player1Move = 2;
        int player2Move = 1;

        //When
        RoundResult roundResult = rpsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.WIN);
    }

    @Test
    public void testPlayer1PlaysRockPlayer2PlaysScissorsResult() {
        //Given
        Game rpsGame = new RpsGame("Rock Paper Scissors", 1, Rules.rpsRules);
        int player1Move = 0;
        int player2Move = 2;

        //When
        RoundResult roundResult = rpsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.WIN);
    }

    @Test
    public void testPlayer1PlaysPaperPlayer2PlaysScissorsResult() {
        //Given
        Game rpsGame = new RpsGame("Rock Paper Scissors", 1, Rules.rpsRules);
        int player1Move = 1;
        int player2Move = 2;

        //When
        RoundResult roundResult = rpsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.LOSS);
    }

    @Test
    public void testPlayer1PlaysScissorsPlayer2PlaysScissorsResult() {
        //Given
        Game rpsGame = new RpsGame("Rock Paper Scissors", 1, Rules.rpsRules);
        int player1Move = 2;
        int player2Move = 2;

        //When
        RoundResult roundResult = rpsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.DRAW);
    }
}
