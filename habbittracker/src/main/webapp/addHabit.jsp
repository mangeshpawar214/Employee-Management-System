<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Habit - Me Supreme</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Add New Habit</h2>
<form action="habit" method="post">
    <label>Habit Name:</label>
    <input type="text" name="habitName" required><br><br>
    <label>Monthly Goal:</label>
    <input type="number" name="monthlyGoal" required><br><br>
    <input type="submit" value="Add Habit">
</form>
<br>
<a href="dashboard.jsp">Back to Dashboard</a>
</body>
</html>
