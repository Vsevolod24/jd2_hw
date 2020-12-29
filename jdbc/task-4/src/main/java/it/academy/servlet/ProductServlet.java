package it.academy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Product", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            final Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/product?serverTimezone=UTC",
                    "root",
                    "root");
            final Statement statement = connection.createStatement();

            final ResultSet resultSet = statement.executeQuery("select product_spec.id,\n" +
                    " product_spec.product_name, \n" +
                    " product_spec_price.product_spec_price\n" +
                    " from product_spec, product.product_spec_price\n" +
                    " where product_spec.id = product_spec_price.product_spec_id;");
            final PrintWriter writer = resp.getWriter();
            while(resultSet.next()){
                resultSet.getInt(1);
                String name = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                System.out.printf("id=" + " name=" + name + "price=" + price);
                writer.println("id=" + " name=" + name + "price=" + price);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}