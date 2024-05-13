package ru.samgtu.lab2.task4;

import java.util.Random;

public class Producer implements Runnable {
    int sleepTime;
    int dataCount;
    LabBuffer buffer;
    Thread thread;

    public Producer(LabBuffer buf, String tName) {
        buffer = buf;
        Random rand = new Random();
        sleepTime = rand.nextInt(700) + 700;
        dataCount = rand.nextInt(4) + 8;
        thread = new Thread(this, tName);
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (int i = 0; i < dataCount; i++) {
                    buffer.putData(1);
                }
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
        }
    }
}