package technologies.internet;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HelloHandler implements HttpHandler {

    public static final String NAME = "hello";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("Начать обработка /hello");

        String response = "Just example of response";
        exchange.sendResponseHeaders(200, 0);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
