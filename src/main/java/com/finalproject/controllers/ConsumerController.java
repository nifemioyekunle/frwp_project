package com.finalproject.controllers;

import java.util.function.Consumer;

import com.finalproject.models.FoodItem;

public class ConsumerController {

  private ConsumerService consumerService;

  public ConsumerController() {
    this.consumerService = new ConsumerService();
  }

  public void purchaseFoodItem(FoodItem foodItem, int quantity) {
    consumerService.purchaseFoodItem(foodItem, quantity);
  }



}
