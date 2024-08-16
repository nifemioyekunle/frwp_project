<%-- 
    Document   : 
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
         <title>Charitable Organization Page</title>
        <style>
            body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
    height: 100vh;
    display: flex;
    flex-direction: column;
}

.nav-bar {
    width: 100%;
    background-color: #28a745;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 15px 20px;
}

nav .logo {
    font-size: 24px;
    font-weight: bold;
    color: white;
}

nav .logout {
    background-color: white;
    color: #28a745;
    padding: 10px 20px;
    border: 2px solid #28a745;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s ease, color 0.3s ease;
}

nav .logout:hover {
    background-color: #28a745;
    color: white;
}


.container {
    width: 80%;
    margin: 50px auto;
    background-color: #fff;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

h1 {
    text-align: center;
    color: #28a745;
    margin-bottom: 30px;
}

table {
    width: 100%;
    border-collapse: collapse;
}

th, td {
    padding: 15px;
    border: 1px solid #ddd;
    text-align: left;
}

th {
    background-color: #28a745;
    color: white;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

.purchase-button {
    background-color: #28a745;
    color: white;
    padding: 10px 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 14px;
    transition: background-color 0.3s ease;
}

.purchase-button:hover {
    background-color: #218838;
}

.disabled {
    opacity: 0.5;
    cursor: not-allowed;
}

    
        </style>
    </head>
    <body>
        <div class="nav-bar">
            <nav>
                <div class="logo">DENSIL</div>
                <form action="Logout" method="get" style="margin: 0;">
                    <button type="submit" class="logout">Logout</button>
                </form>
            </nav>
        </div>

        <div class="container">
            <h1>Available Items for Donation</h1>
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
                            <form action="DonationServlet" method="post">
                                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                                <input type="hidden" name="quantity" value="1">
                                <% if(item.getQuantity() > 0) { %>
                                <button type="submit" class="purchase-button">Donate</button>
                                <% } else { %>
                                <button type="submit" class="disabled purchase-button" disabled>Donate</button>
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
