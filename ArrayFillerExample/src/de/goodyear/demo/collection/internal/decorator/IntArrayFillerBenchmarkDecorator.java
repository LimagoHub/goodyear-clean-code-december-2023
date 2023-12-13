package de.goodyear.demo.collection.internal.decorator;

import de.goodyear.demo.collection.IntArrayFiller;
import de.goodyear.demo.time.Stopwatch;
import de.goodyear.demo.time.internal.StopwatchImpl;

public class IntArrayFillerBenchmarkDecorator implements IntArrayFiller{

    private final Stopwatch stopwatch = new StopwatchImpl();
    private final IntArrayFiller arrayFiller;

    public IntArrayFillerBenchmarkDecorator(final IntArrayFiller arrayFiller) {
        this.arrayFiller = arrayFiller;
    }

    public void fillArray(final int[] data) {
        stopwatch.start();
        arrayFiller.fillArray(data);
        stopwatch.stop();
        System.out.println(stopwatch.elapsedTime().toMillis());
    }
}
