package it.academy.dao;

import it.academy.pojos.Car;
import it.academy.pojos.Person;

public interface IDao {

    void savePerson(Person person);

    void deletePerson(Integer id);

    Person getPersonId(Integer id);

    void savePersonCar(Car car);
}
