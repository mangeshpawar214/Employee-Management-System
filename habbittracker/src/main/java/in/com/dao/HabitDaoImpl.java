package in.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import in.com.config.SpringConfig;
import in.com.model.Habit;

public class HabitDaoImpl implements HabitDao {

    private JdbcTemplate jdbcTemplate;

    public HabitDaoImpl() {
        jdbcTemplate = new SpringConfig().jdbcTemplate();
    }

    @Override
    public void addHabit(Habit habit) {
        String sql = "INSERT INTO habits (habit_name, monthly_goal, user_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, habit.getHabitName(), habit.getMonthlyGoal(), habit.getUserId());
    }

    @Override
    public List<Habit> getHabitsByUser(int userId) {
        String sql = "SELECT * FROM habits WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new RowMapper<Habit>() {
            @Override
            public Habit mapRow(ResultSet rs, int rowNum) throws SQLException {
                Habit habit = new Habit();
                habit.setHabitId(rs.getInt("habit_id"));
                habit.setHabitName(rs.getString("habit_name"));
                habit.setMonthlyGoal(rs.getInt("monthly_goal"));
                habit.setUserId(rs.getInt("user_id"));
                return habit;
            }
        });
    }

    @Override
    public int getCompletedDays(int habitId) {
        String sql = "SELECT COUNT(*) FROM habit_logs WHERE habit_id = ? AND status = TRUE";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{habitId}, Integer.class);
        return count != null ? count : 0;
    }

    @Override
    public int getTotalDays(int habitId) {
        String sql = "SELECT COUNT(*) FROM habit_logs WHERE habit_id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{habitId}, Integer.class);
        return count != null ? count : 0;
    }
}
