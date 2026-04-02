package com.app.curd;

import com.app.entity.Student;
import com.app.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UpdateData {

    public static void main(String[] args) {

        Student  s1 = new Student();
        s1.setSId(4);
        s1.setsName("Denim");
        s1.setMarks(28);

        SessionFactory sessionfactory = HibernateUtils.getSessionfactory();

        Session session = sessionfactory.openSession();

        Transaction transaction = session.beginTransaction();

        Student merged = session.merge(s1);

        transaction.commit();
        session.close();
        HibernateUtils.closeSessionFactory();

        System.out.println(merged);
    }

}