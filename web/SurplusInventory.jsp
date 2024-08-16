<%-- 
    Document   : SurplusInventory
    Created on : 8 Apr 2024, 1:02:48 PM
    Author     : Denis, Ritman, Ilan
--%>

<%@ page import="java.util.List" %>
<%@ page import="JavaCode.InventoryItem" %>
<%@ page import="JavaCode.SurplusFoodItem" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Surplus Items Inventory</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #4CAF50;
        }
        .large-box {
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            max-width: 800px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th.header {
            background-color: #4CAF50;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .button-container {
            text-align: center;
            margin-top: 20px;
        }
        .back-button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        .back-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Surplus Get Surplus</h1>
    
    <div class="large-box">
        <table>
            <thead>
                <tr>
                    <th class="header">Name</th>
                    <th class="header">Quantity</th>
                    <th class="header">Expiration Date</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<InventoryItem> surplusItems = (List<InventoryItem>) request.getAttribute("surplusItems");
                    if (surplusItems != null && !surplusItems.isEmpty()) {
                        for (InventoryItem item : surplusItems) {
                %>
                            <tr>
                                <td><%= item.getItemName() %></td>
                                <td><%= item.getQuantity() %></td>
                                <td><%= item.getExpirationDate() %></td>
                            </tr>
                <%
                        }
                    } else {
                %>
                        <tr>
                            <td colspan="3">No surplus inventory items found.</td>
                        </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>

    <form action="Retailers.jsp" method="get"> 
        <div class="button-container">
            <button type="submit" name="action" value="goBack" class="back-button">Previous</button>
        </div>    
    </form>
</body>
</html>
