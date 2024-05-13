package ru.samgtu.lab3.repository;

import ru.samgtu.lab3.ConsoleCrudMenu;
import ru.samgtu.lab3.template.DaoTemplate;

import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ShowtimeRepository extends DaoTemplate implements ConsoleCrudMenu {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu.MM.dd HH:mm");

    public ShowtimeRepository() {
        super("showtimes", "showtime_id", new String[]{"movie_id", "hall_id", "start_time", "end_time"}, "");
    }

    @Override
    public String getTitle() {
        return "Сеансы";
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
        System.out.print("Введите ID фильма: ");
        String filmId = scanner.next();
        System.out.print("Введите ID зала: ");
        int hallId = scanner.nextInt();
        System.out.print("Введите время начала: ");
        int totalSeats = scanner.nextInt();

        insert(hallId, filmId, totalSeats);
    }

    @Override
    public void delete() {
        System.out.print("Введите ID сеанса: ");
        int id = scanner.nextInt();
        delete(id);
    }

    @Override
    public void search() {
        System.out.println("Не поддерживается");
    }
}
