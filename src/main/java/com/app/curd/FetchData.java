package com.app.curd;

import com.app.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Student student = session.find(Student.class, 2);

        session.close();
        sf.close();

        System.out.println(student);
    }

}