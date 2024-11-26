package segundoB.org.json;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class cod {
   HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions?Type=ESTADUAL&UF=AC");
                private String token;
                HttpRequest request = HttpRequest.newBuilder(uri).header("Content-type", "application/json")
                        .header("Authorization", "Bearer " + token).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        return response.body();

    } 
}
