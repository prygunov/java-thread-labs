package ru.samgtu.lab3.repository;

import ru.samgtu.lab3.ConsoleCrudMenu;
import ru.samgtu.lab3.template.DaoTemplate;

import java.util.Map;

public class HallRepository extends DaoTemplate implements ConsoleCrudMenu {

    public HallRepository() {
        super("halls", "hall_id", new String[]{"cinema_id", "hall_number", "seat_capacity"}, "");
    }

    @Override
    public String getTitle() {
        return "Залы";
    }

    @Override
    public void showAll() {
        getAll();
    }

    @Override
    public void edit() {
        System.out.print("Введите ID зала: ");
        int id = scanner.nextInt();
        System.out.print("Введите номер зала: ");
        int number = scanner.nextInt();
        System.out.print("Введите количество мест: ");
        int totalCap = scanner.nextInt();

        edit(id, Map.of("hall_number", number, "seat_capacity", totalCap));
    }

    @Override
    public void add() {
        System.out.print("Введите ID кинотеатра: ");
        int id = scanner.nextInt();
        System.out.print("Введите номер зала: ");
        int number = scanner.nextInt();
        System.out.print("Введите количество мест: ");
        int totalSeats = scanner.nextInt();

        insert(id, number, totalSeats);
    }

    @Override
    public void delete() {
        System.out.print("Введите ID зала: ");
        int id = scanner.nextInt();
        delete(id);
    }

    @Override
    public void search() {
        System.out.println("Не поддерживается");
    }
}
