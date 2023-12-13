package de.goodyear.demo.io.internal;

import de.goodyear.demo.io.Writer;

public class ConsoleWriter implements Writer {
    @Override
    public void write(final String message) {
        System.out.println(message);
    }
}
