package ru.samgtu.lab1.task1;

import org.junit.Test;

public class ThreadsTest {

    @Test
    public void test() {
        MyThread t1 = new MyThread();
        t1.start();
        Thread t2 = new Thread(new MyRunnable());
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interruption was handled");
        }
    }
}