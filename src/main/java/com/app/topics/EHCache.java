package com.app.topics;

import com.app.entity.Laptop;
import com.app.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EHCache {

    public static void main(String[] args) {

        SessionFactory sessionfactory = HibernateUtils.getSessionfactory();

        System.out.println("====== Level-1 Cache (Session Cache) ======");
        System.out.println("Session-1:");
        Session session1 = sessionfactory.openSession();
        // 1st time Hitting DB
        Laptop laptop1 = session1.find(Laptop.class, 1L);
        System.out.println("1st Query: " + laptop1);
        // 2nd time not hitting DB (L1 cache)
        Laptop laptop2 = session1.find(Laptop.class, 1L);
        System.out.println("2nd Query (from L1 cache): " + laptop2);
        session1.close();
        System.out.println();

        System.out.println("====== Level-2 Cache (EHCache) ======");
        System.out.println("Session-2:");
        Session session2 = sessionfactory.openSession();
        // 1st time in new session - hits DB but stored in L2 cache
        Laptop lap1 = session2.find(Laptop.class, 1L);
        System.out.println("1st Query in new session (from L2 cache): " + lap1);
        // 2nd time not hitting DB (L1 cache of session2)
        Laptop lap2 = session2.find(Laptop.class, 1L);
        System.out.println("2nd Query in same session (from L2 cache): " + lap2);
        session2.close();
        System.out.println();

        System.out.println("Session-3:");
        Session session3 = sessionfactory.openSession();
        // Not hitting DB - comes from L2 cache (EHCache)
        Laptop lap3 = session3.find(Laptop.class, 1L);
        System.out.println("Query in another new session (from L2 cache): " + lap3);
        session3.close();

        HibernateUtils.closeSessionFactory();

    }
}
