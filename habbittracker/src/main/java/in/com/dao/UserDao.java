package in.com.dao;

import in.com.model.User;

public interface UserDao {
    User getUserByUsername(String username);
    void saveUser(User user);
}
