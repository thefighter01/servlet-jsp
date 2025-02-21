package fighter.container;


import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SimpleWebContainer {
    private final int port;
    private final String configFileName;
    private HashMap<String , HttpServlet> handlers;

    public SimpleWebContainer(int port , String configFileName) {
        this.configFileName = configFileName;
        this.port = port;
        handlers = new HashMap<>();

    }

    private void start() throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);

        while(true) {
            Socket socket = serverSocket.accept();
            SocketHandler socketHandler = new SocketHandler(socket , handlers);
            socketHandler.start();

           

        }


    }

    private void loadPropertiesFile() {

        InputStream input = getClass().getClassLoader().getResourceAsStream(configFileName);

        if (input == null) {
            throw new RuntimeException("Could not find the file which is " + configFileName);
        }

        Properties prop = new Properties();
        try {
            prop.load(input);

            prop.forEach((key, value) -> {
                var servletObject = getServletInstance((String) value);
                servletObject.init();
                handlers.put((String)key , servletObject);
            });
            // we need to do custing because the type of these objects is Object
        }catch (IOException e) {
            System.err.print("Could not load properties file " + configFileName);
            e.printStackTrace();
        }

    }

    private HttpServlet getServletInstance(String className){
        try {
          return (HttpServlet)  Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        System.out.println("work ?!");

        SimpleWebContainer container = new SimpleWebContainer(8888 , "config.properties");

        try {
            container.loadPropertiesFile();

//           for (Map.Entry<String , HttpServlet> cur : container.handlers.entrySet()) {
//               HttpServlet servlet = cur.getValue();
//               String url = cur.getKey();
//               System.out.println(url + "   " + servlet.getClass().getName());
//           }

            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    container.handlers.forEach((url , servlet)->{
                        servlet.destroy();
                    });
                }
            });
          container.start();


        } catch (Exception e) {
            System.out.println("just catched the Exception");
        }
    }
}
