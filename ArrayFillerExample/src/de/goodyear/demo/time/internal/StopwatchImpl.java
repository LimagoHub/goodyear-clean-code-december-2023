package de.goodyear.demo.time.internal;

import de.goodyear.demo.time.Stopwatch;

import java.time.Duration;
import java.time.Instant;

public class StopwatchImpl implements Stopwatch {

    private Instant start, end;
    @Override
    public void start() {
        start = Instant.now();
    }

    @Override
    public void stop() {
        end = Instant.now();
    }

    @Override
    public Duration elapsedTime() {
        return Duration.between(start, end);
    }
}
