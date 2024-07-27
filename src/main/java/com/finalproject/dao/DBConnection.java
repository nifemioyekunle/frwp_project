package com.finalproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

  private static DBConnection dbConnectionInstance;

  private Connection connection = null;

  private String serverUrl = "jdbc:mysql://localhost:3306/fwrp";
  private String username = "root";
  private String password = "root";
  private String driver = "com.mysql.cj.jdbc.Driver";

  private DBConnection() throws SQLException{
    try{
      Class.forName(driver);
      connection = DriverManager.getConnection(serverUrl, username, password);
    } catch (ClassNotFoundException | SQLException ex){
      System.out.println("Connection was not successful: " + ex.getMessage());
    }
  }

  public static DBConnection getInstance() throws SQLException{
   
    if(dbConnectionInstance == null){
      dbConnectionInstance = new DBConnection();
    }

    return dbConnectionInstance;
  }

  public Connection getConnection(){
    return connection;
  }
}
