package it.academy;

import java.sql.*;

public class Main {

    // 5 2012-06-10 1 3300 - Run - Edit configurations - arguments
    public static void main(String[] args) {

        String num = args[0];
        String paydate = args[1].replaceAll("-", "");
        String receiver = args[2];
        String value = args[3];

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/listexpenses?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "root"
            );
            final Statement statement = connection.createStatement();
            statement.executeUpdate("insert into expenses (num, paydate, receiver, value) " +
                    "values ((" + num + "), DATE (" + paydate + "), (" + receiver + "),(" + value + "))");

            final ResultSet resultSet = statement.executeQuery("select expenses.num, paydate, " +
                    "name, value from expenses, receivers\n" +
                    "where receiver = receivers.num;");

            while (resultSet.next()) {
                int resultNum = resultSet.getInt(1);
                Date resultData = resultSet.getDate(2);
                String resultReceiver = resultSet.getString(3);
                float resultValue = resultSet.getFloat(4);
                System.out.println("num = " + resultNum + " | data = " + resultData +
                        " | receiver = " + resultReceiver + " | value = " + resultValue);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}