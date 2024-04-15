package ru.kiriakov.lab2.task4;

import org.junit.Test;
import java.util.Scanner;

public class L2T4Test {

    @Test
    public void l2t4test() {
        LabBuffer buffer = new LabBuffer();
        int pCounter = 0;
        int cCounter = 0;

        Producer p = new Producer(buffer,"Произв - "+ pCounter);
        p.GetThread().start();
        pCounter++;

        Consumer c = new Consumer(buffer,"Потреб - "+ cCounter);
        c.GetThread().start();
        cCounter++;

        try {
            p.GetThread().join();
            c.GetThread().join();
        } catch (InterruptedException e) {
            System.out.println("Thread interruption was handled");
        }
    }
}
