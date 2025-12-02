<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Notes List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
        }
        .container {
            width: 70%;
            margin: 40px auto;
            background: #ffffff;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .btn {
            padding: 8px 14px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 14px;
        }
        .btn-primary {
            background: #007bff;
            color: white;
        }
        .btn-danger {
            background: #dc3545;
            color: white;
        }
        .btn-edit {
            background: #17a2b8;
            color: white;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th {
            background: #343a40;
            color: white;
            padding: 10px;
            text-align: left;
        }
        td {
            padding: 8px;
        }
        .top-bar {
            text-align: right;
            margin-bottom: 10px;
        }
        .top-bar a {
            margin-left: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>My Notes</h2>

    <div class="top-bar">
        <a href="add" class="btn btn-primary">+ Add New Note</a>
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="note" items="${notes}">
            <tr>
                <td>${note.id}</td>
                <td>${note.title}</td>
                <td>
                    <a class="btn btn-edit" href="edit/${note.id}">Edit</a>
                    <a class="btn btn-danger" href="delete/${note.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
