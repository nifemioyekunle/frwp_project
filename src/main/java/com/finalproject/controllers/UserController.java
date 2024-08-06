package com.finalproject.controllers;

import com.finalproject.services.UserService;

public class UserController {
  private UserService userService;

  public UserController() {
    this.userService = new UserService();
  }

  public void registerUser(User.UserType userType, int id, String name, String email, String password) {
    User user = UserFactory.createUser(userType, id, name, email, password);
    userService.registerUser(user);
  }

  public User loginUser(String email, String password) { //TODO update service
    User user = userService.loginUser(email, password);
  }

  public void logoutUser() {
    userService.logoutUser();
  }
}
