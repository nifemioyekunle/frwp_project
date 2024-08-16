<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Retailers Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: flex-start;
            height: 100vh;
            position: relative;
        }
        .notification {
            background-color: #dff0d8;
            color: #3c763d;
            padding: 15px;
            border: 1px solid #d6e9c6;
            border-radius: 4px;
            position: absolute;
            top: 20px;
            left: 50%;
            transform: translateX(-50%);
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            z-index: 1000;
            text-align: center;
            max-width: 600px;
            width: 80%;
        }
        .logout-container {
            position: absolute;
            top: 20px;
            left: 20px;
        }
        .logout-container form {
            margin: 0;
        }
        .logout-container button {
            background-color: #f44336;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s ease;
        }
        .logout-container button:hover {
            background-color: #d32f2f;
        }
        .container {
            width: 100%;
            max-width: 600px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin-top: 80px;
        }
        h1 {
            color: #4CAF50;
            margin-bottom: 20px;
        }
        .button-container {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        .button-container form {
            margin: 0;
        }
        .button-container button {
            background-color: #4CAF50;
            color: white;
            padding: 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }
        .button-container button:hover {
            background-color: #45a049;
            transform: scale(1.05);
        }
        .button-container button:active {
            transform: scale(1);
        }
    </style>
</head>
<body>
<%
    String successMessage = (String) session.getAttribute("successMessage");
    if (successMessage != null) {
%>
    <div class="notification">
        <p><%= successMessage %></p>
    </div>
<%
        session.removeAttribute("successMessage");  // Remove the message after displaying it
    }
%>
    <!-- Logout button container -->
    <div class="logout-container">
        <form action="Logout" method="get">
            <button type="submit">Logout</button>
        </form>
    </div>
    
    <!-- Main container for dashboard -->
    <div class="container">
        <h1>Retailers Dashboard</h1>
        <div class="button-container">
            <form action="InventoryServlet" method="get">
                <button type="submit" name="action" value="viewInventory">View Inventory</button>
            </form>
            <form action="InventoryServlet" method="get">
                <button type="submit" name="action" value="addItem">Add New Item</button>
            </form>
            <form action="InventoryServlet" method="get">
                <input type="hidden" name="userIdParam" value="2">

              <button type="submit" name="action" value="identifySurplus">Identify Surplus Items</button>
            </form>

<!--            <form action="SurplusInventoryServlet" method="get">
                <button type="submit" name="action" value="listSurplusItems">List Surplus Items</button>
            </form>-->
        </div>
    </div>
</body>
</html>
