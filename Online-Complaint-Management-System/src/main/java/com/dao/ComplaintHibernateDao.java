package com.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entity.Complaint;

@Repository
@Transactional
public class ComplaintHibernateDao {

    @Autowired
    private SessionFactory sf;

    public List<Complaint> getAll() {
        try {
            return sf.getCurrentSession().createQuery("from Complaint", Complaint.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public void updateStatus(int id, String status) {
        try {
            sf.getCurrentSession()
               .createQuery("update Complaint set status=:s where id=:i")
               .setParameter("s", status)
               .setParameter("i", id)
               .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}