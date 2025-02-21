package com.fighter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.*;
public class SignupServlet extends HttpServlet {


    public SignupServlet() {
        System.out.println("SignupServlet constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("SignupServlet init() method is called rightnow");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SignupServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>SignupServlet and time is "+ LocalDateTime.now()+ "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
        System.out.println("SignupServlet destroy() method is called rightnow");
    }

}
