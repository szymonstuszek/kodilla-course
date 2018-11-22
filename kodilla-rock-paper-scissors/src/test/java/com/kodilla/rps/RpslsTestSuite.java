package com.kodilla.rps;

import org.junit.Assert;
import org.junit.Test;

public class RpslsTestSuite {

    @Test
    public void testPlayer1PlaysLizardPlayer2PlaysLizardResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 3;
        int player2Move = 3;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.DRAW);
    }

    @Test
    public void testPlayer1PlaysSpockPlayer2PlaysSpockResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 4;
        int player2Move = 4;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.DRAW);
    }

    @Test
    public void testPlayer1PlaysRockPlayer2PlaysLizardResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 0;
        int player2Move = 3;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.WIN);
    }

    @Test
    public void testPlayer1PlaysLizardPlayer2PlaysRockResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 3;
        int player2Move = 0;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.LOSS);
    }

    @Test
    public void testPlayer1PlaysRockPlayer2PlaysSpockResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 0;
        int player2Move = 4;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.LOSS);
    }

    @Test
    public void testPlayer1PlaysSpockPlayer2PlaysRockResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 4;
        int player2Move = 0;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.WIN);
    }

    @Test
    public void testPlayer1PlaysPaperPlayer2PlaysLizardResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 1;
        int player2Move = 3;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.LOSS);
    }

    @Test
    public void testPlayer1PlaysLizardPlayer2PlaysPaperResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 3;
        int player2Move = 1;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.WIN);
    }

    @Test
    public void testPlayer1PlaysPaperPlayer2PlaysSpockResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 1;
        int player2Move = 4;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.WIN);
    }

    @Test
    public void testPlayer1PlaysSpockPlayer2PlaysPaperResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 4;
        int player2Move = 1;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.LOSS);
    }

    @Test
    public void testPlayer1PlaysScissorsPlayer2PlaysLizardResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 2;
        int player2Move = 3;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.WIN);
    }

    @Test
    public void testPlayer1PlaysLizardPlayer2PlaysScissorsResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 3;
        int player2Move = 2;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.LOSS);
    }

    @Test
    public void testPlayer1PlaysScissorsPlayer2PlaysSpockResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 2;
        int player2Move = 4;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.LOSS);
    }

    @Test
    public void testPlayer1PlaysSpockPlayer2PlaysScissorsResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 4;
        int player2Move = 2;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.WIN);
    }

    @Test
    public void testPlayer1PlaysLizardPlayer2PlaysSpockResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 3;
        int player2Move = 4;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.WIN);
    }

    @Test
    public void testPlayer1PlaysSpockPlayer2PlaysLizardResult() {
        //Given
        Game rpslsGame = new RpslsGame("Rock Paper Scissors Lizard Spock", 1, Rules.rpslsRules);
        int player1Move = 4;
        int player2Move = 3;

        //When
        RoundResult roundResult = rpslsGame.getResult(player1Move, player2Move);

        //Then
        Assert.assertEquals(roundResult, RoundResult.LOSS);
    }
}
