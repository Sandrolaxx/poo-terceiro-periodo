package segundob.listas.prova;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class Podre {

    // Método para listar alunos
    protected static void listarAlunos() {
        try {
            // URL da API para listar alunos
            String url = "https://prova-poo-red.vercel.app/api/students";

            // Criar a requisição HTTP GET
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Ler a resposta
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Exibindo os alunos no dialog
            String responseText = response.toString();

            JOptionPane.showMessageDialog(null, responseText.toString(), "Lista de Alunos",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar alunos: " + e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    protected static void enviarTestemunho() {
        try {
            // Solicita ao usuário o RA e o testemunho
            String ra = JOptionPane.showInputDialog("Digite seu RA:");
            String mensagem = JOptionPane.showInputDialog("Digite seu testemunho:");

            // URL da imagem (fixa ou pode ser entrada do usuário)
            String imageUrl = "https://br.web.img3.acsta.net/c_310_420/pictures/16/05/17/17/28/208580.jpg";

            // Criando o corpo da requisição manualmente (payload JSON)
            String payload = "{\n" +
                    "\t\"imageUrl\": \"" + imageUrl + "\",\n" +
                    "\t\"ra\": \"" + ra + "\",\n" +
                    "\t\"description\": \"" + mensagem + "\"\n" +
                    "}";

            // URL da API para enviar testemunho
            String url = "https://prova-poo-red.vercel.app/api/testimonial";

            // Criando a requisição HTTP POST
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            // Enviando o corpo da requisição
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = payload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Processando a resposta do servidor
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    JOptionPane.showMessageDialog(null, "Testemunho enviado com sucesso!\nResposta: " + response,
                            "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(connection.getErrorStream(), "utf-8"))) {
                    StringBuilder errorResponse = new StringBuilder();
                    String errorLine;
                    while ((errorLine = br.readLine()) != null) {
                        errorResponse.append(errorLine.trim());
                    }
                    JOptionPane.showMessageDialog(null,
                            "Erro ao enviar testemunho.\nCódigo: " + responseCode + "\nErro: " + errorResponse, "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception e) {
            // Exibindo erro
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao enviar testemunho: " + e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
