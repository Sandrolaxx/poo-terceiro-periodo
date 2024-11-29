package segundob.aulas.aulaquatro;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.swing.JOptionPane;

public class HttpSample {
    public static void main(String[] args) throws Exception {

        String moeda = JOptionPane.showInputDialog(null, "Informe a moeda", "Cotação", JOptionPane.INFORMATION_MESSAGE);
        //Nosso cliente http, precisamos para fazer request
        HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("http://economia.awesomeapi.com.br/json/USD" + moeda);

        //Parâmetros para a nossa requisição
        HttpRequest request = HttpRequest.newBuilder(uri).build(); 

        //Consumir a resposta
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString()); //Captura o JSON com o java (Recebe como String)

        //String resStr = response.body();

        return response.body();
    }
}
