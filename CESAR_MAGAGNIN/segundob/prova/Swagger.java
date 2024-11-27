package segundob.prova;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import javax.swing.JOptionPane;

public class Swagger {

    //Listar alunos
    public static String consultarAlunos()throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("https://prova-poo-red.vercel.app/api/students");
        
        HttpRequest request = HttpRequest.newBuilder(uri)
            .header("accept", "application/json").GET()
            .build();
       
        HttpResponse <String> response = client.send(request, BodyHandlers.ofString());
      
        return response.body();
    }

    //Realizar testemunho
    public static String realizarTestemunho(String testemunhoLoad2)throws Exception{
        
        HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("https://prova-poo-red.vercel.app/api/testimonial");

        String url = JOptionPane.showInputDialog(null,"Insira URL da imagem","Enviar testemunho",JOptionPane.INFORMATION_MESSAGE);
        String imageUrl = url;
        String valor = JOptionPane.showInputDialog(null,"Digite um RA valido","Enviar testemunho",JOptionPane.INFORMATION_MESSAGE);
        String ra = valor;
        String frase = JOptionPane.showInputDialog(null,"Digite uma lamentação","Enviar testemunho",JOptionPane.INFORMATION_MESSAGE);
        String description = frase;
        String testemunhoLoad = "{\n" + //
                               "  \"imageUrl\": \""+imageUrl+ "\",\n" + //
                               "  \"description\": \""+description+"\",\n" + //
                               "  \"ra\": \""+ra+"\"\n" + //
                               "}";
        
        HttpRequest request = HttpRequest.newBuilder(uri)
            .header("Content-type", "application/json")
            .header("accept", "application/json")
            .POST(BodyPublishers.ofString(testemunhoLoad))
            .build();

        HttpResponse <String> response = client.send(request, BodyHandlers.ofString());

        return response.body();
    }

}