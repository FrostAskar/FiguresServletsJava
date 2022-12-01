<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body>

    <div id="loginForm">
        <h1>Login</h1>

        <form method="post" action="/login">
            <label for="user">Username</label>
            <input type="text" id="user" name="userName" required>
            <input type="submit" value="Access">
        </form>
    </div>

</body>
</html>