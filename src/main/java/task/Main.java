package task;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("\nЗадание 1:");
        Task1.solve(10);

        System.out.println("\nЗадание 2:");
        Task2.solve(10);

        System.out.println("\nЗадание 3:");
        Task3.solve();

        System.out.println("\nЗадание 4:");
        Task4.solve();

        System.out.println("\nЗадание 5:");
        Task5.solve();
    }
}