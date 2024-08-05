package com.finalproject.models;

import java.time.LocalDate;

public class FoodItem {

  private int foodItemId;
  private String name;
  private int quantity;
  private LocalDate expirationDate; //? String or LocalDate type? 
  private boolean surplusStatus;

  public FoodItem() {}

  public FoodItem(int foodItemId, String name, int quantity, LocalDate expirationDate, boolean surplusStatus) {
    this.foodItemId = foodItemId;
    this.name = name;
    this.quantity = quantity;
    this.expirationDate = expirationDate;
    this.surplusStatus = checkSurplusStatus();//! work on this
  }

  public int getfoodItemId() {
    return foodItemId;
  } 

  public void setId(int foodItemId) {
    this.foodItemId = foodItemId;
  }

  public String getName() {  
    return name;
  }

  public void setName(String name) {  
    this.name = name;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;   
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  //! Surplus items are those that are nearing expiration or are in excess of demand. 
  //! Surplus items are those with

  public boolean getSurplusStatus(){
    return surplusStatus;
  }

  public boolean checkSurplusStatus() { //! work on this
    //? if expiration date less that a week

    
    if (this.quantity > 5) {
      return true;
    } else {
      return false;
    }
  } 


}
