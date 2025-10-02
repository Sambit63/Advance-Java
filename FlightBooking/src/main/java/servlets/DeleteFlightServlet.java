package servlets;

import dao.FlightDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/deleteFlight")
public class DeleteFlightServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String flightNumber = req.getParameter("flight_number");
        String airline = req.getParameter("airline");

        try {
            if (FlightDAO.deleteFlight(flightNumber, airline)) {
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
