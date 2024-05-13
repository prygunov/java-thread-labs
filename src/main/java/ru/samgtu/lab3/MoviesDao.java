package ru.samgtu.lab3;

public class MoviesDao {

    public void addMovie(String title, int duration, String rating, String genre) {
        String sql = "INSERT INTO Movies (title, duration, rating, genre) VALUES (?, ?, ?, ?)";
        // Следует реализовать аналогично методу addCinema.
    }

    public void getMovies() {
        String sql = "SELECT * FROM Movies";
        // Следует реализовать аналогично методу getCinemas.
    }
    
    // методы updateMovie и deleteMovie

}