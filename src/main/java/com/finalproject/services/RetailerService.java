package com.finalproject.services;

import com.finalproject.dao.FoodItemDAO;
import com.finalproject.models.FoodItem;

public class RetailerService {

  private FoodItemDAO foodItemDAO;

  public RetailerService() {
    this.foodItemDAO = new FoodItemDAO();
  }

  public void addFoodItem (FoodItem foodItem) {
    this.foodItemDAO.addFoodItem(foodItem);
  }

  public void updateFoodItem(FoodItem foodItem){
    this.foodItemDAO.updateFoodItem(foodItem);
  }

  public void listSurplusFoodItems() {
    this.foodItemDAO.getSurplusFoodItems();
  }
}
