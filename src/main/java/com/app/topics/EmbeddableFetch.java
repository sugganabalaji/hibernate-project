package com.app.topics;

import com.app.entity.Laptop;
import com.app.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmbeddableFetch {

    public static void main(String[] args) {
        SessionFactory sessionfactory = HibernateUtils.getSessionfactory();

        Session session = sessionfactory.openSession();

        Laptop laptop = session.find(Laptop.class, 1);

        session.close();

        HibernateUtils.closeSessionFactory();

        System.out.println(laptop);
    }

}
