package ru.samgtu.lab2.task2;

public class LocalCountingThread extends Thread {
    public int i = 0;
    public final String name;

    public LocalCountingThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (i < 20) {
            synchronized (Lock.getLock()) {
                System.out.println(name + " -> " + ++i);
            }
        }
    }
}
