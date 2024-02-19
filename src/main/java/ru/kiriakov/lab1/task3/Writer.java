package ru.kiriakov.lab1.task3;

public class Writer implements Runnable {
    private final AccessController accessController;

    public Writer(AccessController accessController) {
        this.accessController = accessController;
    }

    @Override
    public synchronized void run() {
        while (accessController.accessState != AccessType.WRITE) {
            try {
                wait(10);
            } catch (InterruptedException e) {
                System.out.println("Thread interruption was handled");
            }
        }
        System.out.println("Write");
        accessController.accessState = AccessType.READ;
        notifyAll();
    }
}
