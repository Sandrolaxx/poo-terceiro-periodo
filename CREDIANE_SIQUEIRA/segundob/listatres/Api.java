package CREDIANE_SIQUEIRA.segundob.listatres;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;

public class Api {

        private final Utils utils = new Utils();

        private String genToken() {
                try {
                        HttpClient client = HttpClient.newHttpClient();
                        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/token");

                        String params = "client_id="
                                        + URLEncoder.encode("41b44ab9a56440.teste.celcoinapi.v5",
                                                        StandardCharsets.UTF_8)
                                        + "&grant_type="
                                        + URLEncoder.encode("client_credentials", StandardCharsets.UTF_8)
                                        + "&client_secret="
                                        + URLEncoder.encode(
                                                        "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3",
                                                        StandardCharsets.UTF_8);

                        HttpRequest request = HttpRequest.newBuilder(uri)
                                        .header("Content-Type", "application/x-www-form-urlencoded")
                                        .POST(BodyPublishers.ofString(params))
                                        .build();

                        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

                        return utils.toJson(response.body()).get("access_token").toString();
                } catch (Exception error) {
                        error.printStackTrace();
                        return null;
                }

        }

        public String ListagemDeConvenios() {
                try {
                        HttpClient client = HttpClient.newHttpClient();
                        URI uri = new URI(
                                        "https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions?Type=ESTADUAL&UF=AC");

                        HttpRequest request = HttpRequest.newBuilder(uri)
                                        .header("Content-Type", "application/x-www-form-urlencoded")
                                        .header("Authorization", "Bearer " + genToken())
                                        .GET()
                                        .build();

                        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

                        return response.body();
                } catch (Exception error) {
                        error.printStackTrace();
                        return null;
                }

        }

        public String ConsultaDeBoletos(String linhadigitavel) {
                try {
                        HttpClient client = HttpClient.newHttpClient();
                        URI uri = new URI(
                                        "https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

                        String params = "{\"barCode\":{\"type\":0,\"digitable\":\"" + linhadigitavel + "\"}}";

                        HttpRequest request = HttpRequest.newBuilder(uri)
                                        .header("Content-Type", "application/json")
                                        .header("Authorization", "Bearer " + genToken())
                                        .POST(BodyPublishers.ofString(params))
                                        .build();

                        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

                        return response.body();
                } catch (Exception error) {
                        error.printStackTrace();
                        return null;
                }

        }
}
