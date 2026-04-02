package com.app.topics;

import com.app.entity.Customer;
import com.app.entity.Order;
import com.app.entity.Passport;
import com.app.entity.Person;
import com.app.utils.HibernateUtils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class OneToManyMapping {

    public static void main(String[] args) {
        // saveToDB();
        fetchFromDB();
    }

    private static void fetchFromDB() {

        SessionFactory sessionfactory = HibernateUtils.getSessionfactory();
        Session session = sessionfactory.openSession();

        Customer person = session.find(Customer.class, 2);

        System.out.println(person.getCustomerName());
        System.out.println(person.getOrders());

        session.close();
        HibernateUtils.closeSessionFactory();
    }

    private static void saveToDB() {
        Customer cust = new Customer();
        cust.setCustomerName("Balaji");

        Order o1 = new Order();
        o1.setProductName("Mobile");
        o1.setPrice(10_000);

        Order o2 = new Order();
        o2.setProductName("Laptop");
        o2.setPrice(50_000);

        o1.setCustomer(cust);
        o2.setCustomer(cust);

        cust.setOrders(List.of(o1, o2));

        SessionFactory sessionfactory = HibernateUtils.getSessionfactory();

        Session session = sessionfactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(cust);

        transaction.commit();

        session.close();
        HibernateUtils.closeSessionFactory();

        System.out.println(cust);
    }


}
