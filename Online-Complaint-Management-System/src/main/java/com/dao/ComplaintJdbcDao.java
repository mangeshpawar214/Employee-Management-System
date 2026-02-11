package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.entity.Complaint;

@Repository
public class ComplaintJdbcDao {

    @Autowired
    private JdbcTemplate jt;

    public int save(Complaint c) {
        try {
            return jt.update("insert into complaint(title, description, status) values(?, ?, ?)",
                             c.getTitle(), c.getDescription(), "Pending");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}