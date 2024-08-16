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
        System.out.println("Action: " + action);

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

                    case "deleteItem":
                        deleteInventoryItem(request, response, conn);
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
    
    private void identifySurplusItems(HttpServletRequest request, HttpServletResponse response, Connection conn) throws SQLException, ServletException, IOException {
    String retailerIdParam = request.getParameter("userIdParam");
    System.out.println("Retailer ID Param: " + retailerIdParam);

    if (retailerIdParam == null || retailerIdParam.trim().isEmpty()) {
        // Handle the case where retailerId is missing or empty
        request.setAttribute("errorMessage", "Retailer ID is required to identify surplus items.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
        dispatcher.forward(request, response);
        return;
    }

    try {
        int userId = Integer.parseInt(retailerIdParam);

        List<InventoryItem> surplusItems = InventoryDAO.getSurplusItems(userId);
        System.out.println(surplusItems.toString());
        request.setAttribute("surplusItems", surplusItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SurplusInventory.jsp");
        dispatcher.forward(request, response);
    } catch (NumberFormatException e) {
        // Handle the case where retailerId is not a valid integer
        request.setAttribute("errorMessage", "Invalid Retailer ID format. Please provide a valid integer.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
        dispatcher.forward(request, response);
    }
}


    private void viewInventory(HttpServletRequest request, HttpServletResponse response, Connection conn) throws SQLException, ServletException, IOException {
        List<InventoryItem> inventoryItems = InventoryDAO.getAllInventoryItems();
        request.setAttribute("inventoryItems", inventoryItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Inventory.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddItemForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AddItem.jsp");
        dispatcher.forward(request, response);
    }

    

    private void deleteInventoryItem(HttpServletRequest request, HttpServletResponse response, Connection conn) throws SQLException, ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        boolean success = InventoryDAO.deleteInventoryItem(itemId);
        if (success) {
            request.getSession().setAttribute("successMessage", "Item deleted successfully!");
            response.sendRedirect("InventoryServlet?action=viewInventory");
        } else {
            request.setAttribute("message", "Failed to delete item.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Inventory.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addItem".equals(action)) {
            String itemName = request.getParameter("itemName");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            LocalDate expirationDate = LocalDate.parse(request.getParameter("expirationDate"));
            int retailerId = Integer.parseInt(request.getParameter("retailerId"));

            InventoryItem newItem = new InventoryItem(0, itemName, quantity, expirationDate, retailerId, 0);

            try {
                boolean success = InventoryDAO.addInventoryItem(newItem);
                if (success) {
                    request.getSession().setAttribute("successMessage", "Item added successfully!");
                    response.sendRedirect("Retailers.jsp");
                } else {
                    request.setAttribute("message", "Failed to add item.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/AddItem.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "A database error occurred: " + e.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        } else if ("updateItem".equals(action)) {
            String itemName = request.getParameter("itemName");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            LocalDate expirationDate = LocalDate.parse(request.getParameter("expirationDate"));
            int retailerId = Integer.parseInt(request.getParameter("retailerId"));
            int itemID = Integer.parseInt(request.getParameter("itemId"));

            InventoryItem newItem = new InventoryItem(itemID, itemName, quantity, expirationDate, retailerId, 0);

            try {
                boolean success = InventoryDAO.updateInventoryItem(newItem);
                if (success) {
                    request.getSession().setAttribute("successMessage", "Item updated successfully!");
                    response.sendRedirect("Retailers.jsp");
                } else {
                    request.setAttribute("message", "Failed to update item.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/Inventory.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "A database error occurred: " + e.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        } else if ("deleteItem".equals(action)) {
            try (Connection conn = DatabaseConnection.getInstance().getConnection()) {
                deleteInventoryItem(request, response, conn);
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "A database error occurred: " + e.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            doGet(request, response);  // Handle other actions
        }
    }

    @Override
    public String getServletInfo() {
        return "InventoryServlet handles inventory management operations.";
    }
}
