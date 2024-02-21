package technologies.internet.httpClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        URI uri = URI.create("https://api.agify.io/?name=Alexey"); // параметр строки запроса - для доп информации,
        // видна пользователю
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("Accept", "application/json") // заголовок запроса - для служебной информации
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Answer in JSON format: " + response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
