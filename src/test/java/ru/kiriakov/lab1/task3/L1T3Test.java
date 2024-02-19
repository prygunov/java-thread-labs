package ru.kiriakov.lab1.task3;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class L1T3Test {

    @Test
    public void l1t3test() {
        AccessController accessController = new AccessController();
        accessController.accessState = AccessType.WRITE;
        Reader reader = new Reader(accessController);
        Writer writer = new Writer(accessController);
        List<Thread> threads = new LinkedList<>();
        for (int i = 0; i < 10; i++) threads.add(new Thread(reader));
        for (int i = 0; i < 10; i++) threads.add(new Thread(writer));
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
