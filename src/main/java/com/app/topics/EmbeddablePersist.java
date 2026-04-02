package com.app.topics;

import com.app.entity.Configurations;
import com.app.entity.Laptop;
import com.app.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
import java.text.ParseException;

public class EmbeddablePersist {
    
    public static void main(String[] args) {

        Configurations config = getConfigurations();
        Laptop laptop = new Laptop();
        laptop.setOwner("Balaji");
        laptop.setBrand("LENOVO");
        laptop.setModel("IDEAPAD Slim 3i");
        laptop.setCost(65000);
        laptop.setPurchasedOn(parseDate("26.03.2026"));
        laptop.setWarrantyTill(parseDate("25.03.2027"));
        laptop.setPurchasedFrom("Swatha Computer IT park, Vijayawada");

        laptop.setConfigurations(config);

        SessionFactory sessionfactory = HibernateUtils.getSessionfactory();

        Session session = sessionfactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(laptop);

        transaction.commit();

        session.close();
        HibernateUtils.closeSessionFactory();

        System.out.println(laptop);
    }

    private static Configurations getConfigurations() {
        Configurations config = new Configurations();
        config.setProcessor("13th Gen Intel(R) Core(TM) i5-13420H (2.10 GHz)");
        config.setRamSize("16.0 GB (15.7 GB usable)");
        config.setDeviceId("DF378620-FE71-4C7F-ACD5-BC3DFA212209");
        config.setProductId("00342-42773-84302-AAOEM");
        config.setSystemType("64-bit operating system, x64-based processor");
        config.setPenAndTouch("No pen or touch input is available for this display");
        config.setStorageSize(512);
        config.setOs("Windows 11 Home Single Language");
        config.setOsBuild("26100.8037");
        config.setVersion("24H2");
        config.setInstalledOn(parseDate("26.03.2026"));
        config.setExperience("Windows Feature Experience Pack 1000.26100.300.0");
        config.setSerialNumber("PF5MY46E");
        return config;
    }

    private static java.util.Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
