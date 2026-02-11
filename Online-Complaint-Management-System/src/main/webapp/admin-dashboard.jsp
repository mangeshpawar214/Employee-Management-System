<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
</head>
<body class="bg-light">
    <nav class="navbar navbar-expand-lg navbar-dark bg-danger">
        <div class="container">
            <a class="navbar-brand" href="/admin/dashboard"><i class="bi bi-shield-check"></i> Admin Panel</a>
            <div class="navbar-nav ms-auto">
                <a class="nav-link" href="/logout"><i class="bi bi-box-arrow-right"></i> Logout</a>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-danger text-white text-center">
                <h2><i class="bi bi-list-check"></i> Manage Complaints</h2>
            </div>
            <div class="card-body">
                <c:if test="${not empty message}">
                    <div class="alert alert-success"><i class="bi bi-check-circle"></i> ${message}</div>
                </c:if>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger"><i class="bi bi-exclamation-triangle"></i> ${error}</div>
                </c:if>
                <c:if test="${empty list}">
                    <p class="text-muted text-center">No complaints to manage.</p>
                </c:if>
                <c:forEach var="c" items="${list}">
                    <div class="card mb-3">
                        <div class="card-body">
                            <h5 class="card-title"><i class="bi bi-tag"></i> ${c.title}</h5>
                            <p class="card-text"><strong>Status:</strong> 
                                <span class="badge ${c.status == 'Resolved' ? 'bg-success' : 'bg-warning'}">${c.status}</span>
                            </p>
                            <p class="card-text">${c.description}</p>
                            <c:if test="${c.status != 'Resolved'}">
                                <a href="/admin/resolve/${c.id}" class="btn btn-success btn-sm"><i class="bi bi-check2-circle"></i> Resolve</a>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>