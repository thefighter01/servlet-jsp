package fighter.container;

public abstract class HttpServlet {
    public void init(){
        System.out.println("HttpServlet init method default implementation");
    }

    public void service(Request req, Response res){
        String method = req.getMethod();

        if (method.equals("GET")){
            this.doGet(req, res);
        }else if (method.equals("POST")){
            this.doPost(req, res);
        }else{
            throw new RuntimeException("Method not supported");
        }
    }

    public void doGet(Request req, Response res){
        System.out.println("HttpServlet doGet default implementation");
    }

    public void doPost(Request req, Response res){
        System.out.println("HttpServlet doPost default implementation");
    }


    public void destroy(){
        System.out.println("HttpServlet destroy default implementation");
    }
}
