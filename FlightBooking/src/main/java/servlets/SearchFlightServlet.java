package servlets;

import dao.FlightDAO;
import model.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchFlight")
public class SearchFlightServlet extends HttpServlet {
    private FlightDAO flightDAO;

    @Override
    public void init() {
        flightDAO = new FlightDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");

        List<Flight> flights = flightDAO.searchFlights(source, destination);
        request.setAttribute("flights", flights);
        request.getRequestDispatcher("userDashboard.jsp").forward(request, response);

    }
}
