<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Me Supreme - Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Login</h2>
<form action="login" method="post">
    <label>Username:</label>
    <input type="text" name="username" required><br><br>
    <label>Password:</label>
    <input type="password" name="password" required><br><br>
    <input type="submit" value="Login">
</form>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
</body>
</html>
