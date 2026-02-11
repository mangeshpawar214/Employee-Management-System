package in.com.cotroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.com.model.Habit;
import in.com.model.User;
import in.com.service.HabitService;

@WebServlet("/habit")
public class HabitServlet extends HttpServlet {

    private HabitService habitService = new HabitService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String habitName = request.getParameter("habitName");
        int monthlyGoal = Integer.parseInt(request.getParameter("monthlyGoal"));

        Habit habit = new Habit();
        habit.setHabitName(habitName);
        habit.setMonthlyGoal(monthlyGoal);
        habit.setUserId(user.getUserId());

        habitService.addHabit(habit);

        response.sendRedirect("dashboard.jsp");
    }
}
