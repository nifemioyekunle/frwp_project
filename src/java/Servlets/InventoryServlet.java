package Servlets;

import JavaCode.DatabaseConnection;
import JavaCode.InventoryDAO;
import JavaCode.InventoryItem;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InventoryServlet")
public class InventoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            try (Connection conn = DatabaseConnection.getInstance().getConnection()) {
                switch (action) {
                    case "viewInventory":
                        viewInventory(request, response, conn);
                        break;
                    case "addItem":
                        showAddItemForm(request, response);
                        break;
                    case "identifySurplus":
                        identifySurplusItems(request, response, conn);
                        break;
                    default:
                        response.getWriter().write("Unknown action.");
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "A database error occurred: " + e.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    private void viewInventory(HttpServletRequest request, HttpServletResponse response, Connection conn) throws SQLException, ServletException, IOException {
        // Adjusting the method call to match the revised DAO method signature
        List<InventoryItem> inventoryItems = InventoryDAO.getAllInventoryItems(); // Adjusted this line
        request.setAttribute("inventoryItems", inventoryItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Inventory.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddItemForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AddItem.jsp");
        dispatcher.forward(request, response);
    }

    private void identifySurplusItems(HttpServletRequest request, HttpServletResponse response, Connection conn) throws SQLException, ServletException, IOException {
        int retailerId = Integer.parseInt(request.getParameter("retailerId"));
        // Adjusting the method call to match the revised DAO method signature
        List<InventoryItem> surplusItems = InventoryDAO.getSurplusItems(retailerId); // Adjusted this line
        request.setAttribute("surplusItems", surplusItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SurplusItems.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "InventoryServlet handles inventory management operations.";
    }
}
