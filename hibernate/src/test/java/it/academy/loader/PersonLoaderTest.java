package it.academy.loader;

import it.academy.pojos.Person;

public interface PersonLoaderTest{

    void save(Person person);

    void delete(Person person);

    Person getId(Integer id);

}
