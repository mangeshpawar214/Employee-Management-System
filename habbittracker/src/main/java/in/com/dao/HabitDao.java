package in.com.dao;

import java.util.List;
import in.com.model.Habit;

public interface HabitDao {
    void addHabit(Habit habit);
    List<Habit> getHabitsByUser(int userId);
    int getCompletedDays(int habitId);
    int getTotalDays(int habitId);
}
