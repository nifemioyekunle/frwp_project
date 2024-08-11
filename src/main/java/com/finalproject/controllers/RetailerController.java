package com.finalproject.controllers;

import java.util.List;
import com.finalproject.models.FoodItem;
import com.finalproject.models.Retailer;
import com.finalproject.dao.FoodItemDAO;
import com.finalproject.services.RetailerService;

public class RetailerController {
  private RetailerService retailerService;

  public RetailerController(RetailerService retailerService) {
    this.retailerService = retailerService;
  }
  
  public void addFoodItem(Retailer retailer, FoodItem foodItem) {
    retailerService.addFoodItem(retailer, foodItem);
  }

  public void updateFoodItem(FoodItem foodItem) { 
    retailerService.updateFoodItem(foodItem);
  } 

  public List<FoodItem> listSurplusFoodItems() {
    return retailerService.listSurplusFoodItems();
  } 
}
