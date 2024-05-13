package ru.samgtu.lab3;

import ru.samgtu.lab3.repository.CinemaRepository;
import ru.samgtu.lab3.repository.HallRepository;
import ru.samgtu.lab3.repository.MovieRepository;
import ru.samgtu.lab3.repository.ShowtimeRepository;
import ru.samgtu.lab3.repository.TicketRepository;

import java.sql.Connection;
import java.util.Scanner;

public class CinemaConsoleApp {
    private static Scanner scanner = new Scanner(System.in);
    private static CinemaRepository cinemaRepository = new CinemaRepository();
    private static HallRepository hallRepository = new HallRepository();
    private static ShowtimeRepository showtimeRepository = new ShowtimeRepository();
    private static TicketRepository ticketRepository = new TicketRepository();
    private static MovieRepository movieRepository = new MovieRepository();

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Подключились к базе данных кинотеатров Самары!");
            boolean run = true;
            while (run) {
                System.out.println("Выберите нужный пункт:");

                System.out.println("1 - Кинотеатры");
                System.out.println("2 - Залы");
                System.out.println("3 - Фильмы");
                System.out.println("4 - Показы");
                System.out.println("5 - Билеты");
                System.out.println("-1 - Выход");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        cinemaRepository.enterMenu();
                        break;
                    case 2:
                        hallRepository.enterMenu();
                        break;
                    case 3:
                        movieRepository.enterMenu();
                        break;
                    case 4:
                        showtimeRepository.enterMenu();
                        break;
                    case 5:
                        ticketRepository.enterMenu();
                        break;
                    case -1:
                        run = false;
                        break;
                    default:
                        System.out.println("Неверный ввод. Попробуйте еще раз.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка " + e.getMessage());
        }
    }
}