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

            // Forward the request to the Consumer.jsp page to display items for purchase
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Consumers.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException ex) {
            // Handle SQL exceptions specifically
            handleException(request, response, "An error occurred while retrieving surplus inventory data.", ex);
        } catch (Exception ex) {
            // Handle any other unexpected exceptions
            handleException(request, response, "An unexpected error occurred.", ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delegate POST requests to the doGet method for simplicity
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "SurplusInventoryServlet handles retrieving and displaying surplus inventory items.";
    }

    /**
     * Handles exceptions by logging the error and forwarding to the error page.
     *
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @param message The error message to display.
     * @param ex The exception that was caught.
     * @throws ServletException If a servlet-specific error occurs.
     * @throws IOException If an I/O error occurs.
     */
    private void handleException(HttpServletRequest request, HttpServletResponse response, String message, Exception ex)
            throws ServletException, IOException {
        ex.printStackTrace(); // Log the exception details to the server logs
        request.setAttribute("errorMessage", message); // Set the error message as a request attribute
        RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp"); // Forward to the error page
        dispatcher.forward(request, response);
    }
}
