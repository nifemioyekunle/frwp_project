/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import JavaCode.InventoryDAO;
import JavaCode.InventoryItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Armando Bazeydio Mavova
 */

public class RetailersServlet extends HttpServlet {

    
     

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action"); // Get the action parameter
        
        if (action != null) {
            switch (action) {
                case "viewInventory":
                    
                      try {
                        // Retrieve inventory data from the database
                        List<InventoryItem> inventoryItems = InventoryDAO.getAllInventoryItems();

                        // Set the inventory data as a request attribute
                        request.setAttribute("inventoryItems", inventoryItems);

                        // Forward the request to the JSP page
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/Inventory.jsp");
                        dispatcher.forward(request, response);
                    } catch (Exception ex) {
                         ex.printStackTrace();

                        // Handle any exceptions gracefully
                        request.setAttribute("errorMessage", "An error occurred while retrieving inventory data.");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
                        dispatcher.forward(request, response);
                    }
                    break;
                case "viewSurplus":
                    request.getRequestDispatcher("/SurplusInventory.jsp").forward(request, response);
                    break;
                case "listSurplusItems":
                    request.getRequestDispatcher("/SurplusItems.jsp").forward(request, response);
                    break;
                    
                case "goBack":
                // Redirect back to the Retailers.jsp page
                response.sendRedirect(request.getContextPath() + "/Retailers.jsp");
                
                default:
            
                 break;
            }
        }
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
