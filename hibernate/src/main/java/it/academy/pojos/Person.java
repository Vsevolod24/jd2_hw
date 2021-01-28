package it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "P_ID")
    private Integer id;
    @Column(name = "P_AGE")
    private Integer age;
    @Column(name = "P_Name")
    private String name;
    @Column(name = "P_Surname")
    private String surname;

    public Person(Object id, Integer age, String name, String surname) {
    }
}
