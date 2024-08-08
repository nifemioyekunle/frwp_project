package com.finalproject.controllers;

import com.finalproject.services.RetailerService;

public class RetailerController {
  private RetailerService retailerService;

  public RetailerController() {
    this.retailerService = new RetailerService();
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
