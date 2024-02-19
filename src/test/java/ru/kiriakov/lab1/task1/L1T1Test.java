package ru.kiriakov.lab1.task1;

import org.junit.Before;
import org.junit.Test;

public class L1T1Test {

    @Before
    public void setUp() {
    }

    @Test
    public void l1t1test() {
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