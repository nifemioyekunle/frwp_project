package com.finalproject.services;

import com.finalproject.models.User;
import com.finalproject.dao.UserDAO;

public class UserService {
  private UserDAO userDAO;

  public UserService() {
    this.userDAO = new UserDAO();
  }

  public void registerUser(User user) {
    this.userDAO.addUser(user);
  }

  public void loginUser(User user) {
    User registeredUser = userDAO.getUserByEmail(user.getEmail());

    if (registeredUser != null && registeredUser.getPassword().equals(user.getPassword())) {
      System.out.println("Login successful!");
    } else {
      System.out.println("Invalid email or password. Please try again.");
    }
  }

  public void logoutUser() {
    System.out.println("Logout successful!"); //TODO: might need implementation
  }

}
