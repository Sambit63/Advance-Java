package servlets;

import dao.FlightDAO;
import model.Flight;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewAllFlights")
public class ViewAllFlightsServlet extends HttpServlet {

    private FlightDAO flightDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        flightDAO = new FlightDAO(); // Initialize your DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ Fetch all flights from DB
        List<Flight> flights = flightDAO.getAllFlights();

        // ✅ Set flights as request attribute for JSP
        request.setAttribute("flights", flights);

        // ✅ Forward to adminDashboard.jsp
        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Optional: redirect POST requests to GET
        doGet(request, response);
    }
}
