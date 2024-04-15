package ru.kiriakov.lab2.task4;

import java.util.LinkedList;

public class LabBuffer {
    private int maxSize = 200;
    private LinkedList<Integer> buffer = new LinkedList<>();
    public void PutData(int data){
        if(buffer.size() >= maxSize) {
            System.out.println("Тарелок не хватает");
            return;
        }

        buffer.add(data);
        System.out.println("Сделал сэндвич, кол-во -" + buffer.size());
    }
    public int PullData(){
        if(buffer.size() == 0){
            System.out.println("Отбой, сэндвичи кончились");
            return -1;
        }
        int temp = buffer.removeLast();
        System.out.println("Взял сэндвич, кол-во -" + buffer.size());
        return temp;
    }
}
