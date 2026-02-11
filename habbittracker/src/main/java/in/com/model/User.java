package in.com.model;

public class User {

    private int userId;
    private String username;
    private String password;

    // Default constructor
    public User() {
    }

    // Parameterized constructor (optional)
    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + "]";
    }
}
