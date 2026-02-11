package in.com.service;

import java.util.List;

import in.com.dao.HabitDao;
import in.com.dao.HabitDaoImpl;
import in.com.model.Habit;

public class HabitService {

    private HabitDao habitDao = new HabitDaoImpl();

    // Add new habit
    public void addHabit(Habit habit) {
        habitDao.addHabit(habit);
    }

    // Get all habits of a user
    public List<Habit> getHabitsByUser(int userId) {
        return habitDao.getHabitsByUser(userId);
    }

    // Optional: Calculate completion percentage
    public double calculateCompletion(int habitId) {
        int completedDays = habitDao.getCompletedDays(habitId);
        int totalDays = habitDao.getTotalDays(habitId);
        if (totalDays == 0) return 0;
        return (completedDays * 100.0) / totalDays;
    }
}
