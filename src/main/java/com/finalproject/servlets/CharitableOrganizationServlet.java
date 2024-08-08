package com.finalproject.servlets;

import javax.servlet.http.HttpServlet;

import com.finalproject.models.FoodItem;
import com.finalproject.services.CharitableOrganizationService;

public class CharitableOrganizationServlet extends HttpServlet {
  CharitableOrganizationService charitableOrganizationService;

  @Override
  public void init() throws ServletException {
    super.init();
    charitableOrganizationService = new CharitableOrganizationService();
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

    FoodItem foodItem = charitableOrganizationService.getFoodItemById(foodItemId);

    charitableOrganizationService.claimFoodItem(foodItem, quantity);
    response.getWriter().println("Food item claimed successfully");
}
