package it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Information implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "INF_ID")
    private String town ;

    @Column(name = "INF_ADRESS")
    private String adress;

    @Column(name = "INF_AGE")
    private Integer age;


}
