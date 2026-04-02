package com.app.topics;

import com.app.entity.Laptop;
import com.app.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetVsLoad {

    public static void main(String[] args) {

        SessionFactory sessionfactory = HibernateUtils.getSessionfactory();

        Session session = sessionfactory.openSession();

        // for difference check console
        // session.get(Laptop.class, 1L); // EAGER loading
        // session.load(Laptop.class, 1L); // LAZY loading - depricated
        // Laptop laptop = session.byId(Laptop.class).getReference(1L); // LAZY Loading - deprecated
        Laptop laptop = session.getReference(Laptop.class, 1L); // LAZY Loading
        System.out.println(laptop);

        session.close();
        HibernateUtils.closeSessionFactory();



    }
}
