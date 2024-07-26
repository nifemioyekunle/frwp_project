package com.finalproject.models;

public class CharitableOrganization extends User {

  public CharitableOrganization() {}

  public CharitableOrganization(int id, String name, String email, String password) {
    super(id, name, email, password, UserType.CHARITABLE_ORGANIZATION);
  }

  @Override
  public void register() {}

  @Override
  public void login() {}

  @Override
  public void logout() {}

  public void claimFoodItem(FoodItem foodItem) {}
}
