package servlets;

import dao.FlightDAO;
import model.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/viewFlights")
public class ViewFlightsServlet extends HttpServlet {
    private FlightDAO flightDAO;

    @Override
    public void init() {
        flightDAO = new FlightDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Flight> flights;
		flights = flightDAO.getAllFlights();
		request.setAttribute("flights", flights);
		request.getRequestDispatcher("jsp/flights.jsp").forward(request, response);
        
    }
}
