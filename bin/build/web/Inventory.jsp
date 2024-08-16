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
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
            color: #333;
        }

        .container {
            max-width: 1000px;
            margin: auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #444;
            margin-bottom: 30px;
            font-size: 24px;
        }

        /* Styling for the inventory table */
        .large-box {
            overflow-x: auto;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table thead {
            background-color: #007bff;
            color: white;
        }

        table th, table td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            font-size: 14px;
        }

        table tbody tr:hover {
            background-color: #f2f2f2;
        }

        .no-items {
            text-align: center;
            color: #888;
            font-style: italic;
            padding: 20px;
            font-size: 16px;
        }

        /* Button styling */
        .button-container {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        .button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            transition: background-color 0.3s ease, color 0.3s ease;
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

        .action-buttons {
            display: flex;
            gap: 10px;
        }

        .update-button {
            background-color: #ffc107;
            color: #333;
        }

        .update-button:hover {
            background-color: #e0a800;
            color: white;
        }

        .delete-button {
            background-color: #dc3545;
            color: white;
        }

        .delete-button:hover {
            background-color: #c82333;
        }

        /* Error and notification styling */
        .error-message {
            background-color: #f8d7da;
            color: #721c24;
            padding: 10px;
            border: 1px solid #f5c6cb;
            border-radius: 4px;
            margin-bottom: 20px;
            text-align: center;
            font-size: 14px;
        }

        /* Responsive design */
        @media (max-width: 768px) {
            table th, table td {
                padding: 12px;
                font-size: 12px;
            }

            .button-container {
                flex-direction: column;
                align-items: stretch;
            }

            .button {
                width: 100%;
                margin-bottom: 10px;
            }

            .action-buttons {
                flex-direction: column;
                gap: 5px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Inventory Management</h1>

        <!-- Display error message if any -->
        <c:if test="${not empty errorMessage}">
            <div class="error-message">
                <p>${errorMessage}</p>
            </div>
        </c:if>

        <div class="large-box">
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Expiration Date</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${inventoryItems}">
                        <tr>
                            <td>${item.itemName}</td>
                            <td>${item.quantity}</td>
                            <td>${item.expirationDate}</td>
                            <td class="action-buttons">
                                <!-- Update and Delete buttons for each item -->
                                <form action="UpdateItem.jsp" method="get" style="display:inline;">
                                    <input type="hidden" name="itemId" value="${item.itemId}">
                                    <button type="submit" class="button update-button">Update</button>
                                </form>
                                <form action="InventoryServlet" method="post" style="display:inline;" onsubmit="return confirmDelete();">
                                    <input type="hidden" name="action" value="deleteItem">
                                    <input type="hidden" name="itemId" value="${item.itemId}">
                                    <button type="submit" class="button delete-button">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty inventoryItems}">
                        <tr>
                            <td colspan="4" class="no-items">No inventory items found.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>

        <div class="button-container">
            <a href="Retailers.jsp" class="button back-button">Previous</a>
            <a href="AddItem.jsp" class="button add-button">Add Item</a>
        </div>
    </div>

    <script>
    function confirmDelete() {
        return confirm("Are you sure you want to delete this item?");
    }
    </script>
</body>
</html>
