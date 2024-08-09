<%-- 
    Document   : SurplusItems
    Created on : 8 Apr 2024, 1:07:01 PM
    Author     : UsEr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/Inventory.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Surplus Items</title>

</head>
<body>
    <h1>Surplus Items</h1>
    <div class="large-box">

    </div>
    
    <form action="Retailers.jsp" method="get"> 
        <div class="button-container">
            <button type="submit" name="action" value="goBack" class="back-button">PREVIOUS</button>
            <button class="add-button">ADD</button>
            <button class="update-button">UPDATE</button>
            <button class="delete-button">DELETE</button>
        </div>    
    </form>
</body>
</html>