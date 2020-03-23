package com.fizzbuzz.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class FizzBuzz {

    public static final String FIZZ = "fizz";
    public static final String BUZZ = "buzz";
    public static final String FIZZBUZZ = "fizzbuzz";
    public static final String POLO = "polo";

    public static void main(String[] args) {

        int start = 1;
        int end = 30;

        System.out.println("------------------------------------");
        System.out.println("-------------- Step 1 --------------");
        System.out.println("------------------------------------");
        fizzBuzzRange(start, end, 1);
        System.out.println("------------------------------------");

        System.out.println("------------------------------------");
        System.out.println("-------------- Step 2 --------------");
        System.out.println("------------------------------------");
        fizzBuzzRange(start, end, 2);
        System.out.println("------------------------------------");

        System.out.println("------------------------------------");
        System.out.println("-------------- Step 3 --------------");
        System.out.println("------------------------------------");
        fizzBuzzRange(start, end, 3);
        System.out.println("------------------------------------");

    }

    public static void fizzBuzzRange(int start, int end, int step) {

        ArrayList<String> values = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            values.add(checkFizzBuzz(i, step));
        }
        int index = 1;
        for (String result : values) {
            System.out.println(String.format("%s -> %s", index++, result));
        }
        if (step == 3) estatisticas(values);

    }

    public static String checkFizzBuzz(int number, int step) {

        if (step != 1 && String.valueOf(number).contains("6")) return POLO;

        switch (number % 15) {
            case 0:
                return FIZZBUZZ;
            case 3:
            case 6:
            case 9:
            case 12:
                return FIZZ;
            case 5:
            case 10:
                return BUZZ;
            default:
                return String.valueOf(number);
        }

    }

    private static void estatisticas(ArrayList<String> values) {
        System.out.println("------------------------------------");
        System.out.println("----------- Estatisticas -----------");
        System.out.println("------------------------------------");
        Map<String, Long> counts = values
                .stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        int count = 0;
        for (Map.Entry entry : counts.entrySet()) {
            if (isFizzBuzzPolo(entry)) {
                printEstatistica(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()), values.size());
            } else {
                count++;
            }
        }
        printEstatistica("int", String.valueOf(count), values.size());
    }

    private static void printEstatistica(String key, String value, int total) {
        double percent = (Long.valueOf(value).doubleValue() * 100) / total;
        System.out.println(String.format("%s - %s vezes, %.2f%%", key, value, percent));
    }

    private static boolean isFizzBuzzPolo(Map.Entry entry) {
        return entry.getKey().toString().contains(FIZZ) ||
                entry.getKey().toString().contains(BUZZ) ||
                entry.getKey().toString().contains(FIZZBUZZ) ||
                entry.getKey().toString().contains(POLO);
    }

}