package com.figher;

import com.figher.model.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/attributedemo")
public class AttributeDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // HttpServeltRequest
        // HttpSession
        // ServletContext

        req.setAttribute("myName" , "mahmoud");

        String myName = (String )req.getAttribute("myName");

        System.out.println("myName is " + myName);

        HttpSession session = req.getSession();
        session.setAttribute("SpringInternals", "read Some books");
        String springInternals = (String) session.getAttribute("SpringInternals");
        System.out.println("springInternals is " + springInternals);

        session.setAttribute("user" , new User("fighter" , "mahmoud"));

        User user = (User) session.getAttribute("user");
        System.out.println("user is " + user);


        ServletContext servletContext = getServletContext();

        servletContext.setAttribute("coach" , "dustin Porier");

        System.out.println((String) servletContext.getAttribute("coach"));

        session.removeAttribute("user");
        servletContext.removeAttribute("coach");
        req.removeAttribute("myName");



    }
}
