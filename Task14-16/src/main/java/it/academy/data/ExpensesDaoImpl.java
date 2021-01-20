package it.academy.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExpensesDaoImpl implements ExpensesDao{

    private final Connection connection;

    public ExpensesDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Expense expense) {

    }

    @Override
    public Expense read(int id) {
        return null;
    }

    @Override
    public List<Expense> readAll() {
        ArrayList<Expense> expenseList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select expenses.num, paydate, name, value " +
                     "from expenses,receivers where receiver=receivers.num")) {
            while (resultSet.next()) {
                Expense expense = new Expense();
                expense.setNum(resultSet.getInt("num"));
                expense.setPaydate(resultSet.getDate("paydate"));
                expense.setReceiver(resultSet.getString("name"));
                expense.setValue(resultSet.getFloat("value"));
                expenseList.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenseList;
    }

    @Override
    public void update(Expense expense) {

    }

    @Override
    public void delete(Expense expense) {

    }
}