package ru.samgtu.lab3;

import java.sql.Timestamp;

public class ShowtimesDao {

    public void addShowtime(int movieId, int hallId, Timestamp startTime, Timestamp endTime) {
        String sql = "INSERT INTO Showtimes (movie_id, hall_id, start_time, end_time) VALUES (?, ?, ?, ?)";
        // Следует реализовать аналогично методу addCinema.
    }

    public void getShowtimes() {
        String sql = "SELECT * FROM Showtimes";
        // Следует реализовать аналогично методу getCinemas.
    }
    
    // методы updateShowtime и deleteShowtime

}