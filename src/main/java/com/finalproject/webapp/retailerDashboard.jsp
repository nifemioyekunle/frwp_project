<!DOCTYPE html>
<html>
<head>
  <title>Retailer Dashboard</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      height: 100vh;
        margin: 0;
    }
    .container {
      max-width: 400px;
      margin: 50px auto;
      padding: 20px;
      background: #fff;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      text-align: center;
    }
    a {
      display: block;
      margin: 10px 0;
      padding: 10px;
      background-color: #4CAF50;
      color: white;
      text-decoration: none;
      border-radius: 4px;
      transition: background-color 0.3s;
    }
    a:hover {
        background-color: #45a049;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>Retailer Dashboard</h1>
    <a href="addFoodItem.jsp">Add Food Item</a>
    <a href="updateFoodItem.jsp">Update Food Item</a>
    <a href="listSurplusFoodItems.jsp">List Surplus Food Items</a>
    <a href="index.jsp">Logout</a>
  </div>
</body>
</html>