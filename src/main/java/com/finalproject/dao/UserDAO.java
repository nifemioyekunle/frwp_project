package com.finalproject.dao;

import java.sql.Connection;
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

}
