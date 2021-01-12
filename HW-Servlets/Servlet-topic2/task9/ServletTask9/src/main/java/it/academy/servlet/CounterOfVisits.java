package it.academy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CounterOfVisits extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = Path.of("D:\\HW Servlets\\Servlet-topic2\\task9\\ServletTask9\\counter.txt");
        String num = Files.readString(path, StandardCharsets.UTF_8);
        int count = Integer.parseInt(num);
        count++;
        final PrintWriter writer = resp.getWriter();
        writer.println("Visits = " + count);
        Files.writeString(path, String.valueOf(count));
    }
}
