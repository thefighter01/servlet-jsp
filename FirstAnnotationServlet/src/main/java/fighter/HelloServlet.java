package fighter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = {"/go" , "/world" , "/fuck"})
@WebServlet(value = "/do")

public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Annotation</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello From the Diamond Dustion Porier</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}
