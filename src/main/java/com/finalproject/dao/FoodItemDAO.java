package com.finalproject.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;


import com.finalproject.models.FoodItem;

public class FoodItemDAO {

  private Connection connection;

  public FoodItemDAO() {
    try {
      this.connection = DBConnection.getInstance().getConnection();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public void addFoodItem(FoodItem foodItem) {
    PreparedStatement stmt;

    try {
      String sql = "INSERT INTO FoodItems (name, quantity, expirationDate, surplusStatus) VALUES (?, ?, ?, ?)";
      stmt = this.connection.prepareStatement(sql);
      
      stmt.setString(1, foodItem.getName());
      stmt.setInt(2, foodItem.getQuantity());
      stmt.setString(3, foodItem.getExpirationDate().toString()); //! work on this
      stmt.setBoolean(4, foodItem.getSurplusStatus());

      stmt.executeUpdate();
      System.out.println("Food item " + foodItem.getName() + " added successfully!");

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public FoodItem getFoodItemBId(int id) {
    PreparedStatement stmt;
    // FoodItem foodItem = new FoodItem(); 

    try {
      String sql = "SELECT * FROM FoodItems WHERE foodItemId = " + id;
      stmt = this.connection.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        String name = rs.getString("name");
        int quantity = rs.getInt("quantity");
        LocalDate expirationDate = rs.getDate("expirationDate").toLocalDate();
        boolean surplusStatus = rs.getBoolean("surplusStatus");

        FoodItem foodItem = new FoodItem(id, name, quantity, expirationDate, surplusStatus);
        return foodItem; 

      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public void updateFoodItem(FoodItem foodItem) {
    PreparedStatement stmt;

    try {
      String sql = "UPDATE FoodItems SET name = ?, quantity = ?, expirationDate = ?, surplusStatus = ? WHERE foodItemId = ?";
      stmt = this.connection.prepareStatement(sql);
      
      stmt.setString(1, foodItem.getName());
      stmt.setInt(2, foodItem.getQuantity());
      stmt.setString(3, foodItem.getExpirationDate().toString());
      stmt.setBoolean(4, foodItem.getSurplusStatus());
      stmt.setInt(5, foodItem.getfoodItemId());
    
    } catch(SQLException ex){
      ex.printStackTrace();
    }
  }

  public void updateFoodItemQuantity(FoodItem foodItem, int quantity) {
    PreparedStatement stmt;

    try {
      String sql = "UPDATE FoodItems SET quantity = ? WHERE foodItemId = ?";
      stmt = this.connection.prepareStatement(sql);
      
      stmt.setInt(1, foodItem.getQuantity() - quantity);
      stmt.setInt(2, foodItem.getfoodItemId());
    
    } catch(SQLException ex){
      ex.printStackTrace();
    }
  }

  public List<FoodItem> getSurplusFoodItems() {
    PreparedStatement stmt;
    List<FoodItem> surplusFoodItems = new ArrayList<>();

    try {
      String sql = "SELECT * FROM FoodItems WHERE surplusStatus = true";
      stmt = this.connection.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("foodItemId");
        String name = rs.getString("name");
        int quantity = rs.getInt("quantity");
        LocalDate expirationDate = rs.getDate("expirationDate").toLocalDate();
        boolean surplusStatus = rs.getBoolean("surplusStatus");

        surplusFoodItems.add(new FoodItem(id, name, quantity, expirationDate, surplusStatus));
      }
    } catch (SQLException ex) {
      ex.printStackTrace();   
    }
    return surplusFoodItems;
  }

  

}
