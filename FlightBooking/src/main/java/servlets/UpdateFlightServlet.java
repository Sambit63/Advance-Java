package servlets;

import dao.FlightDAO;
import model.Flight;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/updateFlight")
public class UpdateFlightServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String flightNumber = req.getParameter("flight_number");
        String departureDate = req.getParameter("departure_date");
        String departureTime = req.getParameter("departure_time");
        String arrivalTime = req.getParameter("arrival_time");
        String price = req.getParameter("price");

        Flight f = new Flight();
        f.setFlightNumber(flightNumber);
        f.setDepartureDate(departureDate);
        f.setDepartureTime(departureTime);
        f.setArrivalTime(arrivalTime);
        f.setPrice(new BigDecimal(price));

        try {
        	if (FlightDAO.updateFlight(f)) {
        	    resp.sendRedirect(req.getContextPath() + "/adminDashboard.jsp?success=Flight updated");
        	} else {
        	    resp.sendRedirect(req.getContextPath() + "/adminDashboard.jsp?error=Flight not found");
        	}

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("jsp/error.jsp");
        }
    }
}
