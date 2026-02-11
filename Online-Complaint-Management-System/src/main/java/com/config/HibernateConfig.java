package com.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement

public class HibernateConfig {

    @Bean
    public DataSource ds() {
        DriverManagerDataSource d = new DriverManagerDataSource();
        d.setDriverClassName("com.mysql.cj.jdbc.Driver");
        d.setUrl("jdbc:mysql://localhost:3306/cmsdb");
        d.setUsername("root");
        d.setPassword("Mangesh@0214");
        return d;
    }

    @Bean
    public SessionFactory sf() {
        LocalSessionFactoryBuilder b = new LocalSessionFactoryBuilder(ds());
        b.scanPackages("com.entity");
        b.addProperties(props());
        return b.buildSessionFactory();
    }

    private Properties props() {
        Properties p = new Properties();
        p.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        p.put("hibernate.show_sql", "true");
        p.put("hibernate.hbm2ddl.auto", "update");
        return p;
    }

    @Bean
    public JdbcTemplate jt() {
        return new JdbcTemplate(ds());
    }
}