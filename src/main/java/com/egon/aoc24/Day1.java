package com.egon.aoc24;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Day1 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/input-day1.txt");
        System.out.println("Answer 1: " + answer1(path));
        System.out.println("Answer 2: " + answer2(path));
    }

    public static Integer answer1(Path path) throws IOException {
        var result = readInput(path);

        int sum = 0;

        for (int i = 0; i < result[0].length; i++) {
            sum += Math.abs(result[0][i] - result[1][i]);
        }

        return sum;

    }

    public static Integer answer2(Path path) throws IOException {
        var result = readInput(path);

        int sum = 0;

        for (int i = 0; i < result[0].length; i++) {
            int finalI = i;
            int count = (int) Arrays.stream(result[1]).filter(x -> Objects.equals(x, result[0][finalI])).count() * result[0][i];

            sum += count;
        }

        return sum;
    }

    public static Integer[][] readInput(Path path) throws IOException {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        InputReader.readFile(path, line -> {
            String[] split = line.split("\\s+");
            firstList.add(Integer.valueOf(split[0]));
            secondList.add(Integer.valueOf(split[1]));
            return null;
        });

        Collections.sort(firstList);
        Collections.sort(secondList);

        return new Integer[][] {
                firstList.toArray(Integer[]::new),
                secondList.toArray(Integer[]::new)
        };
    }
}
