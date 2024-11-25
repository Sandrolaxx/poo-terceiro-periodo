import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.BodySubscriber;

public class HttpSample {

    public static void main(String[] args ) throws URISyntaxException, IOException, InterruptedException {

        String moeda = JOptionPane.showInputDialog(
            null,
            "Digite a moeda que deseja consultar (USD, EUR, BTC, etc):", 
            "Cotação de Moedas", 
            JOptionPane.INFORMATION_MESSAGE);

            String jsonRespostaCotacao = getValorCotacao(moeda);

            Map <String, String> mapJson = getChaveValor(jsonRespostaCotacao);

            JOptionPane.showMessageDialog(
                null, 
                mapJson.get("bid"), 
                "Valor Moeda " + moeda, 0);
    }

    public static String getValorCotacao(String moeda) throws URISyntaxException, IOException, InterruptedException {
        
        // Nosso cliente HTTP, que faz a requisição e recebe a resposta
        HttpClient client = HttpClient.newHttpClient();

        // A URI que vamos acessar para obter a cotação da moeda desejada (dólar, euro, etc)
        URI uri = new URI("https://economia.awesomeapi.com.br/json/last/" + moeda);

        // A requisição que vamos fazer para a URI
        HttpRequest request = HttpRequest.newBuilder(uri)
            .GET()
            .build();
        
        // A resposta que vamos receber da requisição
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return response.body();
    }

    public static Map<String, String> getChaveValor(String jsonBody) {

        Pattern pattern = Pattern.compile("\\\"(\\w+)\\\":\\\"([^\\\"]+)\\\"");
        Matcher matcher = pattern.matcher(jsonBody);

        Map<String, String> mapJson = new HashMap<>();

        while (matcher.find()) {

            String chave = matcher.group(1);
            String valor = matcher.group(2);

            mapJson.put(chave, valor);
        }

        return mapJson;
    }
}