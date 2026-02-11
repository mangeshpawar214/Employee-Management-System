<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Me Supreme | Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/main.js"></script>
</head>

<body>

<div class="dashboard">

    <!-- Header -->
    <div class="header">
        <h1>🔥 Me Supreme Dashboard</h1>
        <p>Welcome, <b>${sessionScope.currentUser.username}</b></p>
        <a class="logout-btn" href="logout.jsp">Logout</a>
    </div>

    <!-- Stats -->
    <div class="stats">
        <div class="card">
            <h3>Total Habits</h3>
            <p>${habits.size()}</p>
        </div>
        <div class="card">
            <h3>Month</h3>
            <p>Current</p>
        </div>
        <div class="card">
            <h3>Consistency</h3>
            <p>🔥</p>
        </div>
    </div>

    <!-- Habits Table -->
    <div class="habit-section">
        <h2>Your Habits</h2>

        <table>
            <tr>
                <th>Habit</th>
                <th>Monthly Goal</th>
            </tr>

            <c:forEach var="h" items="${habits}">
                <tr>
                    <td>${h.habitName}</td>
                    <td>${h.monthlyGoal} days</td>
                </tr>
            </c:forEach>
        </table>

        <br>
        <a href="addHabit.jsp" class="add-btn">➕ Add New Habit</a>
    </div>

</div>

</body>
</html>
