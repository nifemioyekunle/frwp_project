package com.finalproject.services;

import com.finalproject.models.FoodItem;
import com.finalproject.dao.FoodItemDAO;

public class CharitableOrganizationService {

  private FoodItemDAO foodItemDAO;

  public CharitableOrganizationService(FoodItemDAO foodItemDAO) {
    this.FoodItem = foodItemDAO;
  }

  public void claimFoodItem(FoodItem foodItem, int quantity) { //TODO work on this
    if (foodItem.getQuantity() < quantity) {
      throw new IllegalArgumentException("Insufficient quantity of food item");
    }
    this.FoodItem.updateFoodItemQuantity(foodItem, quantity);
  }

  
}
