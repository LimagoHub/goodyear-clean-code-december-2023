package de.goodyear.demo.collection.internal.sequentiell;

import de.goodyear.demo.collection.IntArrayFiller;
import de.goodyear.demo.generator.IntGenerator;

public class ArrayFillerImpl implements IntArrayFiller {

    private final IntGenerator generator;

    public ArrayFillerImpl(final IntGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void fillArray(final int[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = generator.next();
        }
    }
}
