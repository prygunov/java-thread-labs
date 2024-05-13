package ru.samgtu.lab3.repository;

import ru.samgtu.lab3.ConsoleCrudMenu;
import ru.samgtu.lab3.template.DaoTemplate;

import java.util.Map;

public class CinemaRepository extends DaoTemplate implements ConsoleCrudMenu {

    public CinemaRepository() {
        super("cinemas", "cinema_id", new String[]{"name", "location", "total_halls"}, "name");
    }

    @Override
    public String getTitle() {
        return "Кинотеатры";
    }

    @Override
    public void showAll() {
        getAll();
    }

    @Override
    public void edit() {
        System.out.print("Введите ID кинотеатра: ");
        int id = scanner.nextInt();
        System.out.print("Введите название кинотеатра: ");
        String name = scanner.next();
        System.out.print("Введите расположение кинотеатра: ");
        String location = scanner.next();
        System.out.print("Введите количество залов: ");
        int totalHalls = scanner.nextInt();

        edit(id, Map.of("name", name, "location", location, "total_halls", totalHalls));
    }

    @Override
    public void add() {
        System.out.print("Введите название кинотеатра: ");
        String name = scanner.next();
        System.out.print("Введите расположение кинотеатра: ");
        String location = scanner.next();
        System.out.print("Введите количество залов: ");
        int totalHalls = scanner.nextInt();

        insert(name, location, totalHalls);
    }

    @Override
    public void delete() {
        System.out.print("Введите ID кинотеатра: ");
        int id = scanner.nextInt();
        delete(id);
    }

    @Override
    public void search() {
        System.out.print("Введите название кинотеатра: ");
        String name = scanner.next();
        findBy(name);
    }
}
