<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Donation Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('images/Donate.jpeg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .confirmation-container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 40px 50px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            text-align: center;
            max-width: 500px;
            width: 100%;
            margin: 20px;
        }

        h1 {
            color: #28a745;
            font-size: 28px;
            margin-bottom: 20px;
            font-weight: bold;
        }

        p {
            font-size: 20px;
            margin-bottom: 30px;
            color: #333;
        }

        a {
            display: inline-block;
            padding: 14px 28px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-size: 18px;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        a:hover {
            background-color: #218838;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <div class="confirmation-container">
        <h1>Donation Successful</h1>
        <p>Thank you for your donation!</p>
        <a href="<%= request.getContextPath() %>/DonationServlet">Return to items</a>
    </div>
</body>
</html>
