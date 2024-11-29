package segundob.listas.listatres;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.swing.JOptionPane;


public class CelcoinBassRepository implements IBassRepository {

    @Override
    public String consultarBoleto(String linhaDigitavel) throws Exception {
        Map<String, Object> json = Json.srtToMap(gerarToken());
        String token = json.get("access_token").toString();

        HttpClient client = HttpClient.newHttpClient();
    URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

    String payload = "{\r\n" +
   "  \"barCode\": {\r\n" +
   "    \"type\": 0,\r\n" +
   "    \"digitable\": " +
   linhaDigitavel  +
   "  }\r\n" +
   "}";

        HttpRequest request = HttpRequest.newBuilder(uri)
        .header("Content-Type", "application/json")
        .header("Authorization", "Bearer " + token)
        .POST(BodyPublishers.ofString(payload))
        .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return response.body();

    }


    @Override
    public String listarConvenios() throws Exception {

    Map<String, Object> json = Json.srtToMap(gerarToken());
    String token = json.get("access_token").toString();


    String typeInput = JOptionPane.showInputDialog(
            null,
            "Informe o tipo do convênio:\n1 - Nacional\n2 - Estadual",
            "Tipo de Convênio",
            JOptionPane.INFORMATION_MESSAGE
    );

    int type = Integer.parseInt(typeInput); 
    
    if (type == 1) {
  
        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions?Type=NACIONAL");
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        return response.body();

    } else if (type == 2) {

        String uF = JOptionPane.showInputDialog(
                null,
                "Digite a UF (Ex.: SP, RJ):",
                "Unidade Federativa",
                JOptionPane.INFORMATION_MESSAGE
        );

        uF = uF.toUpperCase(); 
        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions?Type=ESTADUAL&UF=" + uF);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        return response.body();

    } else {
      
        throw new IllegalArgumentException("Opção inválida. Escolha 1 para Nacional ou 2 para Estadual.");
    }
}

    
    @Override
public String gerarToken() throws Exception {
    HttpClient client = HttpClient.newHttpClient();
    URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/token");
    String params = "client_id=" + URLEncoder.encode("41b44ab9a56440.teste.celcoinapi.v5", StandardCharsets.UTF_8)
            + "&grant_type=" + URLEncoder.encode("client_credentials", StandardCharsets.UTF_8)
            + "&client_secret=" + URLEncoder.encode(
                    "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3", StandardCharsets.UTF_8);

    HttpRequest request = HttpRequest.newBuilder(uri)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .POST(BodyPublishers.ofString(params))
            .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    return response.body();
}

}
