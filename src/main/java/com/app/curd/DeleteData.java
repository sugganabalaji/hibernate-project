package com.app.curd;

import com.app.entity.Student;
import com.app.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DeleteData {

    public static void main(String[] args) {

        SessionFactory sessionfactory = HibernateUtils.getSessionfactory();

        Session session = sessionfactory.openSession();

        Transaction transaction = session.beginTransaction();

        Student student = session.find(Student.class, 5);

        if(student != null) {
            session.remove(student);
            transaction.commit();
            System.out.println("Record deleted successfully");
        } else {
            System.out.println("Record not found");
        }
        session.close();
        HibernateUtils.closeSessionFactory();
    }

}