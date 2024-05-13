package ru.samgtu.lab2.task2;

public class SharedCountingThread extends Thread {
    private static int i = 0;
    private final String name;

    public SharedCountingThread(String name) {
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
