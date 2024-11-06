import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.JOptionPane;


public class HttpSample {

    public static void main(String[] args ) throws URISyntaxException, IOException, InterruptedException {

        String moeda = JOptionPane.showInputDialog(
            null,
            "Digite a moeda que deseja consultar: ", 
            "Cotação de Moedas", 
            JOptionPane.QUESTION_MESSAGE);

        // Nosso cliente http, precisamos passar a URL
        HttpClient client = HttpClient.newHttpClient();

        // Criamos a URI, que é a URL que queremos acessar
        URI uri = URI.create("https://economia.awesomeapi.com.br/json/last/" + moeda);

        // Criamos a requisição, passando a URI
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();

        // Enviando a requisição e recebendo a resposta, o método send retorna um HttpResponse
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Imprimindo o corpo da resposta
        System.out.println(response.body());
    }
}