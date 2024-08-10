package com.finalproject.controllers;

import java.util.function.Consumer;

import com.finalproject.dao.FoodItemDAO;
import com.finalproject.models.FoodItem;
import com.finalproject.services.ConsumerService;

public class ConsumerController {

  private ConsumerService consumerService;

  public ConsumerController(ConsumerService consumerService) {
    this.consumerService = consumerService;
  }

  public void purchaseFoodItem(FoodItem foodItem, int quantity) {
    consumerService.purchaseFoodItem(foodItem, quantity);
  }



}
