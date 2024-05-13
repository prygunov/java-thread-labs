package ru.samgtu.lab2.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class ThreadReader extends Thread {
    ThreadPrinter printer;

    public ThreadReader(ThreadPrinter printer) {
        this.printer = printer;
    }

    @Override
    public synchronized void run() {
        var path = Paths.get(System.getProperty("user.dir"), "/src/main/java/ru/kiriakov/lab2/task3/ThreadPrinter.java").toFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            synchronized (printer.queue) {
                String line;
                while ((line = reader.readLine()) != null) {
                    printer.queue.add(line);
                }
                printer.finished = true;
                printer.queue.notifyAll();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
