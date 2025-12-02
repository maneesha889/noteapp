<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notes Application</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #74ebd5, #ACB6E5);
            margin: 0;
            padding: 0;
        }

        .container {
            width: 40%;
            margin: 120px auto;
            background: #ffffff;
            padding: 40px;
            border-radius: 12px;
            text-align: center;
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
        }

        h1 {
            color: #333;
        }

        p {
            color: #555;
            font-size: 16px;
        }

        .btn {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            border-radius: 6px;
            text-decoration: none;
            font-size: 14px;
            color: white;
        }

        .btn-primary {
            background: #007bff;
        }

        .btn-success {
            background: #28a745;
        }
    </style>

</head>
<body>

<div class="container">
    <h1>Notes Taking Application</h1>
    <p>Simple Spring Boot + JSP CRUD Project</p>

    <a href="add" class="btn btn-primary">➕ Add New Note</a>
    <a href="list" class="btn btn-success">📄 View All Notes</a>
</div>

</body>
</html>
