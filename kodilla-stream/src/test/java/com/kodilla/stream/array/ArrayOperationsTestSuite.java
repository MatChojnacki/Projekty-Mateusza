package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;

import static org.testng.Assert.assertEquals;

public class ArrayOperationsTestSuite {
@Test
    public void testGetAverage() {

        // Given
        int[] testArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        //When
        double average = ArrayOperations.getAverage(testArray).getAsDouble();

        //Then
        assertEquals( average, 9.5, 0.1);


    }
}
