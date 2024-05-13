package ru.samgtu.lab2.task1;

public class Decrementor implements Runnable {
    private final SharedNum num;

    public Decrementor(SharedNum num) {
        this.num = num;
    }

    @Override
    public synchronized void run() {
        try {
            while(!num.finished) {
                while (num.accessSwitch || num.val < 10) {
                    wait(100);
                }
                if (num.finished) break;
                while (num.val > 0) {
                    --num.val;
                    System.out.println("--num -> " + num.val);
                }
                num.inc();
                num.accessSwitch = true;
                notifyAll();
            }
        } catch(InterruptedException ignored) {}
    }
}