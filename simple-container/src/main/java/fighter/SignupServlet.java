package fighter;

import fighter.container.HttpServlet;
import fighter.container.Request;
import fighter.container.Response;

import java.io.PrintWriter;

public class SignupServlet extends HttpServlet {

    @Override
    public void init(){
        System.out.println("SignupServlet init() called..............................");
    }

    @Override
    public void doGet(Request request, Response response){
        PrintWriter out = response.getprintWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SignupServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>SignupServlet</h1>");
        out.println("<form method=\"post\">" +
                "  <label for=\"fname\">First name:</label><br>\n" +
                "  <input type=\"text\" id=\"fname\" name=\"fname\" value=\"mahmoud\"><br>\n" +
                "  <label for=\"lname\">Last name:</label><br>\n" +
                "  <input type=\"text\" id=\"lname\" name=\"lname\" value=\"hasan\"><br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form>");
        out.println("</body>");
        out.println("</html>");
        out.flush();

    }

    @Override
    public void doPost(Request request, Response response){
        PrintWriter out = response.getprintWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>doPostSignupServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>doPostSignupServlet</h1>");
        out.println(request.getRequestParam("fname") + " <br><br> " + request.getRequestParam("lname"));
        out.println("</body>");
        out.println("</html>");
        out.flush();


    }

    @Override
    public void destroy(){
        System.out.println("SignupServlet destroy() cleanup resources ");
    }
}
