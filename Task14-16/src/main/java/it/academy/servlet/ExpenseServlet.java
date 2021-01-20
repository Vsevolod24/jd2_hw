package it.academy.servlet;

import it.academy.data.DaoFactory;
import it.academy.data.DatabaseName;
import it.academy.data.Expense;
import it.academy.data.ExpensesDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "expenseServlet", urlPatterns = "/task14")
public class ExpenseServlet extends HttpServlet {

    DaoFactory daoFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            daoFactory = DaoFactory.getInstance(DatabaseName.MYSQL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final PrintWriter writer = resp.getWriter();

        try {
            ExpensesDao expensesDao = daoFactory.getExpenseDao();
            final List<Expense> expenseList = expensesDao.readAll();
            for (Expense expense : expenseList) {
                writer.println("num = " + expense.getNum() + " paydate = " + expense.getPaydate() +
                        " receiver = " + expense.getReceiver() + " value = " + expense.getValue());
            }
        } catch (Exception e) {
            writer.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}