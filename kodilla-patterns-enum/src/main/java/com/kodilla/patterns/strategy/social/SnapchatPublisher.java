package com.kodilla.patterns.strategy.social;

public final class SnapchatPublisher implements SocialPublisher{
    @Override
    public void share() {
        System.out.println("Sharing on Snapchat");
    }
}
