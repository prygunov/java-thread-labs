package ru.samgtu.lab3;

public class HallsDao {

    public void addHall(int cinemaId, int hallNumber, int seatCapacity) {
        String sql = "INSERT INTO Halls (cinema_id, hall_number, seat_capacity) VALUES (?, ?, ?)";
        // Следует реализовать аналогично методу addCinema.
    }

    public void getHalls() {
        String sql = "SELECT * FROM Halls";
        // Следует реализовать аналогично методу getCinemas.
    }
    
    // методы updateHall и deleteHall

}