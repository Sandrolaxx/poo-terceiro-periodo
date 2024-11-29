package segundob.prova;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Testemunho {

    public String toString;

    public static String criarTestemunho() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("https://prova-poo-red.vercel.app/api/testimonial");
        String payload ="{\r\n" + //
                        "  \"imageUrl\": \"https://br.web.img3.acsta.net/c_310_420/pictures/16/05/17/17/28/208580.jpg\",\r\n" + //
                        "  \"description\": \"Tivemos muitos aprendizados, certamente minha compreensão sobre o conteúdo está mais apurada, agora compreendo minimamente conceitos de POO.\",\r\n" + //
                        "  \"ra\": \"202320291\"\r\n" + //
                        "}";
        HttpRequest request = HttpRequest.newBuilder(uri)
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(payload))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static String listarAlunos() throws Exception {

        HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("https://prova-poo-red.vercel.app/api/students");
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }

}
