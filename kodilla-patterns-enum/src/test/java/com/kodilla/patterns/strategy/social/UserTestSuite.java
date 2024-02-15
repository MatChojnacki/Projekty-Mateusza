package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        // Given
        User millenial = new Millenials("Millenial1");
        User yGeneration = new YGeneration("YGeneration1");
        User zGeneration = new ZGeneration("ZGeneration1");

        // When & Then
        assertEquals("Sharing on Facebook", millenial.socialPublisher.getClass().getSimpleName());
        assertEquals("Sharing on Twitter", yGeneration.socialPublisher.getClass().getSimpleName());
        assertEquals("Sharing on Snapchat", zGeneration.socialPublisher.getClass().getSimpleName());
    }

    @Test
    public void testIndividualSharingStrategy() {
        // Given
        User millenial = new Millenials("Millenial2");
        millenial.setSocialPublisher(new TwitterPublisher());

        // When & Then
        assertEquals("Sharing on Twitter", millenial.socialPublisher.getClass().getSimpleName());
    }
}