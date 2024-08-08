package com.finalproject.servlets;

import javax.servlet.http.HttpServlet;

import com.finalproject.models.Retailer;
import com.finalproject.models.FoodItem;
import com.finalproject.services.RetailerService;
import com.finalproject.dao.FoodItemDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RetailerServlet extends HttpServlet{

  private RetailerService retailerService;

  @Override
  public void init() throws ServletException {
    super.init();
    retailerService = new RetailerService(new FoodItemDAO());
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if ("addFoodItem".equals(action)) {
      handleAddFoodItem(request, response);
    } else if ("updateFoodItem".equals(action)) {
      handleUpdateFoodItem(request, response);
    } else if ("listSurplusFoodItems".equals(action)) {
      handleListSurplusFoodItems(request, response);
    }
  }

  private void handleAddFoodItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int retailerId = Integer.parseInt(request.getParameter("retailerId"));
    Retailer retailer = retailerService.getRetailerById(retailerId); //!tweak food item and user daos
    
    int foodItemId = Integer.parseInt(request.getParameter("foodItemId"));
    String name = request.getParameter("name");
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    String expirationDate = request.getParameter("expirationDate");

    FoodItem foodItem = new FoodItem(foodItemId, name, quantity, expirationDate); //! might add retailer id in fooditems too
    retailerService.addFoodItem(retailer, foodItem);
    response.getWriter().println("Food item added successfully");
  }

  private void handleUpdateFoodItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int foodItemId = Integer.parseInt(request.getParameter("foodItemId"));
    String name = request.getParameter("name");
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    String expirationDate = request.getParameter("expirationDate");
    Boolean surplusStatus = Boolean.parseBoolean(request.getParameter("surplusStatus"));

    FoodItem foodItem = new FoodItem(foodItemId, name, quantity, expirationDate, surplusStatus);
    retailerService.updateFoodItem(foodItem);
    response.getWriter().println("Food item updated successfully");
  }

  private void handleListSurplusFoodItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int retailerId = Integer.parseInt(request.getParameter("retailerId"));
    Retailer retailer = retailerService.getRetailerById(retailerId); //!tweak food item and user daos
    
    List<FoodItem> foodItems = retailerService.listSurplusFoodItems(retailer);
    for (FoodItem foodItem : surplusFoodItems) {
      response.getWriter().println(foodItem);
    }
  }

}
