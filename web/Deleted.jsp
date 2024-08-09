<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Retry Page</title>
    <style>
        .wrapper{
            height: 100vh;
            width:100%;
            display: flex;
            align-items: center;
            justify-content: center;
            
            flex-direction: column;
        }
        .text{
            font-size: 40px;
        }
        .submit{
            height: 40px;
            width: 100px;
            color: black;
            background-color: white;
            border: 2px black solid;
            transition: 0.2s;
            border-radius: 20px;
        }  
        .submit:hover{
            color: white;
            background-color: black;
        }
    </style>
</head>
<body>
    <div class="wrapper">
    <h1 class="text">This user was deleted</h1>
    <form action="index.html">
        <button class="submit" type="submit">HOME</button>
    </form>
    </div>
</body>
</html>
