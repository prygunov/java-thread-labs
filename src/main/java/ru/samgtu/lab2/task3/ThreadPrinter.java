package ru.samgtu.lab2.task3;

import java.util.LinkedList;

public class ThreadPrinter extends Thread {
    public final LinkedList<String> queue = new LinkedList<>();
    public boolean finished = false;
    String pattern;

    public ThreadPrinter(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public synchronized void run() {
        synchronized (queue) {
            while (!finished || !queue.isEmpty()) {
                if (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                while (!queue.isEmpty()) {
                    String line = queue.pollFirst();
                    if (line.contains(pattern)) {
                        System.out.println(line);
                    }
                }
            }
        }
    }
}
