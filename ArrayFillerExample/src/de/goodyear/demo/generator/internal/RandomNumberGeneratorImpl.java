package de.goodyear.demo.generator.internal;

import de.goodyear.demo.generator.IntGenerator;

import java.util.Random;

public class RandomNumberGeneratorImpl implements IntGenerator {

    private final Random random = new Random();
    @Override
    public int next() {
        return random.nextInt();
    }
}
