package com.finalproject.services;

import com.finalproject.models.User;
import com.finalproject.dao.UserDAO;

public class UserService {
  private UserDAO userDAO;

  public UserService(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public void registerUser(User user) {
    this.userDAO.addUser(user);
    user.register(); //TODO implement this
  }

  public User loginUser(Sting email, String password) { //TODO change parameters to email and password
    User registeredUser = userDAO.getUserByEmail(user.getEmail());

    if (registeredUser != null && registeredUser.getPassword().equals(password)) {
      user.login(); //TODO implement this
      System.out.println("Login successful!");
      return user;
    } else {
      System.out.println("Invalid email or password. Please try again.");
    }
  }

  public void logoutUser(User user) {
    user.logout(); //TODO implement this
    System.out.println("Logout successful!"); //TODO: might need implementation
  }

}
