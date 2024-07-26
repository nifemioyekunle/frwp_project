package com.finalproject.models;
public class SurplusFoodAlert {

  private int id;
  private int userId;
  private String location;
  private String communicationMethod;
  private String foodPreferences;

  public SurplusFoodAlert() {}

  public SurplusFoodAlert(int id, int userId, String location, String communicationMethod, String foodPreferences) {  
    this.id = id;
    this.userId = userId;
    this.location = location;
    this.communicationMethod = communicationMethod;
    this.foodPreferences = foodPreferences;
  }

  public int getId() {
    return id;
  }   

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getLocation() {
    return location;
  } 

  public void setLocation(String location) {
    this.location = location;
  }

  public String getCommunicationMethod() {  
    return communicationMethod;
  }

  public void setCommunicationMethod(String communicationMethod) {
    this.communicationMethod = communicationMethod;
  }
  
  public String getFoodPreferences() {
    return foodPreferences;
  }
  
  public void setFoodPreferences(String foodPreferences) {
    this.foodPreferences = foodPreferences;
  } 

  public void subscribe(){

  }

  public void unsubscribe(){

  }

  public void notifyUsers(){  

  }




}
