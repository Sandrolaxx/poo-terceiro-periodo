package br.com.skafikis.services;

import br.com.skafikis.idetities.BarCode;
import br.com.skafikis.idetities.BarCodeRequest;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BoletoService {
    public static String consultBoleto(String externalTerminal, Long externalNSU, Integer type, String digitable) throws Exception {
        String token = GenerateAuthenticationToken.getToken();

        // Criando objs
        BarCode barCode = new BarCode(type,digitable);
        BarCodeRequest requestObject = new BarCodeRequest(externalTerminal, externalNSU,barCode);

        // Convertendo para JSON com Gson
        Gson gson = new Gson();
        String body = gson.toJson(requestObject);

        // Consumindo a API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .header("authorization", "Bearer " + token)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        // Enviando requisicao e gravando retorno
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Caso de errado uma exceção é lançada
        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro ao gerar token! Status: " + response.statusCode() + "\n Body:" + response.body());
        }  else {
            return response.body();
        }

    }
}
