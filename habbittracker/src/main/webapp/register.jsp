<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register - Me Supreme</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Register New Account</h2>
<form action="register" method="post">
    <label>Username:</label>
    <input type="text" name="username" required><br><br>
    <label>Password:</label>
    <input type="password" name="password" required><br><br>
    <input type="submit" value="Register">
</form>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
<c:if test="${not empty success}">
    <p style="color:green">${success}</p>
</c:if>

<br>
<a href="login.jsp">Already have an account? Login</a>
</body>
</html>
