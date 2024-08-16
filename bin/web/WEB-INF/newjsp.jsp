<%-- 
    Document   : newjsp
    Created on : 05-Apr-2024, 11:40:49 pm
    Author     : SHIVANI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login or Register Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }
    .container {
        max-width: 400px;
        margin: 50px auto;
        padding: 20px;
        background: #fff;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        transition: 0.5s cubic-bezier(0.075, 0.82, 0.165, 1);
        display: none;
    }
    input[type="text"],
    input[type="password"],
    input[type="email"],
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
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    .buttonWrapper{
        margin-top: 100px;
    }
    .login,.register{
        height: 40px;
        width:100px;
        border-radius: 40px;
        font-size: 15px;
        transition: 0.5s cubic-bezier(0.075, 0.82, 0.165, 1);
    }
    .login:hover,.register:hover{
        background-color: #6dbf71;
    }
    .userType{
    	width: 100%;
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
</style>
</head>
<body>
<div class="buttonWrapper">
<button class="login" onclick="toggleForm('login')">Login</button>
<button class="register" onclick="toggleForm('register')">Register</button>
</div>

<div id="loginForm" class="container">
    <h2>Login</h2>
    <form action="NewServalet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        
        <label for="userType">Select User Type:</label>
        
        <select id="userType" class="userType" name="userType">
            <option value="user">User</option>
            <option value="retailer">Retailer</option>
            <option value="charitableOrganization">Charitable Organization</option>
        </select>

        <input type="submit" value="Login">
    </form>
</div>

<div id="registerForm" class="container">
    <h2>Register</h2>
    <form action="NewServalet" method="post">
        <label for="reg_username">Username:</label>
        <input type="text" id="reg_username" name="reg_username" required>

        <label for="reg_email">Email:</label>
        <input type="email" id="reg_email" name="reg_email" required>

        <label for="reg_password">Password:</label>
        <input type="password" id="reg_password" name="reg_password" required>
        
        <label for="userType">Select User Type:</label>
        <select id="userType" class="userType" name="userType">
            <option value="consumer">Consumer</option>
            <option value="retailer">Retailer</option>
            <option value="charitableOrganization">Charitable Organization</option>
        </select>

        <input type="submit" value="Register">
    </form>
</div>

<script>
function toggleForm(formType) {
    var loginForm = document.getElementById('loginForm');
    var registerForm = document.getElementById('registerForm');

    if (formType === 'login') {
        loginForm.style.display = 'block';
        registerForm.style.display = 'none';
    } else if (formType === 'register') {
        loginForm.style.display = 'none';
        registerForm.style.display = 'block';
    }
}
</script>

</body>