package fighter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/initParamsAnnotaion" , initParams = {
        @WebInitParam(name = "title" , value = "Init Parameters annotaion demo")
        ,@WebInitParam(name = "configStyle" , value = "annotaion")
})
public class InitParamsAnnotationServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Init ParamsAnnotationServlet   " + config.getServletContext().getInitParameter("author"));
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
        out.println("<hr>");
        out.println("author is "+getServletContext().getInitParameter("author"));
        out.println("<br><br>");
        out.println("father is "+ getServletContext().getInitParameter("father"));

        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
