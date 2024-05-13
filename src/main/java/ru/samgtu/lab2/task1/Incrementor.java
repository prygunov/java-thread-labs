package ru.samgtu.lab2.task1;

public class Incrementor implements Runnable {
    private final SharedNum num;

    public Incrementor(SharedNum num) {
        this.num = num;
    }

    @Override
    public synchronized void run() {
        try {
            while(!num.finished) {
                while (!num.accessSwitch || num.val > 0) {
                    wait(100);
                }
                if (num.finished) break;
                while (num.val < 10) {
                    ++num.val;
                    System.out.println("++num -> " + num.val);
                }
                num.inc();
                num.accessSwitch = false;
                notifyAll();
            }
        } catch(InterruptedException ignored) {}
    }
}