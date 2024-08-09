package Servlets;

import JavaCode.SurplusFoodItem;
import JavaCode.SurplusFoodItemDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SurplusInventoryServlet")
public class SurplusInventoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve surplus inventory data from the database using the DAO
            List<SurplusFoodItem> surplusInventoryItems = SurplusFoodItemDAO.getAllSurplusFoodItems();

            // Set the surplus inventory data as a request attribute
            request.setAttribute("surplusInventoryItems", surplusInventoryItems);

            // Forward the request to the consumer.jsp page to display items for purchase
            RequestDispatcher dispatcher = request.getRequestDispatcher("/consumer.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();

            // Handle any SQL exceptions gracefully by forwarding to an error page
            request.setAttribute("errorMessage", "An error occurred while retrieving surplus inventory data.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();

            // Catch any other exceptions and forward to a general error page
            request.setAttribute("errorMessage", "An unexpected error occurred.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Optionally handle POST requests by delegating to doGet
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "SurplusInventoryServlet handles retrieving and displaying surplus inventory items.";
    }
}
