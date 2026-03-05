package task;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Task4 {
    public static void solve() throws IOException, InterruptedException {
        try (var client = HttpClient.newHttpClient()) {
            var request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/get"))
                    .build();
            System.out.println("Отправка запроса...");
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            var objectMapper = new ObjectMapper();
            var json = objectMapper.readTree(response.body());
            var host = json.get("headers").get("Host").asText();
            System.out.println(host);
        }
    }
}