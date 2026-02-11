<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    // Get current session, don't create new one
    HttpSession session2 = request.getSession(false);

    if (session != null) {
        try {
            session.invalidate(); // Logout user
        } catch (IllegalStateException e) {
            // Session already invalidated
            System.out.println("Session already invalidated: " + e.getMessage());
        }
    }

    // Redirect to homepage
    response.sendRedirect("index.jsp");
%>
