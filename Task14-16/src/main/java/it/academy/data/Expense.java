package it.academy.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Expense implements Serializable {

    private int num;
    private Date paydate;
    private String receiver;
    private double value;

    public Expense() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public double getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return num == expense.num &&
                Double.compare(expense.value, value) == 0 &&
                paydate.equals(expense.paydate) &&
                receiver.equals(expense.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, paydate, receiver, value);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "num=" + num +
                ", paydate=" + paydate +
                ", receiver='" + receiver + '\'' +
                ", value=" + value +
                '}';
    }
}