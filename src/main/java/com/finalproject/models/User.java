package com.finalproject.models;

public abstract class User {

  public enum UserType {
    RETAILER, 
    CONSUMER, 
    CHARITABLE_ORGANIZATION
  }

  private int userId;
  private String name;
  private String email;
  private String password;
  private UserType userType;

  public User() {}

  public User(int userId, String name, String email, String password, UserType userType) {
    this.userId = userId;
    this.name = name;
    this.email = email;
    this.password = password;
    this.userType = userType;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) { //! might not be necessary
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {  
    this.name = name;
  }

  public String getEmail() {  
    return email;
  }

  public void setEmail(String email) {  
    this.email = email;
  }

  public String getPassword() {  
    return password;
  }

  public void setPassword(String password) {  
    this.password = password;
  }

  public UserType getUserType() {
    return userType;
  } 

  public void setUserType(UserType userType) {  
    this.userType = userType;
  }

  public abstract void register();

  public abstract void login();

  public abstract void logout();


}
