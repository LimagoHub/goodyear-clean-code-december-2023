package de.goodyear.demo;

import de.goodyear.demo.client.ArrayClient;
import de.goodyear.demo.client.internal.ArrayClientImpl;
import de.goodyear.demo.collection.IntArrayFiller;
import de.goodyear.demo.collection.internal.decorator.IntArrayFillerBenchmarkDecorator;
import de.goodyear.demo.collection.internal.decorator.IntArrayLoggerDecorator;
import de.goodyear.demo.collection.internal.sequentiell.ArrayFillerImpl;
import de.goodyear.demo.generator.IntGenerator;
import de.goodyear.demo.generator.internal.GenericGeneratorImpl;
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


        IntGenerator generator = new RandomNumberGeneratorImpl();
        //IntGenerator generator = new GenericGeneratorImpl(1,x->x+2);
        IntArrayFiller arrayFiller = new ArrayFillerImpl(generator);
        //arrayFiller = new IntArrayFillerBenchmarkDecorator(arrayFiller);
        arrayFiller = new IntArrayLoggerDecorator(arrayFiller);
        arrayFiller = (IntArrayFiller) BenchmarkProxy.newInstance(arrayFiller);
        ArrayClient client = new ArrayClientImpl(arrayFiller);
        client.go();

    }
}