package Servlets;

import JavaCode.DatabaseConnection;
import JavaCode.InventoryDAO;
import JavaCode.InventoryItem;
import java.sql.Connection;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(Connection conn = DatabaseConnection.getInstance().getConnection()) {
            viewInventory(request, response, conn);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void viewInventory(HttpServletRequest request, HttpServletResponse response, java.sql.Connection conn) throws SQLException, ServletException, IOException {
        List<InventoryItem> inventoryItems = InventoryDAO.getAllInventoryItems();
        request.setAttribute("inventoryItems", inventoryItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Consumers.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {
            // Update the inventory after the purchase
            InventoryItem item = InventoryDAO.getInventoryItemById(itemId);
            item.setQuantity(item.getQuantity() - 1);
            boolean updateSuccess = InventoryDAO.updateInventoryItem(item);

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
