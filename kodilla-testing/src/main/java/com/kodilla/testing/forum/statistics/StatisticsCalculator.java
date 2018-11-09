package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {
    Statistics statistics;
    private int numberOfForumUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double averageNumberOfPostsPerUser;
    private double averageNumberOfCommentsPerUser;
    private double averageNumberOfCommentsPerPost;

    public StatisticsCalculator(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics() {

        numberOfForumUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();

        if(numberOfForumUsers != 0) {
            averageNumberOfPostsPerUser = (double) (numberOfPosts / numberOfForumUsers);
            averageNumberOfCommentsPerUser = (double) (numberOfComments / numberOfForumUsers);
        }

        if(numberOfPosts != 0) {
           averageNumberOfCommentsPerPost = (double) numberOfComments / (double) numberOfPosts;
        }
    }

    public void showStatistics() {
        System.out.println("Number of forum users: " + numberOfForumUsers);
        System.out.println("Number of posts: " + numberOfPosts);
        System.out.println("Number of comments: " + numberOfComments);
        System.out.println("Number of posts per user: " + averageNumberOfPostsPerUser);
        System.out.println("Number of comments per user: " + averageNumberOfCommentsPerUser);
        System.out.println("Number of comments per post: " + averageNumberOfCommentsPerPost);
    }

    public int getNumberOfForumUsers() {
        return numberOfForumUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public double getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public double getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }
}
