package com.app.curd;

import com.app.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersistData {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setSId(5);
        s1.setsName("Save");
        s1.setMarks(21);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(s1);

        transaction.commit();

        session.close();
        sf.close();

        System.out.println(s1);
    }

}