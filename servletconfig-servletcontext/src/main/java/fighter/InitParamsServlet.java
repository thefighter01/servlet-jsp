package fighter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class InitParamsServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet InitParamsServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet InitParamsServlet</h1>");
        System.out.println(getServletConfig());
        out.println("title is " + getServletConfig().getInitParameter("title"));
        out.println("<br><br>");
        out.println("configStyle is " + getInitParameter("configStyle"));

        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
