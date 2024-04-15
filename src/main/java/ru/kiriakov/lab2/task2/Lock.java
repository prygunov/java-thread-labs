package ru.kiriakov.lab2.task2;

public class Lock {
    static Lock lock;

    private Lock() {}

    public static Lock getLock() {
        if (lock == null) {
            lock = new Lock();
        }
        return lock;
    }
}
