package fighter.container;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;

public class SocketHandler extends Thread{
    private Socket socket;
    private HashMap<String , HttpServlet> handlers;


    public SocketHandler(Socket socket , HashMap<String , HttpServlet> handlers) {
        this.handlers = handlers;
        this.socket = socket;
    }


    @Override
    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Request req = new Request(in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            if (!req.parse()){
                out.println("HTTP/1.1 500 Internal Server Error");
                out.println("Content-Type: text/plain");
                out.println();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>can't process your request </h1>");
                out.println("</body>");
                out.println("</html>");
                out.close();

            }


//            String line = in.readLine();
//
//            while (!line.isEmpty()) {
//                System.out.println(line);
//                line = in.readLine();
//            }
            // i need to take url from here and create an instance of the object in the map or throw exception if the value is not in the map

//            System.out.println("method is "+req.getMethod());
//            System.out.println("Path is "+req.getPath());
//
//            req.getRequestParams().forEach((key , value)->System.out.println("the key is " + key+" and the value is "+value));
//             System.out.println("//////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
//            req.getHeaders().forEach((key , value)->{
//                System.out.println("the key is "+key+" and the value is "+value);
//            });


            HttpServlet handler = handlers.get(req.getPath());

            if (handler != null) {

                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/html");
                out.println();
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<title>SimpleWebContainer</title>");
//                out.println("</head>");
//                out.println("<body>");
//                out.println("<h1>just container checking " + LocalDateTime.now() + "</h1>");
//                out.println("</body>");
//                out.println("</html>");
                Response res = new Response(socket.getOutputStream());
                handler.service(req, res);
                out.close();
                socket.close();
                in.close();

            }else {
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("HTTP/1.1 404 Not Found");
                out.println("Content-Type: text/html");
                out.println();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Erorr</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> there is no servlet handler for this path </h1>");
                out.println("</body>");
                out.println("</html>");
                out.close();
                socket.close();
                in.close();

            }
        }catch (Exception e) {
            System.out.print("Exception thrown in the run method of thread ");
            e.printStackTrace();
        }

    }
}
