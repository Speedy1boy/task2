package task;

import java.util.Arrays;

public class Task1 {
    public static void solve(int n) {
        var randomNumbers = getRandomNumbers(n, -100, 100);
        System.out.println(Arrays.toString(randomNumbers));
        System.out.println(getSumPositive(randomNumbers));
    }

    private static int[] getRandomNumbers(int n, int min, int max) {
        var randomNumbers = new int[n];
        for (var i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = (int)(Math.random() * (max - min + 1) + min);
        }
        return randomNumbers;
    }

    private static long getSumPositive(int[] numbers) {
        var sum = 0L;
        for (var number : numbers) {
            if (number > 0) {
                sum += number;
            }
        }
        return sum;
    }
}