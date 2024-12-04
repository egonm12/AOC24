package com.egon.aoc24;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Day2 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/input-day2.txt");
        System.out.println("Answer 1: " + answer1(path));
        System.out.println("Answer 2: " + answer2(path));
    }

    public static Integer answer1(Path path) throws IOException {
        var result = readInput(path);

        int safe = 0;

        for (Integer[] report : result) {
            if (isSafeReport(report)) {
                safe++;
            }
        }

        return safe;
    }

    public static Integer answer2(Path path) throws IOException {
        var result = readInput(path);

        int safe = 0;

        for (Integer[] report : result) {
            var safeReport = isSafeReport(report);

            if (!safeReport) {
                for (int i = 0; i < report.length; i++) {
                    Integer[] newReport = new Integer[report.length - 1];
                    int index = 0;
                    for (int j = 0; j < report.length; j++) {
                        if (j != i) {
                            newReport[index] = report[j];
                            index++;
                        }
                    }

                    if (isSafeReport(newReport)) {
                        safeReport = true;
                        break;
                    }
                }
            }



            if (safeReport) {
                safe++;
            }
        }

        return safe;
    }

    public static ArrayList<Integer[]> readInput(Path path) throws IOException {

        var result = new ArrayList<Integer[]>();

        InputReader.readFile(path, line -> {
            String[] split = line.split("\\s+");

            Integer[] report = Arrays.stream(split).map(Integer::valueOf).toArray(Integer[]::new);

            result.add(report);

            return null;
        });

        return result;
    }

    private static boolean isSafeReport(Integer[] report) {
        boolean safeReport = true;

        for (int i = 0; i < report.length - 1; i++) {
            int diff = Math.abs(report[i + 1] - report[i]);

            if (diff < 1 || diff > 3) {
                safeReport = false;
                break;
            }

            boolean increasing = report[i + 1] > report[i];
            boolean decreasing = !increasing;

            if (i > 0) {
                boolean prevIncreasing = report[i] > report[i - 1];
                boolean prevDecreasing = !prevIncreasing;

                if ((prevDecreasing && increasing) || (prevIncreasing && decreasing)) {
                    safeReport = false;
                    break;
                }
            }
        }

        return safeReport;
    }
}
