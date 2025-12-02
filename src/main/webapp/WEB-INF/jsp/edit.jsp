<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Note</title>
    <style>
        body { font-family: Arial, sans-serif; background:#f4f6f9; }
        .container {
            width: 40%;
            margin: 60px auto;
            background: #ffffff;
            padding: 25px 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h2 { text-align:center; color:#333; }
        label { display:block; margin-bottom:5px; font-weight:bold; }
        input[type="text"] {
            width:100%;
            padding:8px;
            margin-bottom:15px;
            border-radius:5px;
            border:1px solid #ccc;
        }
        .btn {
            padding:8px 14px;
            border:none;
            border-radius:5px;
            cursor:pointer;
            font-size:14px;
        }
        .btn-primary { background:#28a745; color:white; }
        .btn-secondary { background:#6c757d; color:white; text-decoration:none; padding:8px 14px; }
    </style>
</head>
<body>
<div class="container">
    <h2>Edit Note</h2>
    <form action="/update" method="post">
        <input type="hidden" name="id" value="${note.id}" />
        <label>Title</label>
        <input type="text" name="title" value="${note.title}" required />
        <button type="submit" class="btn btn-primary">Update</button>
        <a href="/list" class="btn-secondary">Back to List</a>
    </form>
</div>
</body>
</html>
