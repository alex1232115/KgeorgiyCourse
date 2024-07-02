package technologies.internet;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class HelloHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("Началась обработка /hello");
        try (InputStream inputStream = exchange.getRequestBody();
             OutputStream outputStream = exchange.getResponseBody()
        ) {

            Headers requestHeaders = exchange.getRequestHeaders();
            System.out.println("Заголовки запроса: " + requestHeaders.entrySet());
            switch (exchange.getRequestMethod()) {
                case "POST" -> {
                    String body = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                    exchange.sendResponseHeaders(200, 0);
                    System.out.println("Тело запроса" + body);
                    outputStream.write(("Request body" + body).getBytes());
                }
                case "GET" -> {
                    URI requestURI = exchange.getRequestURI();
                    String path = requestURI.getPath();
                    String[] splitStrings = path.split("/");
                    String response = "Just example of response and name of hims is: " + splitStrings[2];
                    exchange.sendResponseHeaders(200, 0);
                    outputStream.write(response.getBytes());
                }
            }
        }
    }
}

