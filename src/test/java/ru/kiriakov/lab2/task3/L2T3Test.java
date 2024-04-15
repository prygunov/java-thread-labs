package ru.kiriakov.lab2.task3;

import org.junit.Test;

public class L2T3Test {

    @Test
    public void l2t3test() {
        ThreadPrinter printer = new ThreadPrinter("()");
        ThreadReader reader = new ThreadReader(printer);
        reader.start();
        printer.start();
        try {
            reader.join();
            printer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
