package ru.samgtu.lab3.repository;

import ru.samgtu.lab3.ConsoleCrudMenu;
import ru.samgtu.lab3.template.DaoTemplate;

import java.util.Map;

public class TicketRepository extends DaoTemplate implements ConsoleCrudMenu {

    public TicketRepository() {
        super("tickets", "ticket_id", new String[]{"showtime_id", "seat_number", "price"}, "");
    }

    @Override
    public String getTitle() {
        return "Билеты";
    }

    @Override
    public void showAll() {
        getAll();
    }

    @Override
    public void edit() {
        System.out.print("Введите ID билета: ");
        int id = scanner.nextInt();
        System.out.print("Введите номер посадки: ");
        int seat = scanner.nextInt();
        System.out.print("Введите цену: ");
        int price = scanner.nextInt();

        edit(id, Map.of("seat_number", seat, "price", price));
    }

    @Override
    public void add() {
        System.out.print("Введите ID показа: ");
        int showId = scanner.nextInt();
        System.out.print("Введите номер посадки: ");
        int seat = scanner.nextInt();
        System.out.print("Введите цену: ");
        int price = scanner.nextInt();

        insert(showId, seat, price);
    }

    @Override
    public void delete() {
        System.out.print("Введите ID кинотеатра: ");
        int id = scanner.nextInt();
        delete(id);
    }

    @Override
    public void search() {
        System.out.println("Не поддерживается");
    }
}
