package de.goodyear.io;

public class ConsoleWriter implements Writer{
    @Override
    public void write(final String message) {
        System.out.println(message);
    }
}
