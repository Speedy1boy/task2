package task;

import java.util.ArrayList;

public class Task2 {
    public static void solve(int n) {
        var randomNumbers = getRandomNumbers(n);
        System.out.println(randomNumbers);
        insertionSort(randomNumbers, n);
        System.out.println(randomNumbers);
    }

    private static ArrayList<Double> getRandomNumbers(int n) {
        var randomNumbers = new ArrayList<Double>(n);
        for (var i = 0; i < n; i++) {
            randomNumbers.add(Math.random());
        }
        return randomNumbers;
    }

    private static void insertionSort(ArrayList<Double> numbers, int n) {
        for (var i = 1; i < n; i++) {
            var key = numbers.get(i);
            var j = i - 1;
            while (j >= 0 && numbers.get(j) > key) {
                numbers.set(j + 1, numbers.get(j));
                j--;
            }
            numbers.set(j + 1, key);
        }
    }
}