package it.academy.application;

import it.academy.pojos.Child;
import it.academy.pojos.Person;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(value = "it.academy.pojos", includeFilters =
        {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Child.class, Person.class})})

public class Application {


}
