package de.goodyear.demo;

import de.goodyear.demo.client.ArrayClient;
import de.goodyear.demo.client.internal.ArrayClientImpl;
import de.goodyear.demo.collection.IntArrayFiller;
import de.goodyear.demo.collection.internal.decorator.IntArrayFillerBenchmarkDecorator;
import de.goodyear.demo.collection.internal.decorator.IntArrayLoggerDecorator;
import de.goodyear.demo.collection.internal.parallel.ArrayFillParallelImpl;
import de.goodyear.demo.collection.internal.sequentiell.ArrayFillerImpl;
import de.goodyear.demo.generator.IntGenerator;
import de.goodyear.demo.generator.IntGeneratorBuilder;
import de.goodyear.demo.generator.internal.GenericGeneratorImpl;
import de.goodyear.demo.generator.internal.RandomGeneratorBuilder;
import de.goodyear.demo.generator.internal.RandomNumberGeneratorImpl;
import de.goodyear.demo.time.internal.BenchmarkProxy;

public class Main {

    /*

    Task: Write a method populate(field) that should fill a given array with data (e.g., random numbers).
    This is the main part of the task.
    Additionally, I would like to know how long the filling takes depending on the number of background threads used.
    The output of the program should look something like this: Duration with one thread 10000 millis, Duration with 2 threads 5000, and so on.

    Please solve the task following the Contract First principle, meaning define the interfaces first.
     */





    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        for (int threadCount = 1; threadCount <= Runtime.getRuntime().availableProcessors() + 1 ; threadCount++) {
            startClient(threadCount);
        }


    }

    private static void startClient(final int threadCount) {

        System.out.println("\nCreate Array with " + threadCount + " Threads");


        IntArrayFiller arrayFiller = createArrayFiller(threadCount);


        ArrayClient client = new ArrayClientImpl(arrayFiller);
        client.go();
    }

    private static IntArrayFiller createArrayFiller(final int runningTasks) {


        IntGeneratorBuilder builder = new RandomGeneratorBuilder();
        //IntGenerator generator = new GenericGeneratorImpl(1,x->x+2);

        IntArrayFiller arrayFiller = runningTasks == 1? new ArrayFillerImpl(builder.create()):new ArrayFillParallelImpl(builder, runningTasks);

        // Decorators
        arrayFiller = new IntArrayLoggerDecorator(arrayFiller);
        arrayFiller = (IntArrayFiller) BenchmarkProxy.newInstance(arrayFiller);

        return arrayFiller;
    }
}