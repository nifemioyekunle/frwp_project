<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notifications</title>
</head>
<body>
    <h1>Notifications</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>User Type</th>
            <th>Message</th>
            <th>Created At</th>
            <th>Read Status</th>
            <th>User Type 2</th>
        </tr>
        <c:forEach var="notification" items="${notifications}">
            <tr>
                <td>${notification.id}</td>
                <td>${notification.userType}</td>
                <td>${notification.message}</td>
                <td>${notification.createdAt}</td>
                <td>${notification.readStatus}</td>
                <td>${notification.userType2}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
