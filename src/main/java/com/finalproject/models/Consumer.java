package com.finalproject.models;

public class Consumer extends User{

  public Consumer() {}

  public Consumer(int id, String name, String email, String password) {
    super(id, name, email, password, UserType.CONSUMER);
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

  public void purchaseFoodItem(FoodItem foodItem) {
    
  }

}
