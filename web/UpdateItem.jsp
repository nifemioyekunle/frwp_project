<%-- 
    Document   : UpdateItem
    Created on : 8 Apr 2024, 6:36:54 PM
    Author     : UsEr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Item</title>
</head>
<body>
    <h1>Update Item</h1>

    <!-- Form to update item -->
    <form action="InventoryServlet" method="post">
        <input type="hidden" name="action" value="update">
        <label for="updatedItemName">Item Name:</label>
        <input type="text" id="updatedItemName" name="updatedItemName">
        <label for="updatedQuantity">Quantity:</label>
        <input type="number" id="updatedQuantity" name="updatedQuantity">
        <label for="updatedExpirationDate">Expiration Date:</label>
        <input type="date" id="updatedExpirationDate" name="updatedExpirationDate">
        <button type="submit">Update</button>
    </form>
</body>