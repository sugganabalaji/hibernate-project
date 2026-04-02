package com.app.curd;

import com.app.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteData {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

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
        sf.close();
    }

}