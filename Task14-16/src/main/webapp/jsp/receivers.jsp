<%@ page import="java.util.List" %>
<%@ page import="it.academy.data.Expense" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>Task15</title>
</head>

<body>
<div>
      <h1>expenses</h1>
</div>

<div>
<div>
<%
        List<Expense> expenseList = (List<Expense>) request.getAttribute("expense");
        for (Expense expense : expenseList) {
        out.println("<li>" + "num= " + expense.getNum() + " paydate= " + expense.getPaydate() +
        " receiver= " + expense.getReceiver() + " value= " + expense.getValue() + "</li>");
        }
%>
</div>
</div>

</body>
</html>