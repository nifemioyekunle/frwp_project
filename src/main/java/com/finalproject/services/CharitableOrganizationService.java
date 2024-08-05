package com.finalproject.services;

import com.finalproject.models.FoodItem;
import com.finalproject.dao.FoodItemDAO;

public class CharitableOrganizationService {

  private FoodItemDAO FoodItem;

  public CharitableOrganizationService() {
    this.FoodItem = new FoodItemDAO();
  }

  public void claimFoodItem(FoodItem foodItem, int quantity) {
    this.FoodItem.updateFoodItemQuantity(foodItem, quantity);
  }

  
}
