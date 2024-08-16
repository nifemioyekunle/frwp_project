<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="JavaCode.InventoryDAO, JavaCode.InventoryItem" %>
<%@ page import="java.sql.SQLException" %>
<%
    int itemId = Integer.parseInt(request.getParameter("itemId"));
    InventoryItem item = null;
    try {
        item = InventoryDAO.getInventoryItemById(itemId);
    } catch (SQLException e) {
        e.printStackTrace();
        request.setAttribute("errorMessage", "Error retrieving item details: " + e.getMessage());
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Inventory Item</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e8f5e9; /* Light green background */
            color: #333;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #388e3c; /* Dark green heading */
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }
        input[type="text"], input[type="number"], input[type="date"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            background-color: #388e3c; /* Dark green button */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #2e7d32; /* Darker green on hover */
        }
    </style>
</head>
<body>
    <h1>Update Inventory Item</h1>
    <form action="InventoryServlet" method="post">
        <input type="hidden" name="action" value="updateItem">
        <input type="hidden" name="itemId" value= "<%=itemId %>" >
        <label for="itemName">Item Name:</label>
        <input type="text" id="itemName" name="itemName" value= "<%=item.getItemName() %>" required><br>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" value= "<%= item.getQuantity() %>" required><br>
        <label for="expirationDate">Expiration Date:</label>
        <input type="date" id="expirationDate" name="expirationDate" value= "<%= item.getExpirationDate()%>" required><br>
        <label for="retailerId">Retailer ID:</label>
        <input type="number" id="retailerId" name="retailerId" value= "<%= item.getRetailerId() %>" required><br>
        <button type="submit">Update Item</button>
    </form>
</body>
</html>
