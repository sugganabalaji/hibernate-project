package com.app.curd;

import com.app.entity.Student;
import com.app.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersistData {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setSId(5);
        s1.setsName("Save");
        s1.setMarks(21);

        SessionFactory sessionfactory = HibernateUtils.getSessionfactory();

        Session session = sessionfactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(s1);

        transaction.commit();

        session.close();
        HibernateUtils.closeSessionFactory();

        System.out.println(s1);
    }

}