package segundob.aulas.aulatres;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpSample {
    
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("https://economia.awesomeapi.com.br/json/last/BTC");

        HttpRequest request = HttpRequest.newBuilder(uri)
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        System.out.println(response.body());
    }

}
