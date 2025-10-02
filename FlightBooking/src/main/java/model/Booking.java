package model;

public class Booking {
    private int id;
    private int userId;
    private int flightId;
    private String bookingDate;
    private String status; // booked / cancelled

    // Constructors
    public Booking() {}

    public Booking(int id, int userId, int flightId, String bookingDate, String status) {
        this.id = id;
        this.userId = userId;
        this.flightId = flightId;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public Booking(int userId, int flightId, String bookingDate, String status) {
        this.userId = userId;
        this.flightId = flightId;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlightId() {
        return flightId;
    }
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

