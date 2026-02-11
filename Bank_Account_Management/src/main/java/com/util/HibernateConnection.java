package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {

    private static SessionFactory sessionFactory;

    
    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                Configuration cfg = new Configuration();
                cfg.configure("hibernate.cfg.xml"); 

                sessionFactory = cfg.buildSessionFactory();
            } catch (Exception e)
            {
                System.out.println("Hibernate Connection Failed");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
