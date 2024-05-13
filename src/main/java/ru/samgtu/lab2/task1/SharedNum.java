package ru.samgtu.lab2.task1;

public class SharedNum {
    public boolean accessSwitch = true;
    public int val = 0;
    public boolean finished;
    private int index = 0;

    public void inc() {
        ++index;
        finished = index >= 10;
        System.out.println("\n  < " + index + " > \n");
    }
}