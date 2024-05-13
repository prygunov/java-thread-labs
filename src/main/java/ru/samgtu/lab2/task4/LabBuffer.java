package ru.samgtu.lab2.task4;

import java.util.LinkedList;

public class LabBuffer {
    private final int maxSize = 200;
    private final LinkedList<Integer> buffer = new LinkedList<>();

    public void putData(int data){
        if(buffer.size() >= maxSize) {
            System.out.println("Тарелок не хватает");
            return;
        }

        buffer.add(data);
        System.out.println("Сделал сэндвич, всего " + buffer.size());
    }

    public void pullData(){
        if(buffer.isEmpty()){
            System.out.println("Отбой, сэндвичи кончились");
            return;
        }
        buffer.removeLast();
        System.out.println("Взял сэндвич, всего " + buffer.size());
    }
}
