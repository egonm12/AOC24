package com.egon.aoc24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InputReader {
    /**
     * Reads a file and maps each line to a desired type.
     *
     * @param path   the path to the file
     * @param mapper a function to convert String to T
     * @param <T>    the type of the list elements
     * @return a list of mapped elements
     * @throws IOException if an I/O error occurs reading from the file
     */
    public static <T> List<T> readFile(Path path, Function<String, T> mapper) throws IOException {
        List<String> lines = Files.readAllLines(path);

        // read all lines, and per line apply the mapper function to each individual value in a line (space separated)
        return lines.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    /**
     * Reads a file and returns the lines as a list of Strings.
     *
     * @param path the path to the file
     * @return a list of Strings representing each line
     * @throws IOException if an I/O error occurs reading from the file
     */
    public static List<String> readFileAsString(Path path) throws IOException {
        return readFile(path, Function.identity());
    }
}
