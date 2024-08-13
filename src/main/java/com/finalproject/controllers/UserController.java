package com.finalproject.controllers;

//import com.finalproject.dao.UserDAO;
import com.finalproject.models.User;
import com.finalproject.models.UserFactory;
import com.finalproject.services.UserService;

public class UserController {
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  public void registerUser(User.UserType userType, int id, String name, String email, String password) {
    User user = UserFactory.createUser(userType, id, name, email, password);
    userService.registerUser(user);
  }

  public User loginUser(String email, String password) { //TODO update service
    User user = userService.loginUser(email, password);
    return user;
  }

  public void logoutUser(User user) {
    userService.logoutUser(user);
  }
}
