package com.example.exercises;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

/**
 *
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 */
public class Lambda2 {

    public static void main(String[] args) {
        int lost[] = {42, 23, 16, 15, 8, 4};
        IntStream.of(lost).sorted().forEach(System.out::println);
        OptionalDouble average = IntStream.of(lost).average();
        average.ifPresent(System.out::println);
        System.out.println("Sum: " + IntStream.of(lost).sum());
    }
}
