<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="JavaCode.InventoryDAO, JavaCode.InventoryItem" %>
<%@ page import="java.sql.SQLException" %>
<%
    int itemId = Integer.parseInt(request.getParameter("itemId"));
    InventoryItem item = null;
    try {
        item = InventoryDAO.getInventoryItemById(itemId);
    } catch (SQLException e) {
        e.printStackTrace();
        request.setAttribute("errorMessage", "Error retrieving item details: " + e.getMessage());
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Inventory Item</title>
</head>
<body>
    <h1>Delete Inventory Item</h1>
    <form action="InventoryServlet" method="post">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="itemId" value="${item.itemId}">
        <p>Are you sure you want to delete the item: ${item.itemName}?</p>
        <button type="submit">Delete Item</button>
    </form>
</body>
</html>
