package com.egon.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Day1Test {
    @Nested
    class ReadInput {
        @Test
        void returnsListOfNumbers() throws IOException {
            ClassLoader classLoader = getClass().getClassLoader();
            var resource = Objects.requireNonNull(classLoader.getResource("input-day1.txt"));

            Integer[][] input = Day1.readInput(Paths.get(resource.getPath()));

            assertThat(input).isNotNull();
            assertThat(input[0]).isEqualTo(new Integer[] {1, 2, 3, 3, 3, 4});
            assertThat(input[1]).isEqualTo(new Integer[] {3, 3, 3, 4, 5, 9});
        }
    }

    @Nested
    class Answer1 {
        @Test
        void returnsCorrectResult() throws IOException {
            ClassLoader classLoader = getClass().getClassLoader();
            var resource = Objects.requireNonNull(classLoader.getResource("input-day1.txt"));

            var result = Day1.answer1(Paths.get(resource.getPath()));

            assertThat(result).isEqualTo(11);
        }
    }

    @Nested
    class Answer2 {
        @Test
        void returnsCorrectResult() throws IOException {
            ClassLoader classLoader = getClass().getClassLoader();
            var resource = Objects.requireNonNull(classLoader.getResource("input-day1.txt"));

            var result = Day1.answer2(Paths.get(resource.getPath()));

            assertThat(result).isEqualTo(31);
        }
    }
}
