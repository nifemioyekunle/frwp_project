/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author UsEr
 */

public class RetailersDAOImpl implements RetailersDAO{
    
    private Connection connection;

    public RetailersDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createRetailer(Retailers retailer) {
        String query = "INSERT INTO retailers (user_id) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, retailer.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Retailers getRetailerById(int id) {
        String query = "SELECT * FROM retailers WHERE retailer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Retailers retailer = new Retailers();
                retailer.setId(resultSet.getInt("retailer_id"));
                retailer.setUserId(resultSet.getInt("user_id"));
                return retailer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Retailers> getAllRetailers() {
        List<Retailers> retailers = new ArrayList<>();
        String query = "SELECT * FROM retailers";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Retailers retailer = new Retailers();
                retailer.setId(resultSet.getInt("retailer_id"));
                retailer.setUserId(resultSet.getInt("user_id"));
                retailers.add(retailer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retailers;
    }

    @Override
    public void updateRetailer(Retailers retailer) {
        String query = "UPDATE retailers SET user_id = ? WHERE retailer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, retailer.getUserId());
            statement.setInt(2, retailer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRetailer(int id) {
        String query = "DELETE FROM retailers WHERE retailer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
