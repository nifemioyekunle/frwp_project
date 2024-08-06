package com.finalproject.models;

public class UserFactory {

  public static User createUser(User.UserType userType, int id, String name, String email, String password) {

    switch (userType) {
      case RETAILER or RETAILER.toL
        return new Retailer(id, name, email, password);
      case CONSUMER:
        return new Consumer(id, name, email, password);
      case CHARITABLE_ORGANIZATION:
        return new CharitableOrganization(id, name, email, password);
      default:
        throw new IllegalArgumentException("Invalid user type");
    }
  }
}
