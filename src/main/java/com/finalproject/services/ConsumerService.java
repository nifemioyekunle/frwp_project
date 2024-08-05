package com.finalproject.services;

import com.finalproject.models.FoodItem;
import com.finalproject.dao.FoodItemDAO;

public class ConsumerService {
  private FoodItemDAO foodItem;

  public ConsumerService() {
    this.foodItem = new FoodItemDAO();
  }

  public void purchaseFoodItem(FoodItem foodItem, int quantity) {
    this.foodItem.updateFoodItemQuantity(foodItem, quantity);
  }
}
