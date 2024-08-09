package JavaCode;

import java.time.LocalDate;

public class InventoryItem {
    private int itemId;
    private String itemName;
    private int quantity;
    private LocalDate expirationDate;
    private int retailerId;
    private int inventoryItemId;

    // Constructor for creating new items
    public InventoryItem(String itemName, int quantity, LocalDate expirationDate, int retailerId, int inventoryItemId) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.retailerId = retailerId;
        this.inventoryItemId = inventoryItemId;
    }

    // Constructor for retrieving items from the database (includes itemId)
    public InventoryItem(int itemId, String itemName, int quantity, LocalDate expirationDate, int retailerId, int inventoryItemId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.retailerId = retailerId;
        this.inventoryItemId = inventoryItemId;
    }

    // Getters and setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public int getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(int inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", expirationDate=" + expirationDate +
                ", retailerId=" + retailerId +
                ", inventoryItemId=" + inventoryItemId +
                '}';
    }
}
