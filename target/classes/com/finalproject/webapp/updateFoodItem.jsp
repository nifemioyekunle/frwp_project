<!DOCTYPE html>
<html>
<head>
    <title>Update Food Item</title>
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
      input[type="text"],
      input[type="number"],
      input[type="date"],
      input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
      }
      input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s;
      }
      input[type="submit"]:hover {
        background-color: #45a049;
      }
    </style>
</head>
<body>
  <div class="container">
    <h1>Update Food Item</h1>
    <form action="retailer" method="post">
      <input type="hidden" name="action" value="updateFoodItem">
      <label for="id">Item ID:</label>
      <input type="number" id="id" name="id" required><br><br>
      <label for="name">Item Name:</label>
      <input type="text" id="name" name="name" required><br><br>
      <label for="quantity">New Quantity:</label>
      <input type="number" id="quantity" name="quantity" required><br><br>
      <label for="expirationDate">Expiration Date:</label>
      <input type="date" id="expirationDate" name="expirationDate" required><br><br>
      <input type="submit" value="Update Item">
    </form>
  </div>
</body>
</html>