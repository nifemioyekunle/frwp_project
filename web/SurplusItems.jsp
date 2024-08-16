<%-- 
    Document   : SurplusItems
    Created on : 8 Apr 2024, 1:07:01 PM
    Author     : UsEr
--%>

<%@page import="JavaCode.InventoryItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Surplus Items</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .button {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-align: center;
        }
        .button.donate {
            background-color: #2196F3;
        }
        .button.sell {
            background-color: #FF9800;
        }
    </style>
</head>
<body>
    <h1>Surplus Items</h1>
    <table>
        <tr>
            <th>Item Name</th>
            <th>Quantity</th>
            <th>Expiration Date</th>
            <th>Action</th>
        </tr>
        <%
            List<InventoryItem> inventoryItems = (List<InventoryItem>) request.getAttribute("surplusItems");
            if (surplusItems != null && !surplusItems.isEmpty()) {
                for (InventoryItem item : surplusItems) {
        %>
        <tr>
            <td><%= item.getItemName() %></td>
            <td><%= item.getQuantity() %></td>
            <td><%= item.getExpirationDate() %></td>
            <td>
                <form action="SurplusActionServlet" method="post" style="display:inline;">
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    <button type="submit" name="action" value="donate" class="button donate">Donate</button>
                </form>
                <form action="SurplusActionServlet" method="post" style="display:inline;">
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    <button type="submit" name="action" value="sell" class="button sell">Sell</button>
                </form>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="4">No surplus items available.</td>
        </tr>
        <% } %>
    </table>
</body>
</html>
