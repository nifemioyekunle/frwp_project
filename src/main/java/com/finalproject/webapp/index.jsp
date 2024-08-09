<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
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
    .login,.register,.delete{
        height: 40px;
        margin: 10px;
        width:100px;
        border-radius: 40px;
        font-size: 15px;
        transition: 0.5s cubic-bezier(0.075, 0.82, 0.165, 1);
    }
    .login:hover,.register:hover{ /*,.delete:hover*/
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
<!-- <button class="delete" onclick="toggleForm('delete')">Delete</button> -->
</div>

<div id="loginForm" class="container">
  <h2>Login</h2>
  <form action="/user" method="post">
    <input type="hidden" name="action" value="login">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    
    <label for="userType">Select User Type:</label>
    
    <select id="userType" class="userType" name="userType">
      <option value="consumer">Consumer</option>
      <option value="retailer">Retailer</option>
      <option value="charitableOrganization">Charitable Organization</option>
    </select>

    <input type="submit" value="Login">
  </form>
</div>

<div id="registerForm" class="container">
  <h2>Register</h2>
  <form action="/user" method="post">
    <input type="hidden" name="action" value="register">
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
    
<!-- <div id="deleteForm" class="container">
    <h2>Delete</h2>
    <form action="Delete" method="post">
        <label for="del_username">Username:</label>
        <input type="text" id="del_username" name="del_username" required>
        <label for="del_password">Password:</label>
        <input type="password" id="del_password" name="del_password" required>
        <input type="submit" value="Delete">
        
    </form>
</div> -->

<script>
function toggleForm(formType) {
  var loginForm = document.getElementById('loginForm');
  var registerForm = document.getElementById('registerForm');
  // var deleteForm = document.getElementById('deleteForm');


  if (formType === 'login') {
    loginForm.style.display = 'block';
    registerForm.style.display = 'none';
    deleteForm.style.display="none";
  } else if (formType === 'register') {
    loginForm.style.display = 'none';
    registerForm.style.display = 'block';
    deleteForm.style.display="none";

  }
    //  else if (formType === 'delete') {
    //     loginForm.style.display = 'none';
    //     registerForm.style.display = 'none';
    //     deleteForm.style.display="block";
    // }
}
</script>

</body>