package com.fighter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LoginServlet extends HttpServlet {


    public LoginServlet() {
        System.out.println("LoginServlet constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Loginervlet init() method is called rightnow");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>LoginServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>LoginServlet and time is "+ LocalDateTime.now()+ "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
        System.out.println("LoginServlet destroy() method is called rightnow");
    }
}
