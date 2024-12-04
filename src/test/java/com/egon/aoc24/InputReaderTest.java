package com.egon.aoc24;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.*;

public class InputReaderTest {
    // write a test for the readInput method
    // the method should return a list of strings or numbers depending on the file values
    // the file is located in src/main/resources/aoc24/input.txt

    @Test
    void returnsListOfStrings() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        var resource = Objects.requireNonNull(classLoader.getResource("inputs/strings.txt"));

        List<String> input = InputReader.readFileAsString(Paths.get(resource.getPath()));

        assertThat(input).isNotNull();
    }

    @Test
    void returnsListOfNumbers() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        var resource = Objects.requireNonNull(classLoader.getResource("inputs/numbers.txt"));

        List<Integer> input = InputReader.readFile(Paths.get(resource.getPath()), line -> {
            return Arrays.stream(line.trim().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }).stream().flatMap(List::stream).collect(Collectors.toList());

        assertThat(input).isNotNull();
        assertThat(input).isEqualTo(Arrays.asList(10, 20, 30, 40, 50, 60));
    }
}
