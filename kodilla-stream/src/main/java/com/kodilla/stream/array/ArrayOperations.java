package com.kodilla.stream.array;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        IntStream.of(numbers)
                .forEach(System.out::println);

        OptionalDouble average = IntStream.of(numbers)
                .average();

        return average.getAsDouble();
    };
}
