package com.kodilla.exception.test;

public class ExceptionHandling {

    public void handleException() throws Exception {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyIWillThrowException(1.7, 1.5);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Wyjątek: " + e);
        } finally {
            System.out.println("Z błędem lub bez - proces zakończony");
        }

    }
}
