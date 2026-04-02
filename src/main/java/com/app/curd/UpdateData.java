package com.app.curd;

import com.app.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {

    public static void main(String[] args) {

        Student  s1 = new Student();
        s1.setSId(4);
        s1.setsName("Denim");
        s1.setMarks(28);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        Student merged = session.merge(s1);

        transaction.commit();
        session.close();
        sf.close();

        System.out.println(merged);
    }

}