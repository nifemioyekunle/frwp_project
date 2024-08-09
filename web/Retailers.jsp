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
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 100%;
            max-width: 600px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
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
                <button type="submit" name="action" value="identifySurplus">Identify Surplus Items</button>
            </form>
            <form action="SurplusInventoryServlet" method="get">
                <button type="submit" name="action" value="listSurplusItems">List Surplus Items</button>
            </form>
        </div>
    </div>
</body>
</html>
