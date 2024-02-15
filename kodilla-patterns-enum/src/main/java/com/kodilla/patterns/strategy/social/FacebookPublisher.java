package com.kodilla.patterns.strategy.social;

public final class FacebookPublisher implements SocialPublisher{
    @Override
    public void share() {
        System.out.println("Sharing on Facebook");
    }
}
