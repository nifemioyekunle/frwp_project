<%-- 
    Document   : SurplusInventory
    Created on : 8 Apr 2024, 1:02:48 PM
    Author     : Armando Mavova Bazeydio
--%>

<%@ page import="java.util.List" %>
<%@ page import="JavaCode.InventoryItem" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/Inventory.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Surplus Items Inventory</title>
</head>
<body>
    <h1>Surplus Inventory</h1>
    
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
            <c:forEach var="item" items="${surplusInventoryItems}">
                <tr>
                    <td>${item.itemName}</td>
                    <td>${item.quantity}</td>
                    <td>${item.expirationDate}</td>
                </tr>
            </c:forEach>
            <c:if test="${empty surplusInventoryItems}">
                <tr>
                    <td colspan="3">No surplus inventory items found.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>

    
    
    <form action="Retailers.jsp" method="get"> 
        <div class="button-container">
            <button type="submit" name="action" value="goBack" class="back-button">PREVIOUS</button>
        </div>    
    </form>
    
    


</body>
</html>
