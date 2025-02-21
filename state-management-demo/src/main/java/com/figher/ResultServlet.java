package com.figher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.io.OptionalDataException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();



        // this part for request scope
//        String coach = (String) req.getAttribute("coach");
//        out.println("coach is " + coach);
//        String message = (String) req.getAttribute("message");
//        out.println("message is " + message);

        // this part for cookie
        Cookie[] cookies = req.getCookies();

        out.println("coach is " + getCookieValueByName(cookies , "coach").get());
        out.println("user is " + getCookieValueByName(cookies , "user").get());

    }

    private Optional<String> getCookieValueByName(Cookie [] cookies , String name){
        return Arrays.stream(cookies).filter(c -> c.getName().equals(name)).map(Cookie:: getValue).findAny();
    }
}
