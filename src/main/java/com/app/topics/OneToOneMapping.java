package com.app.topics;

import com.app.entity.Passport;
import com.app.entity.Person;
import com.app.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOneMapping {

    public static void main(String[] args) {
        // saveToDB();
        fetchFromDB();
    }

    private static void fetchFromDB() {

        SessionFactory sessionfactory = HibernateUtils.getSessionfactory();
        Session session = sessionfactory.openSession();

        Person person = session.find(Person.class, 1);

        System.out.println(person.getName());
        System.out.println(person.getPassport());

        session.close();
        HibernateUtils.closeSessionFactory();
    }

    private static void saveToDB() {
        Person person = new Person();
        person.setName("Balaji");

        Passport passport = new Passport();
        passport.setPassportNumber("678912345");

        person.setPassport(passport);

        SessionFactory sessionfactory = HibernateUtils.getSessionfactory();

        Session session = sessionfactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(person);

        transaction.commit();

        session.close();
        HibernateUtils.closeSessionFactory();

        System.out.println(person);
    }


}
