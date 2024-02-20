package technologies.internet.makeAPI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class HelloHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("Началась обработка /hello");
        try (InputStream inputStream = exchange.getRequestBody();
             OutputStream outputStream = exchange.getResponseBody()) {

            switch (exchange.getRequestMethod()) {
                case "POST" -> {
                    exchange.sendResponseHeaders(200, 0);
                    String[] splitURI = exchange.getRequestURI().getPath().split("/");
                    String body = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                    List<String> contentTypeValues = exchange.getRequestHeaders().get("X-Wish-Good-Day");

                    if (contentTypeValues != null && contentTypeValues.contains("true")) {
                        outputStream.write((body + ", " + splitURI[2] + " " + splitURI[3] + "! Good day to you").getBytes());
                    } else {
                        outputStream.write((body + ", " + splitURI[2] + " " + splitURI[3]).getBytes());
                    }
                }
                case "GET" -> {
                    String response = "Greetings!";
                    exchange.sendResponseHeaders(200, 0);
                    outputStream.write(response.getBytes());
                }
                default -> {
                    exchange.sendResponseHeaders(401, 0);
                    outputStream.write("Некорректный метод".getBytes());
                }
            }
        }
    }
}

