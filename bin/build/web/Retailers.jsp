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
            margin: 0;
            padding: 0;
            background-image: url('images/back2.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            height: 100vh;
            display: flex;
            flex-direction: column;
        }
        nav {
            background-color: rgba(76, 175, 80, 0.9);
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        nav .logo {
            font-size: 24px;
            color: #fff;
            font-weight: bold;
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex;
            gap: 20px;
        }
        nav ul li {
            display: inline;
        }
        nav ul li a,
        nav ul li form button {
            color: #fff;
            text-decoration: none;
            font-size: 16px;
            background: none;
            border: none;
            cursor: pointer;
            transition: color 0.3s ease;
        }
        nav ul li a:hover,
        nav ul li form button:hover {
            color: #ffeb3b;
        }
        .container {
            width: 100%;
            max-width: 800px;
            background-color: rgba(255, 255, 255, 0.9);
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin: 100px auto;
        }
        h1 {
            color: #4CAF50;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <nav>
    <div class="logo">Retailers Dashboard</div>
    <ul>
        <li>
            <a href="InventoryServlet?action=viewInventory">View Inventory</a>
        </li>
        <li>
            <a href="InventoryServlet?action=addItem">Add New Item</a>
        </li>
        <li>
            <form action="InventoryServlet" method="get" style="display:inline;">
                <input type="hidden" name="userIdParam" value="2">
                <button type="submit" name="action" value="identifySurplus" style="background:none;border:none;color:white;font-size:16px;cursor:pointer;padding:0;">Identify Surplus Items</button>
            </form>
        </li>
        <li>
            <form action="Logout" method="get" style="display:inline;">
                <button type="submit" style="background:none;border:none;color:white;font-size:16px;cursor:pointer;">Logout</button>
            </form>
        </li>
    </ul>
</nav>


    <div class="container">
        <h1>Welcome to the Retailers Dashboard</h1>
        <p>Select an option from the navigation bar to proceed.</p>
    </div>
</body>
</html>
