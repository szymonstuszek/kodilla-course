package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.*;

public class ForumTestSuite {
    private static int testCounter  = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("Tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test#" + testCounter);
    }

    @Test
    public void testAddPost() {
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");

        forumUser.addPost("mrsmith", "Hello everyone, this is my first contribution here!");

        Assert.assertEquals(1, forumUser.getPostsQuantity());
    }

    @Test
    public void testAddComment() {
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone," +
                " this is my first contribution", "mrsmith");

        forumUser.addComment(thePost, "mrsmith", "Thank you all for all good words!");

        Assert.assertEquals(1, forumUser.getCommentsQuantity());
    }

    @Test
    public void testGetPost() {
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone," +
                " this is my first contribution", "mrsmith");

        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

        ForumPost retrievedPost;
        retrievedPost = forumUser.getPost(0);

        Assert.assertEquals(thePost, retrievedPost);
    }

    @Test
    public void testGetComment() {
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone," +
                " this is my first contribution", "mrsmith");

        ForumComment theComment = new ForumComment(thePost, "mrsmith" ,
                "Thank you all for the good words!");

        forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

        ForumComment retrievedComment = forumUser.getComment(0);

        Assert.assertEquals(theComment, retrievedComment);
    }

    @Test
    public void testRemovePostNotExisting() {
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone," +
                " this is my first contribution", "mrsmith");

        boolean result = forumUser.removePost(thePost);

        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveCommentNotExisting() {
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone," +
                " this is my first contribution", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "mrsmith" ,
                "Thank you all for the good words!");

        boolean result = forumUser.removeComment(theComment);

        Assert.assertFalse(result);
    }

    @Test
    public void testRemovePost() {
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone," +
                " this is my first contribution", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "mrsmith" ,
                "Thank you all for the good words!");
        forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

        boolean result = forumUser.removeComment(theComment);

        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getCommentsQuantity());
    }

    @Test
    public void testRemoveComment() {
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone," +
                " this is my first contribution", "mrsmith");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

        boolean result = forumUser.removePost(thePost);

        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getPostsQuantity());
    }
}
