package com.app.hql;

import com.app.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HqlFetchNotStar_2 {

    public static void main(String[] args) {

        SessionFactory sessionfactory = HibernateUtils.getSessionfactory();

        Session session = sessionfactory.openSession();

        // SELECT model FROM laptop - SQL
        // SELECT model FROM Laptop - HQL

        session.createQuery("SELECT model, configurations.processor FROM Laptop", String[].class)
                .list()
                .forEach(s -> System.out.println(s[0] + ", " + s[1]));

        /*Query query = session.createQuery("SELECT model FROM Laptop", String.class);
        List<String> laptops = query.getResultList();
        System.out.println(laptops);*/

        session.close();

        HibernateUtils.closeSessionFactory();
    }
}
