package JavaCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SurplusFoodItemDAO {

    // Method to retrieve all surplus food items from the database
    public static List<SurplusFoodItem> getAllSurplusFoodItems() throws SQLException {
        List<SurplusFoodItem> items = new ArrayList<>();
        String sql = "SELECT * FROM SurplusFoodItem";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                SurplusFoodItem item = new SurplusFoodItem();
                item.setSurplusId(rs.getInt("surplus_item_id"));
                item.setRetailerId(rs.getInt("retailer_id"));
                item.setItemName(rs.getString("item_name"));
                item.setQuantity(rs.getInt("quantity"));
                item.setExpirationDate(rs.getDate("available_until").toLocalDate());
                item.setDonation(rs.getBoolean("is_donation"));
                item.setDiscountedPrice(rs.getBigDecimal("discounted_price"));
                items.add(item);
            }
        }

        return items;
    }

    // Method to update inventory after a purchase
    public static boolean updateInventoryAfterPurchase(int surplusId, int quantityPurchased) throws SQLException {
        String updateSurplusSql = "UPDATE SurplusFoodItem SET quantity = quantity - ? WHERE surplus_item_id = ? AND quantity >= ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement updateSurplusStmt = conn.prepareStatement(updateSurplusSql)) {

            conn.setAutoCommit(false); // Start transaction

            // Update SurplusFoodItem
            updateSurplusStmt.setInt(1, quantityPurchased);
            updateSurplusStmt.setInt(2, surplusId);
            updateSurplusStmt.setInt(3, quantityPurchased);
            int surplusRowsAffected = updateSurplusStmt.executeUpdate();

            if (surplusRowsAffected == 0) {
                conn.rollback(); // Rollback if update fails
                return false;
            }

            conn.commit(); // Commit the transaction
            return true;

        } catch (SQLException e) {
            throw e; // Propagate the exception to be handled by the caller
        }
    }
}
