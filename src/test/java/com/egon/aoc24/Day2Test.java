package com.egon.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Day2Test {
    @Nested
    class ReadInput {
        @Test
        void returnsListOfNumbers() throws IOException {
            ClassLoader classLoader = getClass().getClassLoader();
            var resource = Objects.requireNonNull(classLoader.getResource("input-day2.txt"));

            ArrayList<Integer[]> input = Day2.readInput(Paths.get(resource.getPath()));

            ArrayList<Integer[]> expected = new ArrayList<>();
            expected.add(new Integer[] {7, 6, 4, 2, 1});
            expected.add(new Integer[] {1, 2, 7, 8, 9});
            expected.add(new Integer[] {9, 7, 6, 2, 1});
            expected.add(new Integer[] {1, 3, 2, 4, 5});
            expected.add(new Integer[] {8, 6, 4, 4, 1});
            expected.add(new Integer[] {1, 3, 6, 7, 9});

            for (var report : input) {
                assertThat(report)
                        .isEqualTo(expected.get(input.indexOf(report)));
            }
        }
    }

    @Nested
    class Answer1 {
        @Test
        void returnsCorrectResult() throws IOException {
            ClassLoader classLoader = getClass().getClassLoader();
            var resource = Objects.requireNonNull(classLoader.getResource("input-day2.txt"));

            var result = Day2.answer1(Paths.get(resource.getPath()));

            assertThat(result).isEqualTo(2);
        }
    }

    @Nested
    class Answer2 {
        @Test
        void returnsCorrectResult() throws IOException {
            ClassLoader classLoader = getClass().getClassLoader();
            var resource = Objects.requireNonNull(classLoader.getResource("input-day2.txt"));

            var result = Day2.answer2(Paths.get(resource.getPath()));

            assertThat(result).isEqualTo(4);
        }
    }
}
