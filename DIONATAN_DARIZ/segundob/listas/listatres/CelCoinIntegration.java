import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.management.monitor.StringMonitor;
import javax.swing.border.StrokeBorder;

public class CelCoinIntegration {
    public String genTokenRequst() throws URISyntaxException, IOException, InterruptedException{
        // URI do endpoint
        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/token");

        // Parâmetros da requisição
        String params = "client_id=" + URLEncoder.encode("41b44ab9a56440.teste.celcoinapi.v5", StandardCharsets.UTF_8) +
                        "&grant_type=" + URLEncoder.encode("client_credentials", StandardCharsets.UTF_8) +
                        "&client_secret=" + URLEncoder.encode("e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3", StandardCharsets.UTF_8);

        
        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(params)) // Correção aqui
                .build();

        
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        //System.out.println(response.body().toString());
       
        return response.body();
    }

    public String getToken() throws URISyntaxException, IOException, InterruptedException {
        Map<String,Object> jsonMap = JSONutil.getChaveValor(genTokenRequst());
        String token = jsonMap.get("access_token").toString();
        return token;
    }

    public String listarConvenios(String tipo, String UF) throws URISyntaxException, IOException, InterruptedException {
        tipo = "ESTADUAL";
        UF =  "AC";

        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/" + "institutions?Type=" + tipo + "&UF=" + UF);

        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("authorization", "Bearer " + Main.token)
                .GET() // Correção aqui
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        return response.body().toString();
    }
    

    public String consultarBoleto(String numeroDoBoleto) throws URISyntaxException, IOException, InterruptedException {
        String str = "{\r\n  \"barCode\": {\r\n    \"type\": 0,\r\n    \"digitable\": \"%s\"\r\n  }\r\n}".formatted(numeroDoBoleto);

        System.out.println(str);

        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Content-Type", "application/json")
                .header("authorization", "Bearer " + Main.token)
                .POST(HttpRequest.BodyPublishers.ofString(str)) 
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.toString());

        return response.body().toString();
    }
    
}