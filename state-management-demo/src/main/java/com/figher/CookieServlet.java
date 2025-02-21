package com.figher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie c = new Cookie("user" , "fighter");
        c.setMaxAge(10 * 60);

        resp.addCookie(c);

        Cookie c2 = new Cookie("coach" , "dustinPorier");
        resp.addCookie(c2);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>CookieServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<a href=\"result\">Go to Result Servlet </a>");

        out.println("</body>");
        out.println("</html>");
        out.flush();


    }
}
