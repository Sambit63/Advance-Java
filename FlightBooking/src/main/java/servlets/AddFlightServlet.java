package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnection;

@WebServlet("/addFlight")
public class AddFlightServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String flightNumber = req.getParameter("flight_number");
        String airline = req.getParameter("airline");
        String source = req.getParameter("source");
        String destination = req.getParameter("destination");
        String departureDate = req.getParameter("departure_date");
        String departureTime = req.getParameter("departure_time");
        String arrivalTime = req.getParameter("arrival_time");
        String price = req.getParameter("price");
        String seats = req.getParameter("seats");

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO flights " +
                    "(flight_number, airline, source, destination, departure_date, departure_time, arrival_time, price, seats) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, flightNumber);
            ps.setString(2, airline);
            ps.setString(3, source);
            ps.setString(4, destination);
            ps.setDate(5, java.sql.Date.valueOf(departureDate)); // yyyy-MM-dd
            ps.setTime(6, java.sql.Time.valueOf(departureTime + ":00")); // HH:mm → HH:mm:ss
            if (arrivalTime != null && !arrivalTime.isEmpty()) {
                ps.setTime(7, java.sql.Time.valueOf(arrivalTime + ":00"));
            } else {
                ps.setNull(7, java.sql.Types.TIME);
            }
            ps.setBigDecimal(8, new java.math.BigDecimal(price));
            ps.setInt(9, Integer.parseInt(seats));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                resp.sendRedirect("adminDashboard.jsp?msg=Flight Added Successfully");
            } else {
                resp.sendRedirect("adminDashboard.jsp?msg=Failed to Add Flight");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
}
