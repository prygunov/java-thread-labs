package ru.samgtu.lab3.repository;

import ru.samgtu.lab3.ConsoleCrudMenu;
import ru.samgtu.lab3.template.DaoTemplate;

import java.util.Map;

public class MovieRepository extends DaoTemplate implements ConsoleCrudMenu {

    public MovieRepository() {
        super("movies", "movie_id", new String[]{"title", "duration", "rating", "genre"}, "title");
    }

    @Override
    public String getTitle() {
        return "Фильмы";
    }

    @Override
    public void showAll() {
        getAll();
    }

    @Override
    public void edit() {
        System.out.print("Введите ID фильма: ");
        int id = scanner.nextInt();

        System.out.print("Введите название: ");
        String name = scanner.next();
        System.out.print("Введите длительность: ");
        int duration = scanner.nextInt();
        System.out.print("Введите рейтинг: ");
        String rating = scanner.next();
        System.out.print("Введите жанр: ");
        String genre = scanner.next();

        edit(id, Map.of("name", name, "duration", duration, "rating", rating, "genre", genre));
    }

    @Override
    public void add() {
        System.out.print("Введите название: ");
        String name = scanner.next();
        System.out.print("Введите длительность: ");
        int duration = scanner.nextInt();
        System.out.print("Введите рейтинг: ");
        String rating = scanner.next();
        System.out.print("Введите жанр: ");
        String genre = scanner.next();

        insert(name, duration, rating, genre);
    }

    @Override
    public void delete() {
        System.out.print("Введите ID фильма: ");
        int id = scanner.nextInt();
        delete(id);
    }

    @Override
    public void search() {
        System.out.print("Введите название для поиска: ");
        String name = scanner.next();
        findBy(name);
    }
}
