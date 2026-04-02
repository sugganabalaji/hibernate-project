package com.app.utils;

import com.app.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sf = new Configuration()
            .addAnnotatedClass(Student.class)
            .addAnnotatedClass(Laptop.class)
            .addAnnotatedClass(Person.class)
            .addAnnotatedClass(Passport.class)
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(Order.class)
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public static SessionFactory getSessionfactory() {
        return sf;
    }

    public static void closeSessionFactory() {
        sf.close();
    }
}
