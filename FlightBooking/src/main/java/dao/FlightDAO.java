package dao;

import model.Flight;
import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {

    // ✅ DB connection
    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        return DBConnection.getConnection();
    }

    // 🔹 Get all flights
    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flights";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                flights.add(mapResultSetToFlight(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    // 🔹 Search flights by source & destination
    public List<Flight> searchFlights(String source, String destination) {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flights WHERE source = ? AND destination = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, source);
            ps.setString(2, destination);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    flights.add(mapResultSetToFlight(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    // 🔹 Add new flight
    public boolean addFlight(Flight flight) {
        String sql = "INSERT INTO flights (flight_number, airline, source, destination, departure_date, departure_time, arrival_time, price, seats) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, flight.getFlightNumber());
            ps.setString(2, flight.getAirline());
            ps.setString(3, flight.getSource());
            ps.setString(4, flight.getDestination());
            ps.setString(5, flight.getDepartureDate());
            ps.setString(6, flight.getDepartureTime());
            ps.setString(7, flight.getArrivalTime());
            ps.setBigDecimal(8, flight.getPrice());
            ps.setInt(9, flight.getSeats());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateFlight(Flight flight) {
        String sql = "UPDATE flights SET departure_date=?, departure_time=?, arrival_time=?, price=? WHERE flight_number=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // departure_date
            ps.setDate(1, java.sql.Date.valueOf(flight.getDepartureDate())); // yyyy-MM-dd

            // departure_time
            if (flight.getDepartureTime() != null && !flight.getDepartureTime().isEmpty()) {
                ps.setTime(2, java.sql.Time.valueOf(flight.getDepartureTime() + ":00")); // HH:mm → HH:mm:ss
            } else {
                ps.setNull(2, java.sql.Types.TIME);
            }

            // arrival_time
            if (flight.getArrivalTime() != null && !flight.getArrivalTime().isEmpty()) {
                ps.setTime(3, java.sql.Time.valueOf(flight.getArrivalTime() + ":00")); // HH:mm → HH:mm:ss
            } else {
                ps.setNull(3, java.sql.Types.TIME);
            }

            // price
            ps.setBigDecimal(4, flight.getPrice());

            // flight_number
            ps.setString(5, flight.getFlightNumber());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }




    // 🔹 Delete flight
 // 🔹 Delete flight by flightNumber + airline
    public static boolean deleteFlight(String flightNumber, String airline) {
        String sql = "DELETE FROM flights WHERE flight_number = ? AND airline = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, flightNumber);
            ps.setString(2, airline);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // 🔹 Helper method to map ResultSet → Flight object
    private Flight mapResultSetToFlight(ResultSet rs) throws SQLException {
        Flight flight = new Flight();
        flight.setId(rs.getInt("id"));
        flight.setFlightNumber(rs.getString("flight_number"));
        flight.setAirline(rs.getString("airline"));
        flight.setSource(rs.getString("source"));
        flight.setDestination(rs.getString("destination"));
        flight.setDepartureDate(rs.getString("departure_date"));
        flight.setDepartureTime(rs.getString("departure_time"));
        flight.setArrivalTime(rs.getString("arrival_time"));
        flight.setPrice(rs.getBigDecimal("price"));
        flight.setSeats(rs.getInt("seats"));
        return flight;
    }
}
