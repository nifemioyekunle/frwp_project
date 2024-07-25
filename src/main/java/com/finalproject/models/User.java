package com.finalproject.models;

public abstract class User {

  private int id;
  private String name;
  private String email;
  private String password;
  private UserType userType;

  public User() {}

  public User(int id, String name, String email, String password, UserType userType) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.userType = userType;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
