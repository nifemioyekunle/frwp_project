package com.finalproject.models;

import java.time.LocalDate;

public class FoodItem {

  private int id;
  private String name;
  private int quantity;
  private LocalDate expirationDate;
  private boolean surplusStatus;

  public FoodItem() {}

  public FoodItem(int id, String name, int quantity, LocalDate expirationDate, boolean surplusStatus) {
    this.id = id;
    this.name = name;
    this.quantity = quantity;
    this.expirationDate = expirationDate;
    this.surplusStatus = checkSurplusStatus();//! work on this
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

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;   
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  public boolean getSurplusStatus(){//! work on this
    return surplusStatus;
  }

  public boolean checkSurplusStatus() { //! work on this
    if (this.quantity > 5) {
      return true;
    } else {
      return false;
    }
  } 


}
