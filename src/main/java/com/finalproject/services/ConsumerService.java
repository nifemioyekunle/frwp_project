package com.finalproject.services;

import com.finalproject.models.FoodItem;
import com.finalproject.dao.FoodItemDAO;

public class ConsumerService {
  private FoodItemDAO foodItemDAO;

  public ConsumerService(FoodItemDAO foodItemDAO) {
    this.foodItem = foodItemDAO;
  }

  public void purchaseFoodItem(FoodItem foodItem, int quantity) { //TODO work on this
    if (foodItem.getQuantity() < quantity) {
      throw new IllegalArgumentException("Insufficient quantity of food item");
    }
    this.foodItemDAO.updateFoodItemQuantity(foodItem, quantity);
  }
}

