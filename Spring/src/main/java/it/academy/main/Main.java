package it.academy.main;

import it.academy.application.Application;
import it.academy.pojos.Child;
import it.academy.pojos.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        Child child = context.getBean(Child.class);
        Person person = context.getBean(Person.class);
        System.out.println(child);
        System.out.println(person);

    }
}
