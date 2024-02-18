package technologies.internet;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HelloHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("Началась обработка /hello");
        try (InputStream inputStream = exchange.getRequestBody();
             OutputStream outputStream = exchange.getResponseBody())
        {
            if (exchange.getRequestMethod().equals("POST")) {
                String body = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                System.out.println("Тело запроса" + body);
                outputStream.write(("Тело запроса" + body).getBytes());
            } else if (exchange.getRequestMethod().equals("GET")) {
                String response = "Just example of response";
                outputStream.write(response.getBytes());
            }
        }
        exchange.sendResponseHeaders(200, 0);
    }
}

