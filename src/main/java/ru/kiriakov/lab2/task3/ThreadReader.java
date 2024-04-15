package ru.kiriakov.lab2.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThreadReader extends Thread {
    ThreadPrinter printer;

    public ThreadReader(ThreadPrinter printer) {
        this.printer = printer;
    }

    @Override
    public synchronized void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/f/Code/IdeaProjects/java-thread-labs/src/main/java/ru/kiriakov/lab2/task3/ThreadPrinter.java"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                printer.queue.add(line);
                notifyAll();
            }
            printer.finished = true;
            notifyAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
