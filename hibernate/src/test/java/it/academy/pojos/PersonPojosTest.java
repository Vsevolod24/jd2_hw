package it.academy.pojos;

import it.academy.loader.PersonLoaderTest;
import it.academy.util.HibernateUtil;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonPojosTest implements PersonLoaderTest {


    public void save(Person person) {
        Session session = HibernateUtil.getSessionFactory();
        // session.setFlushMode(FlushMode.ALWAYS);
        //'setFlushMode(org.hibernate.FlushMode)' is deprecated
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Person person) {
        Session session = HibernateUtil.getSessionFactory();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(person);
            tx.commit();
        }catch (Exception ex){
            if(tx != null) tx.rollback();
            throw ex;
        }finally {
            session.close();
        }
    }


    @Override
    public Person getId(Integer id) {
        Session session = HibernateUtil.getSessionFactory();
        Person person = session.get(Person.class, id);
        if(person != null)
            throw new NullPointerException();
        session.close();
        return person;
    }

}
