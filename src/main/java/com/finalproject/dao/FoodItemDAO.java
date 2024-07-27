package com.finalproject.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class FoodItemDAO {

  private Connection connection;

  public FoodItemDAO() {
    try {
      this.connection = DBConnection.getInstance().getConnection();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

}
