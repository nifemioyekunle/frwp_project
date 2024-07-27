package com.finalproject.dao;

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

  

}
