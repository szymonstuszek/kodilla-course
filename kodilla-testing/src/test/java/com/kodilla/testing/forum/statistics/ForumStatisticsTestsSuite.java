package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestsSuite {

    @Test
    public void testGetNumberOfPostsWhenNoPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.postsCount()).thenReturn(0);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);

        //When
        statisticsCalculator.calculateAdvStatistics();
        int numberOfPosts = statisticsCalculator.getNumberOfPosts();

        statisticsCalculator.showStatistics();

        //Then
        Assert.assertEquals(0, numberOfPosts);
    }

    @Test
    public void testGetNumberOfPostsWhen1000Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.postsCount()).thenReturn(1000);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);

        //When
        statisticsCalculator.calculateAdvStatistics();
        int numberOfPosts = statisticsCalculator.getNumberOfPosts();

        statisticsCalculator.showStatistics();

        //Then
        Assert.assertEquals(1000, numberOfPosts);
    }

    @Test
    public void testGetNumberOfCommentsWhen0Comments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.commentsCount()).thenReturn(0);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);

        //When
        statisticsCalculator.calculateAdvStatistics();
        int numberOfComments = statisticsCalculator.getNumberOfComments();

        statisticsCalculator.showStatistics();

        //Then
        Assert.assertEquals(0, numberOfComments);
    }

    @Test
    public void testWhenNumberOfCommentsLessThanNumberOfPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.commentsCount()).thenReturn(50);
        when(statisticsMock.postsCount()).thenReturn(100);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);

        //When
        statisticsCalculator.calculateAdvStatistics();
        double averageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        statisticsCalculator.showStatistics();

        //Then
        Assert.assertEquals(0.5, averageNumberOfCommentsPerPost, 0.001);
    }

    @Test
    public void testWhenNumberOfCommentsHigherThanNumberOfPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.commentsCount()).thenReturn(250);
        when(statisticsMock.postsCount()).thenReturn(100);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);

        //When
        statisticsCalculator.calculateAdvStatistics();
        double averageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        statisticsCalculator.showStatistics();

        //Then
        Assert.assertEquals(2.5, averageNumberOfCommentsPerPost, 0.001);
    }

    @Test
    public void testWhenNoUsersRegistered() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<>());

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);

        //When
        statisticsCalculator.calculateAdvStatistics();
        int numberOfForumUsers = statisticsCalculator.getNumberOfForumUsers();

        statisticsCalculator.showStatistics();

        //Then
        Assert.assertEquals(0, numberOfForumUsers);
    }

    @Test
    public void testWhen100UsersRegistered() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        ArrayList<String> userListWith100Users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            userListWith100Users.add("test user");
        }

        when(statisticsMock.usersNames()).thenReturn(userListWith100Users);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);

        //When
        statisticsCalculator.calculateAdvStatistics();
        int numberOfForumUsers = statisticsCalculator.getNumberOfForumUsers();

        statisticsCalculator.showStatistics();

        //Then
        Assert.assertEquals(100, numberOfForumUsers);
    }

}
