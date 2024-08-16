<%-- 
    Document   : consumer.jsp
    Created on : 08-Aug-2024, 2:19:03 pm
    Author     : Denis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="JavaCode.InventoryItem" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Available Items for Purchase</title>
        <style>
    body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: #e9ecef;
    margin: 0;
    padding: 0;
}

.navbar {
    width: 100%;
    background-color: #28a745;
    padding: 10px 0;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    display: flex;
    justify-content: space-between;
    align-items: center;
    position: fixed;
    top: 0;
    left: 0;
    z-index: 1000;
}

.navbar h2 {
    color: white;
    margin-left: 20px;
    font-size: 24px;
}

.logout-button {
    background-color: #ffffff;
    color: #28a745;
    padding: 8px 16px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 15px;
    margin-right: 20px;
    transition: background-color 0.3s ease;
}

.logout-button:hover {
    background-color: #f8f9fa;
}

.container {
    width: 80%;
    background-color: #ffffff;
    padding: 25px;
    border-radius: 10px;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
    margin: 70px auto; /* Adjusted to remove extra space between navbar and content */
}

h1 {
    text-align: center;
    color: #28a745;
    margin-bottom: 20px;
    font-size: 28px;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

th, td {
    padding: 15px;
    border: 1px solid #dee2e6;
    text-align: left; /* Ensure left alignment for text */
    font-size: 16px;
    vertical-align: middle; /* Align content vertically in the middle */
}

td {
    text-align: center; /* Center-align content inside table cells */
}

th {
    background-color: #28a745;
    color: white;
    font-weight: 600;
}

tr:nth-child(even) {
    background-color: #f8f9fa;
}

tr:hover {
    background-color: #f1f1f1;
}

.purchase-button {
    background-color: #28a745;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 15px;
    transition: background-color 0.3s ease;
    display: inline-block; /* Ensure buttons are inline-block for better control */
}

.purchase-button:hover {
    background-color: #218838;
}

.disabled {
    opacity: 0.6;
    cursor: not-allowed;
}

.disabled:hover {
    background-color: #28a745;
}

</style>

    </head>
    <body>
        <!-- Navigation Bar -->
<div class="navbar">
    <h2>Consumer Page</h2>
        <form action="Logout" method="get">
        <button type="submit" class="logout-button">Log Out</button>
    </form>
</div>

        <div class="container">
            <h1>Available Items for Purchase</h1>
            <table>
                <thead>
                    <tr>
                        <th>Item Name</th>
                        <th>Quantity</th>
                        <th>Purchase</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Retrieve the list of surplus items from the request
                        List<InventoryItem> items = (List<InventoryItem>) request.getAttribute("inventoryItems");

                        // Check if the list is not null and contains items

                        
                        if (items != null && !items.isEmpty()) {
                            for (InventoryItem item : items) {
                    %>
                    <tr>
                        <td><%= item.getItemName() %></td>
                        <td><%= item.getQuantity() %></td>
                        <td>
                            <form action="PurchaseServlet" method="post">
                                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                                <input type="hidden" name="quantity" value="1">
                                <% if(item.getQuantity() > 0) { %>
                                <button type="submit" class="purchase-button">Purchase</button>
                                <% } else { %>
                                <button type="submit" class="disabled purchase-button" disabled>Purchase</button>
                                <% } %>
                                
                            </form>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="4" style="text-align:center;">No items available</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
