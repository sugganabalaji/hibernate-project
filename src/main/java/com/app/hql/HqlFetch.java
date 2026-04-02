package com.app.hql;

import com.app.entity.Laptop;
import com.app.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HqlFetch {

    public static void main(String[] args) {

        SessionFactory sessionfactory = HibernateUtils.getSessionfactory();

        Session session = sessionfactory.openSession();

        // SELECT * FROM laptop - SQL
        // FROM Laptop - HQL

        session.createQuery("FROM Laptop", Laptop.class)
                .list()
                .forEach(System.out::println);

        /*Query query = session.createQuery("FROM Laptop", Laptop.class);
        List<Laptop> laptops = query.getResultList();
        laptops.forEach(System.out::println);*/

        session.close();

        HibernateUtils.closeSessionFactory();
    }
}
