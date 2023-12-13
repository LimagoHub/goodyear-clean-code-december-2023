package de.goodyear.demo.generator.internal;

import de.goodyear.demo.generator.IntGenerator;
import de.goodyear.demo.generator.IntGeneratorBuilder;

public class RandomGeneratorBuilder implements IntGeneratorBuilder {
    @Override
    public IntGenerator create() {
        return new RandomNumberGeneratorImpl();
    }
}
