package JavaCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {

    // Retrieve all inventory items
    public static List<InventoryItem> getAllInventoryItems() throws SQLException {
        List<InventoryItem> inventoryItems = new ArrayList<>();
        String sql = "SELECT * FROM inventoryitem";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                InventoryItem item = mapResultSetToInventoryItem(rs);
                inventoryItems.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error retrieving inventory items: " + e.getMessage());
        }
        return inventoryItems;
    }

    // Retrieve a single inventory item by ID
    public static InventoryItem getInventoryItemById(int itemId) throws SQLException {
        InventoryItem item = null;
        String sql = "SELECT * FROM inventoryitem WHERE item_id = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itemId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                item = mapResultSetToInventoryItem(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error retrieving item: " + e.getMessage());
        }
        return item;
    }

    // Add a new inventory item
    public static boolean addInventoryItem(InventoryItem item) throws SQLException {
        String sql = "INSERT INTO inventoryitem (item_name, quantity, expiration_date, retailer_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false); // Disable auto-commit for manual transaction control

            stmt.setString(1, item.getItemName());
            stmt.setInt(2, item.getQuantity());
            stmt.setDate(3, java.sql.Date.valueOf(item.getExpirationDate()));
            stmt.setInt(4, item.getRetailerId());

            int rowsAffected = stmt.executeUpdate();
            conn.commit(); // Commit the transaction manually

            System.out.println("Rows affected: " + rowsAffected);
            return rowsAffected > 0; // Return true if insertion was successful

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error adding inventory item: " + e.getMessage());
        }
    }

    // Update an existing inventory item
    public static boolean updateInventoryItem(InventoryItem item) throws SQLException {
        String sql = "UPDATE inventoryitem SET item_name = ?, quantity = ?, expiration_date = ?, retailer_id = ? WHERE item_id = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getItemName());
            stmt.setInt(2, item.getQuantity());
            stmt.setDate(3, java.sql.Date.valueOf(item.getExpirationDate()));
            stmt.setInt(4, item.getRetailerId());
            stmt.setInt(5, item.getItemId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error updating inventory item: " + e.getMessage());
        }
    }

    // Delete an inventory item
    public static boolean deleteInventoryItem(int itemId) throws SQLException {
        String sql = "DELETE FROM inventoryitem WHERE item_id = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itemId);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error deleting inventory item: " + e.getMessage());
        }
    }

    // Retrieve surplus items (those nearing expiration within the next 7 days)
    public static List<InventoryItem> getSurplusItems(int userId) throws SQLException {
    String sql = "SELECT * FROM inventoryitem WHERE retailer_id = ? AND expiration_date BETWEEN CURDATE() AND CURDATE() + INTERVAL 7 DAY";
    List<InventoryItem> surplusItems = new ArrayList<>();

    try (Connection conn = DatabaseConnection.getInstance().getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        int retailerId = new RetailersDAOImpl(conn).getRetailerIdByUserId(userId);
        System.out.println(retailerId);

        stmt.setInt(1, retailerId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            InventoryItem item = mapResultSetToInventoryItem(rs);
            surplusItems.add(item);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        throw new SQLException("Error retrieving surplus items: " + e.getMessage());
    }

    return surplusItems;
}

    // Helper method to map ResultSet data to InventoryItem object
    private static InventoryItem mapResultSetToInventoryItem(ResultSet rs) throws SQLException {
        return new InventoryItem(
            rs.getInt("item_id"),
            rs.getString("item_name"),
            rs.getInt("quantity"),
            rs.getDate("expiration_date").toLocalDate(),
            rs.getInt("retailer_id"),
            rs.getInt("item_id")
        );
    }
}
