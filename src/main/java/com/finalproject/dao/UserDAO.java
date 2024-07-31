package com.finalproject.dao;

import com.finalproject.models.User;
import com.finalproject.models.Retailer;
import com.finalproject.models.CharitableOrganization;
import com.finalproject.models.Consumer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

  private Connection connection;

  public UserDAO() {
    try {
      this.connection = DBConnection.getInstance().getConnection();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public void addUser(User user) {
    PreparedStatement stmt;

    try {
      String sql = "INSERT INTO Users (name, email, password, userType) VALUES (?, ?, ?, ?)";
      stmt = this.connection.prepareStatement(sql);
      
      stmt.setString(1, user.getName());
      stmt.setString(2, user.getEmail());
      stmt.setString(3, user.getPassword());
      stmt.setString(4, user.getUserType().toString());

      stmt.executeUpdate();
      System.out.println("User " + user.getName() + " added successfully!");

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public User getUserById(int id) {
    PreparedStatement stmt;
    // User user = new User();

    try {
      String sql = "SELECT * FROM Users WHERE userId = " + id;
      stmt = this.connection.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        String name = rs.getString("name");
        String email = rs.getString("email");
        String password = rs.getString("password");
        
        String userType = rs.getString("userType");
        switch(userType){
          case "RETAILER":
           return new Retailer(id, name, email, password);
          case "CONSUMER":
            return new Consumer(id, name, email, password);
          case "CHARITABLE_ORGANIZATION":
            return new CharitableOrganization(id, name, email, password);
          default:
            return null;
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    return null;
  }

  public User getUserByEmail(String email) {
    PreparedStatement stmt;
    // User user = new User();

    try {
      String sql = "SELECT * FROM Users WHERE email = '" + email + "'";
      stmt = this.connection.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("userId");
        String name = rs.getString("name");
        String password = rs.getString("password");
        String userType = rs.getString("userType");
        
        switch(userType){
          case "RETAILER":
           return new Retailer(id, name, email, password);
          case "CONSUMER":
            return new Consumer(id, name, email, password);
          case "CHARITABLE_ORGANIZATION":
            return new CharitableOrganization(id, name, email, password);
          default:
          return null;
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    return null;
  }

  public void updateUser(User user) {
    PreparedStatement stmt;
    
    try {
      String sql = "UPDATE Users SET name = ?, email = ?, password = ? WHERE userId = ?";
      stmt = this.connection.prepareStatement(sql);
      
      stmt.setString(1, user.getName());
      stmt.setString(2, user.getEmail());
      stmt.setString(3, user.getPassword());
      stmt.setInt(4, user.getUserId());
      stmt.executeUpdate();
   
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

}
