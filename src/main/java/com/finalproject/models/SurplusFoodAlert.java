package com.finalproject.models;
public class SurplusFoodAlert {

  private int surplusFoodAlertId;
  private int userId;
  private String location;
  private CommunicationMethod communicationMethod;
  private String foodPreferences;

  public SurplusFoodAlert() {}

  public SurplusFoodAlert(int surplusFoodAlertId, int userId, String location, CommunicationMethod communicationMethod, String foodPreferences) {  
    this.surplusFoodAlertId = surplusFoodAlertId;
    this.userId = userId;
    this.location = location;
    this.communicationMethod = communicationMethod;
    this.foodPreferences = foodPreferences;
  }

  public int getSurplusFoodAlertId() {
    return surplusFoodAlertId;
  }   

  public void setSurplusFoodAlertId(int surplusFoodAlertId) {
    this.surplusFoodAlertId = surplusFoodAlertId;
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

  public CommunicationMethod getCommunicationMethod() {  
    return communicationMethod;
  }

  public void setCommunicationMethod(CommunicationMethod communicationMethod) {
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
