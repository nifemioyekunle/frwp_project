package com.finalproject.services;

import java.util.List;

import com.finalproject.dao.FoodItemDAO;
import com.finalproject.models.FoodItem;
import com.finalproject.models.Retailer;

public class RetailerService {

  private FoodItemDAO foodItemDAO;

  public RetailerService(FoodItemDAO foodItemDAO) {
    this.foodItemDAO = foodItemDAO;
  }

  public void addFoodItem (Retailer retailer, FoodItem foodItem) {
    retailer.addFoodItem(foodItem);
    this.foodItemDAO.addFoodItem(foodItem);
  }

  public void updateFoodItem(FoodItem foodItem){
    this.foodItemDAO.updateFoodItem(foodItem);
  }

  public List<FoodItem> listSurplusFoodItems(Retailer retailer) {
    return this.foodItemDAO.getSurplusFoodItems();
  }
}
