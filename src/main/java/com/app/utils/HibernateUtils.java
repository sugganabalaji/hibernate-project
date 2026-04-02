package com.app.utils;

import com.app.entity.Laptop;
import com.app.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sf = new Configuration()
            .addAnnotatedClass(Student.class)
            .addAnnotatedClass(Laptop.class)
            .configure()
            .buildSessionFactory();

    public static SessionFactory getSessionfactory() {
        return sf;
    }

    public static void closeSessionFactory() {
        sf.close();
    }
}
