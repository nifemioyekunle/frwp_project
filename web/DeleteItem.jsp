<%-- 
    Document   : DeleteItem
    Created on : 8 Apr 2024, 6:38:36 PM
    Author     : UsEr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Item</title>
</head>
<body>
    <h1>Delete Item</h1>

    <!-- Form to delete item -->
    <form action="InventoryServlet" method="post">
        <input type="hidden" name="action" value="delete">
        <label for="itemName">Item Name:</label>
        <input type="text" id="itemName" name="itemName">
        <button type="submit">Delete</button>
    </form>
</body>
</html>