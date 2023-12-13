package de.goodyear.demo.client.internal;

import de.goodyear.demo.client.ArrayClient;
import de.goodyear.demo.collection.IntArrayFiller;

public class ArrayClientImpl implements ArrayClient {


    private int field[] = new int[Integer.MAX_VALUE / 2];

    private final IntArrayFiller arrayFiller;

    public ArrayClientImpl(final IntArrayFiller arrayFiller) {
        this.arrayFiller = arrayFiller;
    }

    @Override
    public void go() {
        //System.out.println("Showing first 10 values of Array");
        arrayFiller.fillArray(field);

//        for (int i = 0; i < 10; i++) {
//            System.out.println(field[i]);
//        }
    }
}
