package DIONATAN_DARIZ.segundob.aulas.aulacinco;

import java.io.IOError;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;

public class HttpSample {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        
        public static String getValorCotacao(String moeda) throw Exception{
        
        //Nosso cliente https, precisamos para fazer request
        HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("https://economia.awesomeapi.com.br/last/USD-BRL,EUR-BRL,BTC-BRL,")

        //Parametros da nossa requisição

        HttpRequest request = HttpRequest.newBuilder(uri)
            .build();

        //Consumir a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }
        public static String ChaveValor(String jsonBody){


        }


        
    }
}
