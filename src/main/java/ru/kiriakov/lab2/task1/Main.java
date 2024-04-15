package ru.kiriakov.lab2.task1;

public class Main {
    SharedNum num = new SharedNum();
    Incrementor incrementor = new Incrementor(num);
    Decrementor decrementor = new Decrementor(num);
}
