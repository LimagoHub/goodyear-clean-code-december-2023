package de.goodyear.demo;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {

    /*

    Task: Write a method populate(field) that should fill a given array with data (e.g., random numbers).
    This is the main part of the task.
    Additionally, I would like to know how long the filling takes depending on the number of background threads used.
    The output of the program should look something like this: Duration with one thread 10000 millis, Duration with 2 threads 5000, and so on.

    Please solve the task following the Contract First principle, meaning define the interfaces first.
     */

    private int field[] = new int[Integer.MAX_VALUE / 2];



    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {



        // 1 to availableProcessors + 1
        final var availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);

        final Random random = new Random();
        var start = Instant.now();
        for (int i = 0; i < field.length; i++) {
            field[i] = random.nextInt();
        }
        var end = Instant.now();
        var duration = Duration.between(start, end);
        System.out.printf("Duration is %s millis\n", duration.toMillis());


    }
}