package it.academy.pojos;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@FixMethodOrder
public class PersonPojosTest {

    private SessionFactory factory;

    private StandardServiceRegistry registry;

    @Before
    public void setUp() {
        registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.test.xml").build();
        factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    public void personCreate() {
        Person person = new Person(1, 35, "Yuli", "Slabko");

        Session session = factory.openSession();
        Transaction tx = null;
        Serializable id = null;
        try {
            tx = session.beginTransaction();
            id = session.save(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        assertNotNull(id);
    }

    @Test
    public void personDelete() {
        Session session = factory.openSession();
        Person person = session.get(Person.class, 1);
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        assertNull(session.get(Person.class, 1));
        session.close();
    }

    @After
    public void tearDown() throws Exception {
        factory.close();
    }
}
