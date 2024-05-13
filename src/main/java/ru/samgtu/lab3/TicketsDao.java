package ru.samgtu.lab3;

public class TicketsDao {

    public void addTicket(int showtimeId, int seatNumber, double price, boolean isSold) {
        String sql = "INSERT INTO Tickets (showtime_id, seat_number, price, is_sold) VALUES (?, ?, ?, ?)";
        // Следует реализовать аналогично методу addCinema.
    }

    public void getTickets() {
        String sql = "SELECT * FROM Tickets";
        // Следует реализовать аналогично методу getCinemas.
    }
    
    // методы updateTicket и deleteTicket

}