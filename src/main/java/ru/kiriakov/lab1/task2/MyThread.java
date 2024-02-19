package ru.kiriakov.lab1.task2;

import java.util.Vector;
import java.util.function.Consumer;

public class MyThread extends Thread {

    private final Vector<Integer> vector;
    private final Consumer<Vector<Integer>> modifier;
    public MyThread(Vector<Integer> vector, Consumer<Vector<Integer>> modifier) {
        this.vector = vector;
        this.modifier = modifier;
    }

    @Override
    public void run() {
        modifier.accept(vector);
    }
}
