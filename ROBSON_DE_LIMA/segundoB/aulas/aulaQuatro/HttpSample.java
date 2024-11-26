package segundoB.aulas.aulaQuatro;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpSample {
    
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //cliente http precisa para fazer request
        HttpClient cliente = HttpClient.newHttpClient();
        URI uri = new URI("https://economia.awesomeapi.com.br/json/last/USD");

        HttpRequest request = HttpRequest.newBuilder(uri).build();

        cliente.send(request, BodyHandlers.ofString());
        HttpResponse<String>response = cliente.send(request, BodyHandler.ofString());

        System.out.println(response.body());
        
    }
}
