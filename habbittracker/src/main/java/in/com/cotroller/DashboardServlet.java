package in.com.cotroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.com.model.Habit;
import in.com.model.User;
import in.com.service.HabitService;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    private HabitService habitService = new HabitService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Habit> habits = habitService.getHabitsByUser(user.getUserId());
        request.setAttribute("habits", habits);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
