package fighter.container;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Request {

    private BufferedReader in;

    private String method , path;

    private Map<String, String> headers;

    private Map<String, String> requestParams;


    public Request(BufferedReader in) {
        this.in = in;
        headers = new HashMap<String, String>();
        requestParams = new HashMap<>();

    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getRequestParams() {
        return requestParams;
    }

    private void parseRequestParams(String queryString) {
        //usr=mahmoud&pass=123&

        for (String pair : queryString.split("&")) {
            String [] pairArray = pair.split("=");
           requestParams.put(pairArray[0], pairArray[1]);
        }

    }

    public String getRequestParam(String key) {
        return requestParams.getOrDefault(key , "not existed");
    }

    public boolean parse() throws IOException {
        String line = in.readLine();
        // get /hello?user=sex http/1.1
        // get /hello http/1.1

        String []firstLineArray = line.split(" ");

        if (firstLineArray.length != 3) {
            return false;
        }

        method = firstLineArray[0];
        String url = firstLineArray[1];
        int index = url.lastIndexOf("?");

        if (index == -1 ){
            path = url;
            // not exist
        }else {
            path = url.substring(0, index);
            parseRequestParams(url.substring(index+1));

        }

        while (!line.isEmpty()) { // this turn for request header
            line = in.readLine(); // request headers
            if (line.isEmpty()) {
                break;
            }
            String [] headerPair = line.split(":");
            headers.put(headerPair[0], headerPair[1]);
        }

        // TODO: parse post request body info into requestParameters

        if ("POST".equals(method)) {
            StringBuilder body = new StringBuilder();
            while (in.ready()) {
                body.append( (char)in.read() );

            }
          //  System.out.println(body.toString());
            parseRequestParams(body.toString());

        }


        return true;
    }
}
