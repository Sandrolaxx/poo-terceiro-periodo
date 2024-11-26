package ERICK_SCUR.segundob.listas.lista3;

import javax.swing.*;
import java.net.http.*;
import java.net.URI;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConveniosApp {

    private static final String BASE_URL = "https://sandbox.openfinance.celcoin.dev/v5";
    private static final String LIST_AGREEMENTS_ENDPOINT = "/transactions/institutions";
    private static final String BILLPAYMENTS_AUTHORIZE_ENDPOINT = "/transactions/billpayments/authorize";
    private static final String AUTH_TOKEN = "Bearer TOKEN";

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Listar Convênios", "Consultar Boleto", "Sair"};
            String selection = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha uma opção:",
                    "Menu",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (selection == null || selection.equals("Sair")) {
                JOptionPane.showMessageDialog(null, "Encerrando o sistema.");
                break;
            }

            switch (selection) {
                case "Listar Convênios":
                    listarConvenios();
                    break;
                case "Consultar Boleto":
                    consultarBoleto();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }

    private static void listarConvenios() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            URI uri = URI.create(BASE_URL + LIST_AGREEMENTS_ENDPOINT + "?type=ESTADUAL&UF=AC");
            HttpRequest request = HttpRequest.newBuilder(uri)
                    .header("Authorization", AUTH_TOKEN)
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject jsonResponse = new JSONObject(response.body());
                JSONArray convenants = jsonResponse.getJSONArray("convenants");
                StringBuilder output = new StringBuilder("Convênios Listados:\n\n");

                for (int i = 0; i < convenants.length(); i++) {
                    JSONObject convenant = convenants.getJSONObject(i);
                    output.append("Nome: ").append(convenant.getString("Nomeconvenant")).append("\n")
                            .append("Tipo: ").append(convenant.getString("Tipoconvenant")).append("\n")
                            .append("UF: ").append(convenant.getString("statesconvenant")).append("\n")
                            .append("Máscara: ").append(convenant.getString("mask")).append("\n")
                            .append("Limite de Horário: ").append(convenant.getString("timeLimit")).append("\n\n");
                }

                JOptionPane.showMessageDialog(null, output.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao listar convênios: " + response.body());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar requisição: " + e.getMessage());
        }
    }

    private static void consultarBoleto() {
        try {
            String linhaDigitavel = JOptionPane.showInputDialog("Digite a linha digitável do boleto:");

            if (linhaDigitavel == null || linhaDigitavel.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Linha digitável não informada.");
                return;
            }

            HttpClient client = HttpClient.newHttpClient();
            URI uri = URI.create(BASE_URL + BILLPAYMENTS_AUTHORIZE_ENDPOINT);
            String requestBody = """
                    {
                        "externalTerminal": "terminal123",
                        "externalNSU": 123456,
                        "barCode": {
                            "type": 0,
                            "digitable": "%s"
                        }
                    }
                    """.formatted(linhaDigitavel);

            HttpRequest request = HttpRequest.newBuilder(uri)
                    .header("Authorization", AUTH_TOKEN)
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject jsonResponse = new JSONObject(response.body());
                JSONObject registerData = jsonResponse.getJSONObject("registerData");
                String output = String.format(
                        """
                        Dados do Boleto:
                        Beneficiário: %s
                        Pagador: %s
                        Vencimento: %s
                        Valor Original: %.2f
                        Valor Atualizado: %.2f
                        """,
                        registerData.getString("recipient"),
                        registerData.getString("payer"),
                        registerData.getString("payDueDate"),
                        registerData.getDouble("originalValue"),
                        registerData.getDouble("totalUpdated")
                );

                JOptionPane.showMessageDialog(null, output);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar boleto: " + response.body());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar requisição: " + e.getMessage());
        }
    }
}