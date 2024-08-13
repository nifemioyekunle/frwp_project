package com.finalproject.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.finalproject.dao.FoodItemDAO;
import com.finalproject.models.FoodItem;
import com.finalproject.services.CharitableOrganizationService;

@WebServlet("/charitableOrganization")
public class CharitableOrganizationServlet extends HttpServlet {
  private CharitableOrganizationService charitableOrganizationService;
  private FoodItemDAO foodItemDAO;

  @Override
  public void init() throws ServletException {
    super.init();
    foodItemDAO = new FoodItemDAO();
    charitableOrganizationService = new CharitableOrganizationService(foodItemDAO);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if ("claimFoodItem".equals(action)) {
      handleClaimFoodItem(request, response);
    }
  }

  private void handleClaimFoodItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int foodItemId = Integer.parseInt(request.getParameter("foodItemId"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));

    FoodItem foodItem = foodItemDAO.getFoodItemById(foodItemId);

    charitableOrganizationService.claimFoodItem(foodItem, quantity);
    response.getWriter().println("Food item claimed successfully");
  }
}
