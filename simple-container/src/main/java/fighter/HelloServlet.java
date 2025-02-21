package fighter;

import fighter.container.HttpServlet;
import fighter.container.Request;
import fighter.container.Response;

import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {


    @Override
    public void init(){
        System.out.println("Hello Servlet init() called ................");
    }


    @Override
    public void doGet(Request req, Response res){
        System.out.println("Hello Servlet doGet() called ................");
        PrintWriter out = res.getprintWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>doGet method in Hello World Servlet </h1>");
        out.println("</body>");
        out.println("</html>");
        out.flush();

    }

    @Override
    public void doPost(Request req, Response res){
        System.out.println("Hello Servlet doPost");
    }

    @Override
    public void destroy(){
        System.out.println("Hello Servlet destroy");
    }



}
