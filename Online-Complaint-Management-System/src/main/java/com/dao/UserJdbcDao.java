package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.entity.User;

@Repository
public class UserJdbcDao {

    @Autowired
    private JdbcTemplate jt;

    public User login(String email, String password) {
        try {
            return jt.queryForObject("select * from users where email=? and password=?",
                                     new BeanPropertyRowMapper<>(User.class), email, password);
        } catch (Exception e) {
            return null;
        }
    }
}