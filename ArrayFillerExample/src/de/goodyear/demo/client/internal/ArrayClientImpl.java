package de.goodyear.demo.client.internal;

import de.goodyear.demo.client.ArrayClient;

public class ArrayClientImpl implements ArrayClient {


    private int field[] = new int[Integer.MAX_VALUE / 2];


    @Override
    public void go() {
        System.out.println("Do some stuff with big array");
    }
}
