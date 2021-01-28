package it.academy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static SessionFactory factory;

    public static final EntityManagerFactory emFactory;
    static{
        emFactory = Persistence.createEntityManagerFactory("it.academy");
    }

    public static EntityManager getEntityManager(){
        return emFactory.createEntityManager();
    }

    public static void close(){
        emFactory.close();
    }

    public static Session getSessionFactory() {
        return factory.openSession();
    }


}
