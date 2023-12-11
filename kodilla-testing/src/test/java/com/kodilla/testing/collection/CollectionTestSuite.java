package com.kodilla.testing.collection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionTestSuite {

    private OddNumbersExterminator exterminator;

    @DisplayName("Tests for OddNumbersExterminator class")

        @BeforeEach
        public void setUp() {
            exterminator = new OddNumbersExterminator();
            System.out.println("Preparing to execute test...");
        }

        @AfterEach
        public void tearDown() {
            exterminator = null;
            System.out.println("Test finished.");
        }

        @DisplayName("Testing when the list is empty")
        @Test
        public void testOddNumbersExterminatorEmptyList() {
            // Given
            List<Integer> emptyList = Arrays.asList();

            // When
            List<Integer> result = exterminator.exterminate(emptyList);

            // Then
            assertEquals(0, result.size(), "The list should be empty");
        }


        @DisplayName("Testing when the list contains both odd and even numbers")
        @Test
        public void testOddNumbersExterminatorNormalList() {
            // Given
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

            // When
            List<Integer> result = exterminator.exterminate(numbers);

            // Then
            assertEquals(Arrays.asList(2, 4, 6, 8, 10), result, "The list should contain only even numbers");
        }
    }

