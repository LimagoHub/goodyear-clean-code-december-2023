package de.goodyear;

public class CalculatorLogger implements Calculator{

    private final Calculator calculator;

    public CalculatorLogger(final Calculator calculator) {
        this.calculator = calculator;
    }

    public double add(final double a, final double b) {
        System.out.println("Add was called");
        return calculator.add(a, b);
    }
}
