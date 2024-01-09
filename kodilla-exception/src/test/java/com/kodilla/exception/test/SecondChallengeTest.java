package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTest {

    @Test
    void testProbablyIWillThrowException() {
        SecondChallenge secondChallenge = new SecondChallenge();

        // Test for correct value
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0, 2.0));

        // Test for x >= 2
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 1.0));

        // Test for x < 1
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.0, 1.0));

        // Test for y == 1.5
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.0, 1.5));


    }
}