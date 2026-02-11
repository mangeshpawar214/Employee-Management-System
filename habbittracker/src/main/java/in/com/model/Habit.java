package in.com.model;

public class Habit {

    private int habitId;
    private String habitName;
    private int monthlyGoal;
    private int userId;

    // Getters and Setters
    public int getHabitId() {
        return habitId;
    }

    public void setHabitId(int habitId) {
        this.habitId = habitId;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public int getMonthlyGoal() {
        return monthlyGoal;
    }

    public void setMonthlyGoal(int monthlyGoal) {
        this.monthlyGoal = monthlyGoal;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
