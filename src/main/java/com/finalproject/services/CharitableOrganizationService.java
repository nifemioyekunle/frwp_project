package com.finalproject.services;

import com.finalproject.models.FoodItem;
import com.finalproject.dao.FoodItemDAO;

public class CharitableOrganizationService {

  private FoodItemDAO FoodItem;

  public CharitableOrganizationService() {
    this.FoodItem = new FoodItemDAO();
  }

  public void claimFoodItem(FoodItem foodItem, int quantity) {
    if (foodItem.getQuantity() < quantity) {
      throw new IllegalArgumentException("Insufficient quantity of food item");
    }
    this.FoodItem.updateFoodItemQuantity(foodItem, quantity);
  }

  
}
