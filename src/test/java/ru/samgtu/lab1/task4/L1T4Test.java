package ru.samgtu.lab1.task4;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Vector;


class Incrementer implements Runnable {
    Vector<Integer> vector;

    public Incrementer(Vector<Integer> vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        synchronized (vector){
            vector.add(vector.get(vector.size() - 1) + 1);
            System.out.println(vector);
        }
    }
}

public class L1T4Test {

    @Test
    public void l1t4test() {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        LinkedList<Thread> threads = new LinkedList<>();
        for (int i = 0; i < 10; i++) threads.add(new Thread(new Incrementer(vector)));
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interruption was handled");
            }
        }
    }
}
