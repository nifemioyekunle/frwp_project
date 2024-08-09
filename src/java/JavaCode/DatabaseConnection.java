package JavaCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static volatile DatabaseConnection dbConnectionSingleton;
    private Connection connection = null;

    private final String serverUrl = "jdbc:mysql://localhost:3306/fwrp";
    private final String userString = "root";
    private final String passwordString = "Denis@2019!R$";
    private final String driverString = "com.mysql.cj.jdbc.Driver";

    private DatabaseConnection() throws SQLException {
        try {
            Class.forName(driverString);
            this.connection = DriverManager.getConnection(serverUrl, userString, passwordString);
        } catch (ClassNotFoundException ex) {
            throw new SQLException("Unable to load the JDBC driver.", ex);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (dbConnectionSingleton == null) {
            synchronized (DatabaseConnection.class) {
                if (dbConnectionSingleton == null) {
                    dbConnectionSingleton = new DatabaseConnection();
                }
            }
        }
        return dbConnectionSingleton;
    }

    public Connection getConnection() throws SQLException {
        if (this.connection == null || this.connection.isClosed()) {
            this.connection = DriverManager.getConnection(serverUrl, userString, passwordString);
        }
        return this.connection;
    }

    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
                this.connection = null;
                dbConnectionSingleton = null;
            } catch (SQLException ex) {
                System.out.println("Failed to close the connection: " + ex.getMessage());
            }
        }
    }
}
