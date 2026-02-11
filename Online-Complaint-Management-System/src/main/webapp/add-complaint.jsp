<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Complaint</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
</head>
<body class="bg-light">
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="/index"><i class="bi bi-house-door"></i> OCMS</a>
            <div class="navbar-nav ms-auto">
                <a class="nav-link" href="/login"><i class="bi bi-box-arrow-in-right"></i> Login</a>
                <a class="nav-link" href="/list"><i class="bi bi-list-ul"></i> View Complaints</a>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow">
                    <div class="card-header bg-success text-white text-center">
                        <h2><i class="bi bi-plus-circle"></i> Add New Complaint</h2>
                    </div>
                    <div class="card-body">
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger"><i class="bi bi-exclamation-triangle"></i> ${error}</div>
                        </c:if>
                        <c:if test="${not empty message}">
                            <div class="alert alert-success"><i class="bi bi-check-circle"></i> ${message}</div>
                        </c:if>
                        <form action="/save" method="post">
                            <div class="mb-3">
                                <label for="title" class="form-label"><i class="bi bi-tag"></i> Title</label>
                                <input type="text" class="form-control" id="title" name="title" required>
                            </div>
                            <div class="mb-3">
                                <label for="description" class="form-label"><i class="bi bi-textarea"></i> Description</label>
                                <textarea class="form-control" id="description" name="description" rows="4" required></textarea>
                            </div>
                            <div class="d-grid">
                                <button type="submit" class="btn btn-success"><i class="bi bi-send"></i> Submit Complaint</button>
                            </div>
                        </form>
                        <div class="text-center mt-3">
                            <a href="/list" class="btn btn-link"><i class="bi bi-list-ul"></i> View All Complaints</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>