package ru.kiriakov.lab1.task2;

import org.junit.Test;

import java.util.Collections;
import java.util.Vector;

public class L1T2Test {

    @Test
    public void l1t2test() {
        Vector<Integer> vector = new Vector<>();
        vector.setSize(10);
        Collections.fill(vector, 0);
        MyThread writer = new MyThread(vector, (v) -> {
            for (int i = 0; i < v.size(); i++) {
                v.set(i, 1);
                System.out.printf("Write: v[%d] <- 1%n", i);
            }
        });
        MyThread reader = new MyThread(vector, (v) -> {
            for (int i = 0; i < v.size(); i++) {
                System.out.printf("Read:  v[%d] -> %d%n", i, v.get(i));
            }
        });
        writer.setPriority(Thread.MAX_PRIORITY);
        reader.setPriority(Thread.MIN_PRIORITY);
        reader.start();
        writer.start();
        try {
            writer.join();
            reader.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interruption was handled");
        }
    }
}
