<%-- 
    Document   : consumer.jsp
    Created on : 08-Aug-2024, 2:19:03 pm
    Author     : Denis
--%>
<%@ page import="JavaCode.SurplusFoodItem" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Available Items for Purchase</title>
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
                width: 80%;
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            }
            h1 {
                text-align: center;
                color: #28a745;
                margin-bottom: 20px;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                padding: 12px;
                border: 1px solid #ddd;
                text-align: left;
            }
            th {
                background-color: #28a745;
                color: white;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            .purchase-button {
                background-color: #28a745;
                color: white;
                padding: 10px 15px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 14px;
            }
            .purchase-button:hover {
                background-color: #218838;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Available Items for Purchase</h1>
            <table>
                <thead>
                    <tr>
                        <th>Item Name</th>
                        <th>Quantity</th>
                        <th>Discounted Price</th>
                        <th>Purchase</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Retrieve the list of surplus items from the request
                        List<SurplusFoodItem> items = (List<SurplusFoodItem>) request.getAttribute("surplusInventoryItems");

                        // Check if the list is not null and contains items
                        if (items != null && !items.isEmpty()) {
                            for (SurplusFoodItem item : items) {
                    %>
                    <tr>
                        <td><%= item.getItemName() %></td>
                        <td><%= item.getQuantity() %></td>
                        <td>$<%= item.getDiscountedPrice() %></td>
                        <td>
                            <form action="PurchaseServlet" method="post">
                                <input type="hidden" name="itemId" value="<%= item.getSurplusId() %>">
                                <input type="hidden" name="quantity" value="1">
                                <button type="submit" class="purchase-button">Purchase</button>
                            </form>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="4" style="text-align:center;">No items available</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
