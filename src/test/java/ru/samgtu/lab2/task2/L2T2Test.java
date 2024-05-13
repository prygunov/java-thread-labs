package ru.samgtu.lab2.task2;

import org.junit.Test;

public class L2T2Test {

    @Test
    public void l2t2LocalTest() {
        System.out.println("\nLocalCountingThread:");
        LocalCountingThread thread1 = new LocalCountingThread("Thread 1");
        LocalCountingThread thread2 = new LocalCountingThread("Thread 2");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interruption was handled");
        }
    }

    @Test
    public void l2t2SharedTest() {
        System.out.println("\nSharedCountingThread:");
        SharedCountingThread thread1 = new SharedCountingThread("Thread 1");
        SharedCountingThread thread2 = new SharedCountingThread("Thread 2");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interruption was handled");
        }
    }
}
