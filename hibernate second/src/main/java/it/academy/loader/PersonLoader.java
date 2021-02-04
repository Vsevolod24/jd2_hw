package it.academy.loader;

import it.academy.dao.Dao;
import it.academy.pojos.Car;
import it.academy.pojos.Information;
import it.academy.pojos.Person;
import it.academy.util.HibernateUtil;

import javax.persistence.EntityManager;

public class PersonLoader {

    public static void main(String[] args) throws Exception {

        Person person = new Person(null, 35, "Yuli", "Slabko");
        Dao dao = new Dao();
//        EntityManager em = HibernateUtil.getEntityManager();
//        em.getTransaction().begin();
//        em.persist(person);
//
//        Information personInformation = new Information();
//        em.persist(personInformation);
//        personInformation.setTown("Urgada");
//        personInformation.setAdress("Albania");
//        personInformation.setAge(28);
//
//        em.getTransaction().commit();
//        HibernateUtil.close();

        Car car = new Car();
        car.setCarName("Nissan");
        car.setCarType("Sedan");
        car.setCarPower(122);
        car.setCarColor("Grey");

        Car car1 = new Car(1, "Sedan", "BMW", 200, "pink",
                new Information("Moscow", "Asanalieva", 22));

        dao.savePersonCar(car1);

    }
}
