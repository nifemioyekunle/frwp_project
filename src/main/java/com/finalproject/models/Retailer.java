package com.finalproject.models;

import java.util.List;
import java.util.ArrayList;

public class Retailer extends User{

  private List<FoodItem> inventory = new ArrayList<>();

  public Retailer() {}

  public Retailer(int id, String name, String email, String password) {
    super(id, name, email, password, UserType.RETAILER);
  }

  @Override
  public void register() {

  }

  @Override
  public void login() {

  }

  @Override
  public void logout() {

  }

  public void addFoodItem(FoodItem foodItem) {
    inventory.add(foodItem);
  }

  public void updateFoodItem(FoodItem foodItem) {

  }

  public void listSurplusFoodItems() {
    
  }

}
