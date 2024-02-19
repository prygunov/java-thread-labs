package ru.kiriakov.lab1.task3;

public class Reader implements Runnable {
    private final AccessController accessController;

    public Reader(AccessController accessController) {
        this.accessController = accessController;
    }

    @Override
    public synchronized void run() {
        while (accessController.accessState != AccessType.READ) {
            try {
                wait();
                // System.out.println("Reader woke up");
            } catch (InterruptedException e) {
                System.out.println("Thread interruption was handled");
            }
        }
        System.out.println("Read");
        accessController.accessState = AccessType.WRITE;
        notifyAll();
    }
}
