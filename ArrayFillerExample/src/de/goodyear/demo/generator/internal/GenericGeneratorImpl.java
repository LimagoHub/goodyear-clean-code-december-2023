package de.goodyear.demo.generator.internal;

import de.goodyear.demo.generator.IntGenerator;

import java.util.function.Function;

public class GenericGeneratorImpl implements IntGenerator {

    private final Function<Integer, Integer> function;
    private int currentValue;
    public GenericGeneratorImpl(int seed,final Function<Integer, Integer> function) {
        this.function = function;
        currentValue = seed;
    }

    @Override
    public int next() {
        int result = currentValue;
        currentValue = function.apply(currentValue);
        return result;
    }
}
