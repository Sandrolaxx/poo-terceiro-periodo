package segundob.aulas.listas.listatres;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import segundob.aulas.RevisãoWeb.JSonUtils;

public class Integracao {

    public static String genToken() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/token");

        String params = "client_id=" + URLEncoder.encode("41b44ab9a56440.teste.celcoinapi.v5", StandardCharsets.UTF_8)
                + "&grant_type=" + URLEncoder.encode("client_credentials", StandardCharsets.UTF_8)
                + "&client_secret=" + URLEncoder.encode(
                        "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3", StandardCharsets.UTF_8);

        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(params))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Erro ao obter token: " + response.body());
        }

        return response.body();
    }

    public String consultarValores() throws Exception {
        // Obtém o token de autenticação
        Map<String, Object> json = JSonUtils.srtToMap(genToken());
        String token = json.get("access_token").toString();

        // Definindo o providerId fixo (exemplo: 2134 para Google Play ou Steam)
        int providerId = 2134;

        // URL da API com o providerId fixo
        HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/topups/provider-values?providerId=" + providerId); 

        // Requisição GET com o token de autenticação
        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        // Enviando a requisição e recebendo a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Erro ao consultar valores: " + response.statusCode() + " - " + response.body());
        }

        // Resposta da API
        String responseBody = response.body();

        // Concatenar providerId e statusCode
        StringBuilder resultado = new StringBuilder();
        resultado.append("providerId: ").append(providerId).append("\n");
        resultado.append("StatusCode: ").append(response.statusCode()).append("\n");

        // Aplicando o Regex para extrair valores específicos (ex: valores monetários)
        String regex = "\"value\":\\s*(\\d+\\.\\d{2})"; // Regex para capturar valores monetários
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(responseBody);

        while (matcher.find()) {
            resultado.append("Valor encontrado: ").append(matcher.group(1)).append("\n");
        }

        if (resultado.length() > 0) {
            // Exibir as informações completas no JOptionPane
            return resultado.toString();
        } else {
            return "Nenhum valor encontrado.";
        }
    }

    public String realizarRecarga(Double valor) throws Exception {
        Map<String, Object> json = JSonUtils.srtToMap(genToken());
        String token = json.get("access_token").toString();

        HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/topups");

        String payload = "{\r\n" +
                "  \"topupData\": {\r\n" +
                "    \"value\": " + valor + "\r\n" +
                "  },\r\n" +
                "  \"cpfCnpj\": \"19941206066\",\r\n" +
                "  \"providerId\": 2086,\r\n" +
                "  \"phone\": {\r\n" +
                "    \"stateCode\": 11,\r\n" +
                "    \"countryCode\": 55,\r\n" +
                "    \"number\": \"994114386\"\r\n" +
                "  }\r\n" +
                "}";

        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Erro ao realizar recarga: " + response.statusCode() + " - " + response.body());
        }

        return response.body();
    }
}
