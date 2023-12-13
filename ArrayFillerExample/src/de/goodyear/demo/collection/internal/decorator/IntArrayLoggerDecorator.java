package de.goodyear.demo.collection.internal.decorator;

import de.goodyear.demo.collection.IntArrayFiller;

public class IntArrayLoggerDecorator implements IntArrayFiller{

    private final IntArrayFiller arrayFiller;

    public IntArrayLoggerDecorator(final IntArrayFiller arrayFiller) {
        this.arrayFiller = arrayFiller;
    }

    public void fillArray(final int[] data) {
        System.out.println("Fillarray wa called...");
        arrayFiller.fillArray(data);
    }
}
