package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User millenial = new Millenials("John");
        User yGeneration = new YGeneration("Henry");
        User zGeneration = new ZGeneration("Marc");

        String millenialPost = "Using snapchat";
        String yGenerationPost = "Using facebook";
        String zGenerationPost = "Using twitter";

        //When
        String postFromJohn = millenial.sharePost();
        String postFromHenry = yGeneration.sharePost();
        String postFromMarc = zGeneration.sharePost();

        //Then
        Assert.assertEquals(millenialPost, postFromJohn);
        Assert.assertEquals(yGenerationPost, postFromHenry);
        Assert.assertEquals(zGenerationPost, postFromMarc);

    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User millenial = new Millenials("John");

        //When
        millenial.setSocialPublisher(new FacebookPublisher());
        String postAfterPublisherChange = millenial.sharePost();

        //Then
        Assert.assertEquals("Using facebook", postAfterPublisherChange);

    }
}
