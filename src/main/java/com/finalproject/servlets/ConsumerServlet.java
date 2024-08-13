package com.finalproject.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import com.finalproject.dao.FoodItemDAO;
import com.finalproject.models.FoodItem;
import com.finalproject.services.ConsumerService;

@WebServlet("/consumer")
public class ConsumerServlet extends HttpServlet {

  private ConsumerService consumerService;
  private FoodItemDAO foodItemDAO;

  @Override
  public void init() throws ServletException {
    super.init();
    foodItemDAO = new FoodItemDAO();
    consumerService = new ConsumerService(foodItemDAO);
  }


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if ("purchaseFoodItems".equals(action)) {
      handlePurchaseFoodItems(request, response);
    }
  }

  private void handlePurchaseFoodItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int foodItemId = Integer.parseInt(request.getParameter("foodItemId"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    FoodItem foodItem = foodItemDAO.getFoodItemById(foodItemId);
    consumerService.purchaseFoodItem(foodItem, quantity);
    response.getWriter().println("Food items purchased successfully");
  }




} 
