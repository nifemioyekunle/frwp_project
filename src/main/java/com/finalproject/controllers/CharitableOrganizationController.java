package com.finalproject.controllers;

import com.finalproject.models.FoodItem;
import com.finalproject.services.CharitableOrganizationService;

public class CharitableOrganizationController {
  private CharitableOrganizationService charitableOrganizationService;

  public CharitableOrganizationController() {
    this.charitableOrganizationService = new CharitableOrganizationService();
  }

  public void claimFoodItem(FoodItem foodItem, int quantity) {
    charitableOrganizationService.claimFoodItem(foodItem, quantity);
  }
}
