package ru.samgtu.lab3;

import java.util.Scanner;

public interface ConsoleCrudMenu {

    String getTitle();

    default void enterMenu(){
        Scanner scanner = new Scanner(System.in);
        do {
            showMenu();
        } while (choose(scanner.nextInt()));
    }

    default void showMenu(){
        System.out.println(" - " + getTitle() + " - ");
        System.out.println("Выберите действие:");
        System.out.println("""
                1 - Показать все
                2 - Добавить запись
                3 - Изменить запись
                4 - Удалить запись
                5 - Поиск
                -1 - Назад
                """);
    };

    default boolean choose(int choice){
        switch (choice){
            case 1 -> showAll();
            case 2 -> add();
            case 3 -> edit();
            case 4 -> delete();
            case 5 -> search();

            default -> {
                return false;
            }
        }
        return true;
    }

    void showAll();
    void edit();
    void add();
    void delete();
    void search();

}
