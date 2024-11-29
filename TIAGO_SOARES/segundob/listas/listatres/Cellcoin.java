package segundob.listas.listatres;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Cellcoin {
    private final HttpClient client;
    private final String clientId;
    private final String clientSecret;
    private final Utils utils;

    public Cellcoin(){
        this.client = HttpClient.newHttpClient();
        this.clientId = "41b44ab9a56440.teste.celcoinapi.v5";
        this.clientSecret = "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3";
        this.utils = new Utils();
    }
    
    private String getAuthorization(){
        try {
            String urlParams = String.format(
                "client_id=%s&grant_type=client_credentials&client_secret=%s",
                clientId, clientSecret
            );

            Builder request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.openfinance.celcoin.dev/v5/token"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(urlParams));

            HttpResponse<String> response = client.send(request.build(), BodyHandlers.ofString());

            return utils.toJson(response.body()).get("access_token").toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get authentication", e);
        }
        
    }

    public String getConvenants(){
        try {
            HttpClient client = HttpClient.newHttpClient();

            Builder request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions?Type=ESTADUAL&UF=AC"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("authorization", "Bearer "+ getAuthorization())
                .GET();

            HttpResponse<String> response = client.send(request.build(), BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAccountData(String barcode){
        try {
            HttpClient client = HttpClient.newHttpClient();

            String params = "{\"barCode\":{\"type\":0,\"digitable\":\"" + barcode + "\"}}";

            Builder request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize"))
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .header("authorization", "Bearer "+ getAuthorization())
                .method("POST", HttpRequest.BodyPublishers.ofString(params));

            HttpResponse<String> response = client.send(request.build(), BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
