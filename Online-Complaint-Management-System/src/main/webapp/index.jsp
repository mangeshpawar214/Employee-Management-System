<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Complaint Management System</title>
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
                <a class="nav-link" href="/list"><i class="bi bi-list-ul"></i> View Complaints</a>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card shadow">
                    <div class="card-header bg-primary text-white text-center">
                        <h2><i class="bi bi-info-circle"></i> Welcome to Online Complaint Management System</h2>
                    </div>
                    <div class="card-body text-center">
                        <p class="lead">Manage your complaints easily. Add new ones, view existing ones, or log in as an admin to resolve them.</p>
                        <div class="d-grid gap-2 d-md-flex justify-content-md-center">
                            <a href="/login" class="btn btn-primary me-md-2"><i class="bi bi-box-arrow-in-right"></i> Login</a>
                            <a href="/" class="btn btn-success"><i class="bi bi-plus-circle"></i> Add Complaint</a>
                            <a href="/list" class="btn btn-info"><i class="bi bi-list-ul"></i> View Complaints</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>