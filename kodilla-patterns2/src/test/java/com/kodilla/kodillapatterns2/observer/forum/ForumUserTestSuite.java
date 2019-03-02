package com.kodilla.kodillapatterns2.observer.forum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForumUserTestSuite {

    @Test
    public void testUpdate() {
        //Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();

        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser pabloEscobar = new ForumUser("Pablo Escobar");
        ForumUser jessiePinkman = new ForumUser("Jessie Pinkman");

        javaHelpForum.registerObserver(johnSmith);
        javaHelpForum.registerObserver(jessiePinkman);
        javaToolsForum.registerObserver(pabloEscobar);
        javaToolsForum.registerObserver(jessiePinkman);

        //When
        javaHelpForum.addPost("Hello everyone I need  help with a task");
        javaHelpForum.addPost("Which one is it?");
        javaToolsForum.addPost("How to make sql work");
        javaHelpForum.addPost("I have the same");
        javaToolsForum.addPost("Try reboot");

        //Then

        assertEquals(2, pabloEscobar.getUpdateCount());
        assertEquals(5, jessiePinkman.getUpdateCount());
        assertEquals(3, johnSmith.getUpdateCount());
    }
}
