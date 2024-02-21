package technologies.internet.httpClient.tryCatch;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    public static void main(String[] args) {
        int requestedStatus = 424241;

        URI uri = URI.create("http://httpbin.org/status/" + requestedStatus);
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .version(HttpClient.Version.HTTP_1_1)
                .header("Accept", "text/html")
                .build();
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int status = response.statusCode();
            if (status >= 200 && status <= 299) {
                System.out.println("Success!!!");
            } else if (status >= 500 && status <= 599) {
                System.out.println("Failed :(");
            }

        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Incorrect URI");
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException("Ошибка во время выполнения");
        }
    }
}
