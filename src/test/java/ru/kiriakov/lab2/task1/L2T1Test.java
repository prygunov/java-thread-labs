package ru.kiriakov.lab2.task1;

import org.junit.Test;

public class L2T1Test {

    @Test
    public void l2t1test() {
        SharedNum num = new SharedNum();
        Thread incThread = new Thread(new Incrementor(num));
        Thread decThread = new Thread(new Decrementor(num));
        incThread.start();
        decThread.start();
        try {
            incThread.join();
            decThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interruption was handled");
        }
    }
}
