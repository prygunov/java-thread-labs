package ru.samgtu.lab2.task4;

import java.util.LinkedList;

public class LabBuffer {
    private final int maxSize = 200;
    private final LinkedList<Integer> buffer = new LinkedList<>();

    public void putData(int data){
        if(buffer.size() >= maxSize) {
            System.out.println("Еды нет");
            return;
        }

        buffer.add(data);
        System.out.println("Приготовил, всего еды " + buffer.size());
    }

    public void pullData(){
        if(buffer.isEmpty()){
            System.out.println("Отбой, еда кончилась");
            return;
        }
        buffer.removeLast();
        System.out.println("Скушал, всего еды " + buffer.size());
    }
}
