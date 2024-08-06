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
    user.register(); //TODO implement this
  }

  public void loginUser(User user) { //TODO change parameters to email and password
    User registeredUser = userDAO.getUserByEmail(user.getEmail());

    if (registeredUser != null && registeredUser.getPassword().equals(user.getPassword())) {
      user.login(); //TODO implement this
      return user;
      System.out.println("Login successful!");
    } else {
      System.out.println("Invalid email or password. Please try again.");
    }
  }

  public void logoutUser() {
    user.logout(); //TODO implement this
    System.out.println("Logout successful!"); //TODO: might need implementation
  }

}
