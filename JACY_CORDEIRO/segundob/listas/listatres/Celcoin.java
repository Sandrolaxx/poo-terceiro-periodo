package segundob.listas.listatres;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;


public class Celcoin {
    private final Utils utils = new Utils();

    private String pegarAutenticacao() throws Exception {

        try {
            HttpClient client = HttpClient.newHttpClient();
            URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/token");
    
            String params = "client_id=" + URLEncoder.encode("41b44ab9a56440.teste.celcoinapi.v5", StandardCharsets.UTF_8) + "&grant_type=" + URLEncoder.encode("client_credentials", StandardCharsets.UTF_8)
            + "&client_secret=" + URLEncoder.encode("e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3", StandardCharsets.UTF_8);
          
            HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(BodyPublishers.ofString(params))
                .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    
            return utils.srtoMAP(response.body()).get("access_token").toString();   
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
            
    }
    
    public String listarConvenio() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions?Typ=ESTADUAL&UF=AC");
        
            HttpRequest request = HttpRequest.newBuilder(uri)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .header("authorization", "Bearer "+ pegarAutenticacao())
            .GET()
            .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            return response.body();   
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public String consultarBoleto(String linhaDigitavel) {

        try {
            HttpClient client = HttpClient.newHttpClient();
            URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");
    
            String params = "{\"barCode\":{\"type\":0,\"digitable\":\"" + linhaDigitavel+ "\"}}";
            
            HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Content-Type", "application/json")
                .header("authorization", "Bearer "+ pegarAutenticacao())
                .POST(BodyPublishers.ofString(params))
                .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    
            return response.body();   
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }

        
            
    }
}