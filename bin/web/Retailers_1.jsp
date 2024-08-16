<%-- 
    Document   : Retailers
    Created on : 8 Apr 2024, 12:12:26 PM
    Author     : UsEr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/RetailersCSS.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RetailersHUB</title>
</head>
<body>
    <h1>Retailers HUB</h1>
    <form action="RetailersServlet" method="get">
        <button type="submit" name="action" value="viewInventory" id="view-btn">VIEW INVENTORY</button>
        <button type="submit" name="action" value="viewSurplus" id="surplus-btn">VIEW SURPLUS INVENTORY</button>
        <button type="submit" name="action" value="listSurplusItems" id="list-btn">LIST SURPLUS ITEMS</button>
    </form>

</body>
</html>