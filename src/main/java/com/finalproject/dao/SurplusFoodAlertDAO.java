package com.finalproject.dao;

import com.finalproject.models.CommunicationMethod;
import com.finalproject.models.SurplusFoodAlert;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class SurplusFoodAlertDAO {

  private Connection connection;

  public SurplusFoodAlertDAO() {
    try {
      this.connection = DBConnection.getInstance().getConnection();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public void addSurplusFoodAlert(SurplusFoodAlert surplusFoodAlert) {
    PreparedStatement stmt; 

    try {
      String sql = "INSERT INTO SurplusFoodAlerts (userId, location, communicationMethod, foodPreferences) VALUES (?, ?, ?, ?)";
      stmt = this.connection.prepareStatement(sql);
      
      stmt.setInt(1, surplusFoodAlert.getUserId());
      stmt.setString(2, surplusFoodAlert.getLocation());
      stmt.setString(3, surplusFoodAlert.getCommunicationMethod().toString());
      stmt.setString(4, surplusFoodAlert.getFoodPreferences()); 

      stmt.executeUpdate();
      System.out.println("Surplus food alert added successfully!"); 

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public SurplusFoodAlert getSurplusFoodAlertById(int userId) {
    PreparedStatement stmt;
    // SurplusFoodAlert surplusFoodAlert = new SurplusFoodAlert();

    try {
      String sql = "SELECT * FROM SurplusFoodAlerts WHERE userId = " + userId;
      stmt = this.connection.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        
        int surplusFoodAlertId = rs.getInt("surplusFoodAlertId");
        String location = rs.getString("location");
        String communicationMethodString = rs.getString("communicationMethod");
        String foodPreferences = rs.getString("foodPreferences");

        CommunicationMethod communicationMethod = CommunicationMethod.valueOf(communicationMethodString);
        SurplusFoodAlert surplusFoodAlert = new SurplusFoodAlert(surplusFoodAlertId, userId, location, communicationMethod, foodPreferences);
        return surplusFoodAlert;
      }
    
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public void updateSurplusFoodAlert(SurplusFoodAlert surplusFoodAlert) {
    PreparedStatement stmt;

    try {
      String sql = "UPDATE SurplusFoodAlerts SET location = ?, communicationMethod = ?, foodPreferences = ? WHERE surplusFoodAlertId = ?";
      stmt = this.connection.prepareStatement(sql);
      
      stmt.setString(1, surplusFoodAlert.getLocation());
      stmt.setString(2, surplusFoodAlert.getCommunicationMethod().toString());
      stmt.setString(3, surplusFoodAlert.getFoodPreferences());
      stmt.setInt(4, surplusFoodAlert.getSurplusFoodAlertId());

      stmt.executeUpdate();
      System.out.println("Surplus food alert updated successfully!");

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public void deleteSurplusFoodAlert(int userId) {
    PreparedStatement stmt;

    try {
      String sql = "DELETE FROM SurplusFoodAlerts WHERE userId = " + userId;
      stmt = this.connection.prepareStatement(sql);
      
      stmt.executeUpdate();
      System.out.println("Surplus food alert deleted successfully for user with id: " + userId);

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }



  

}
