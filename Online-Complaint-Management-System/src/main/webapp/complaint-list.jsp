<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Complaint List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
</head>
<body class="bg-light">
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="/index"><i class="bi bi-house-door"></i> OCMS</a>
            <div class="navbar-nav ms-auto">
                <a class="nav-link" href="/login"><i class="bi bi-box-arrow-in-right"></i> Login</a>
                <a class="nav-link" href="/"><i class="bi bi-plus-circle"></i> Add Complaint</a>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-info text-white text-center">
                <h2><i class="bi bi-list-ul"></i> All Complaints</h2>
            </div>
            <div class="card-body">
                <c:if test="${empty list}">
                    <p class="text-muted text-center">No complaints found.</p>
                </c:if>
                <c:forEach var="c" items="${list}">
                    <div class="card mb-3">
                        <div class="card-body">
                            <h5 class="card-title"><i class="bi bi-tag"></i> ${c.title}</h5>
                            <p class="card-text"><strong>Status:</strong> 
                                <span class="badge ${c.status == 'Resolved' ? 'bg-success' : 'bg-warning'}">${c.status}</span>
                            </p>
                            <p class="card-text">${c.description}</p>
                        </div>
                    </div>
                </c:forEach>
                <div class="text-center">
                    <a href="/" class="btn btn-primary"><i class="bi bi-plus-circle"></i> Add New Complaint</a>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>