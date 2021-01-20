package it.academy.data;

import java.io.Serializable;
import java.util.Objects;

public class Receivers implements Serializable {

    private int num;
    private String name;

    public Receivers() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receivers receivers = (Receivers) o;
        return num == receivers.num && Objects.equals(name, receivers.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, name);
    }

    @Override
    public String toString() {
        return "Receivers{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}