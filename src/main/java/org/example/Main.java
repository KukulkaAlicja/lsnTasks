package org.example;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> inputsChangedToInt = new ArrayList<>();
        List<Integer> sortedList;

        System.out.println("Task 1");
        System.out.println("Please enter input numbers separated by comma");
        String inputData = scanner.nextLine();
        String[] singleInputs = inputData.split(",");

        changeInputOfStringToInt(singleInputs, inputsChangedToInt);

        sortedList = inputsChangedToInt.stream().sorted().collect(Collectors.toList());
        int distinctCount = sortedList.size();
        Integer minValue = sortedList.isEmpty() ? null : sortedList.get(0);
        Integer maxValue = sortedList.isEmpty() ? null : sortedList.get(sortedList.size() - 1);

        System.out.println(sortedList);
        System.out.println("count:" + distinctCount);
        System.out.println("distinct:" + sortedList.stream().distinct().count());
        System.out.println("min:" + minValue);
        System.out.println("max:" + maxValue);
        scanner.close();
    }

    private static void changeInputOfStringToInt(String[] singleInputs, List<Integer> inputsChangedToInt) {
        for (String singleInput : singleInputs) {
            try {
                inputsChangedToInt.add(Integer.parseInt(singleInput));
            } catch (NumberFormatException e) {
                System.out.println("Incorrect value: " + "'" + singleInput + "'" + " Couldn't be parse to an integer");
            }
        }
    }
}