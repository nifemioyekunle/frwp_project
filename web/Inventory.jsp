<%-- 
    Document   : Inventory
    Created on : 8 Apr 2024, 1:00:14 PM
    Author     : UsEr
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory Management</title>
    <style>
        /* General styling for the page */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            width: 90%;
            max-width: 1200px;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        /* Styling for the inventory table */
        .large-box {
            overflow-x: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table thead {
            background-color: #28a745;
            color: white;
        }

        table th, table td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        table tbody tr:hover {
            background-color: #f1f1f1;
        }

        .no-items {
            text-align: center;
            color: #999;
            font-style: italic;
        }

        /* Button styling */
        .button-container {
            display: flex;
            justify-content: space-between;
        }

        .button {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            font-size: 14px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .back-button {
            background-color: #6c757d;
            color: white;
        }

        .back-button:hover {
            background-color: #5a6268;
        }

        .add-button {
            background-color: #28a745;
            color: white;
        }

        .add-button:hover {
            background-color: #218838;
        }

        .update-button {
            background-color: #ffc107;
            color: white;
        }

        .update-button:hover {
            background-color: #e0a800;
        }

        .delete-button {
            background-color: #dc3545;
            color: white;
        }

        .delete-button:hover {
            background-color: #c82333;
        }

        /* Responsive design */
        @media (max-width: 768px) {
            .button-container {
                flex-direction: column;
                gap: 10px;
            }

            .button {
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Inventory Management</h1>

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
                    <c:forEach var="item" items="${inventoryItems}">
                        <tr>
                            <td>${item.itemName}</td>
                            <td>${item.quantity}</td>
                            <td>${item.expirationDate}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty inventoryItems}">
                        <tr>
                            <td colspan="3" class="no-items">No inventory items found.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>

        <div class="button-container">
            <form action="Retailers.jsp" method="get"> 
                <button type="submit" name="action" value="goBack" class="button back-button">PREVIOUS</button>
            </form>
            <form action="AddItem.jsp" method="get">
                <button type="submit" class="button add-button">ADD</button>
            </form>
            <form action="UpdateItem.jsp" method="get">
                <button type="submit" class="button update-button">UPDATE</button>
            </form>
            <form action="DeleteItem.jsp" method="get">
                <button type="submit" class="button delete-button">DELETE</button>
            </form>
        </div>
    </div>
</body>
</html>
