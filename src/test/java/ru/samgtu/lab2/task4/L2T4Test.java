package ru.samgtu.lab2.task4;

import org.junit.Test;

public class L2T4Test {

    @Test
    public void l2t4test() throws InterruptedException {
        LabBuffer buffer = new LabBuffer();
        Producer p = new Producer(buffer, "Производитель - " + 1);
        p.getThread().start();

        Consumer c = new Consumer(buffer, "Потребитель - " + 2);
        c.getThread().start();

        Thread.sleep(20000);
        p.getThread().interrupt();
        c.getThread().interrupt();
    }
}
