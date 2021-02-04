package it.academy.dao;

import it.academy.pojos.Car;
import it.academy.pojos.Person;
import it.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Dao implements IDao{

    @Override
    public void savePerson(Person person) {
        Session session = HibernateUtil.getSessionFactory();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void deletePerson(Integer id) {
        Session session = HibernateUtil.getSessionFactory();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.delete(person);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Incorrect ID");
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public Person getPersonId(Integer id) {
        Session session = HibernateUtil.getSessionFactory();
        Person person = session.get(Person.class, id);
        if (person == null) {
            throw new NullPointerException("Incorrect ID for any Person");
        }
        session.close();
        return person;
    }

    @Override
    public void savePersonCar(Car car) {
        Session session = HibernateUtil.getSessionFactory();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(car);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Incorrect type of car");
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
