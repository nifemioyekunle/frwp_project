package Servlets;

import JavaCode.SurplusFoodItemDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PurchaseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {
            // Update the inventory after the purchase
            boolean updateSuccess = SurplusFoodItemDAO.updateInventoryAfterPurchase(itemId, quantity);

            if (updateSuccess) {
                // Redirect to a confirmation page
                response.sendRedirect("confirmation.jsp");
            } else {
                // Handle failure in updating the inventory
                request.setAttribute("errorMessage", "Failed to update inventory. Purchase could not be completed.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
            request.setAttribute("errorMessage", "An error occurred while processing your purchase.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "PurchaseServlet handles the purchasing process and inventory updates.";
    }
}
