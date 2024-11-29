package segundob.listas.listatres;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import segundob.aulas.aulacinco.JsonUtils;

public class CelcoinIntegration {
        
        //geração de token
    
        public static String genToken() throws Exception {
            HttpClient client = HttpClient.newHttpClient();
            URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/token");
            String params = "client_id=" + URLEncoder.encode("41b44ab9a56440.teste.celcoinapi.v5", StandardCharsets.UTF_8) + 
            "&grant_type=" + URLEncoder.encode("client_credentials", StandardCharsets.UTF_8) + 
            "&client_secret=" + URLEncoder.encode("e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3", StandardCharsets.UTF_8);
    
            HttpRequest request = HttpRequest.newBuilder(uri)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .POST(BodyPublishers.ofString(params))
            .build();
    
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    
            return response.body();
        }

        //Realizar recarga
    public String realizarRecarga(Double valor) throws Exception{
        Map<String, Object> json = JsonUtils.srtToMap(genToken());
        String token = json.get("access_token").toString();

        HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/topups");

        String payload = "{\n" + //
                        "\t\"topupData\": {\n" + //
                        "\t\t\"value\": \n" + valor + //
                        "\t},\n" + //
                        "\t\"cpfCnpj\": \"19941206066\",\n" + //
                        "\t\"providerId\": 2134,\n" + //
                        "\t\"phone\": {\n" + //
                        "\t\t\"stateCode\": 11,\n" + //
                        "\t\t\"countryCode\": 55,\n" + //
                        "\t\t\"number\": \"994114386\"\n" + //
                        "\t}\n" + //
                        "}";

        HttpRequest request = HttpRequest.newBuilder(uri)
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer " + token)
            .POST(BodyPublishers.ofString(payload))
            .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}