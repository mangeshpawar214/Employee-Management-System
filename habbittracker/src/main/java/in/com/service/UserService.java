package in.com.service;

import in.com.dao.UserDao;
import in.com.dao.UserDaoImpl;
import in.com.model.User;

public class UserService {

    private UserDao userDao = new UserDaoImpl();

    // Login validation
    public User validateUser(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    // Optional: Register new user
    public boolean registerUser(User user) {
        User existingUser = userDao.getUserByUsername(user.getUsername());
        if (existingUser != null) {
            return false; // username already exists
        }
        userDao.saveUser(user);
        return true;
    }
}
