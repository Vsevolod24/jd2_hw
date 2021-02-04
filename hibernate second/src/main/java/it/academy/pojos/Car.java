package it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String Id;

    @Column
    private String carType;

    @Column
    private String carName;

    @Column
    private Integer carPower;

    @Column
    private String carColor;

    public Car(int i, String sedan, String bmw, int i1, String pink, Information information) {
    }
}
