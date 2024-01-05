package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {
    static OptionalDouble getAverage(int[] numbers) {

        IntStream.range(0, numbers.length)
                .forEach(i -> System.out.println(numbers[i]));

            return IntStream.range(0, numbers.length)
                .average();

    }
}
