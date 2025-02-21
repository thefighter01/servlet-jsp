package fighter.container;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Response {

    private PrintWriter printWriter;

    private OutputStream outputStream;
    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.printWriter = new PrintWriter(outputStream);
    }

    public PrintWriter getprintWriter() {
        return printWriter;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}
