<%@ page import="java.util.List" %>
<%@ page import="com.yourpackage.model.FoodItem" %>
<!DOCTYPE html>
<html>
<head>
    <title>Surplus Food Items</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Surplus Food Items</h1>
    <table>
        <thead>
            <tr>
                <th>Item ID</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Expiration Date</th>
            </tr>
        </thead>
        <tbody>
            <%
                RetailerService retailerService = new RetailerService(new FoodItemDAO());
                Retailer retailer = (Retailer) session.getAttribute("user");
                List<FoodItem> surplusFoodItems = retailerService.listSurplusFoodItems(retailer);
                if (surplusFoodItems != null && !surplusFoodItems.isEmpty()) {
                    for (FoodItem item : surplusFoodItems) {
            %>
                        <tr>
                            <td><%= item.getId() %></td>
                            <td><%= item.getName() %></td>
                            <td><%= item.getQuantity() %></td>
                            <td><%= item.getExpirationDate() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="4">No surplus food items available.</td>
                    </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <br>
    <a href="retailerDashboard.jsp">Back to Dashboard</a>
</body>
</html>
