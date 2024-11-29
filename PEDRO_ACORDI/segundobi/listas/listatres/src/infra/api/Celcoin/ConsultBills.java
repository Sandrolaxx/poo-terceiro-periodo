package infra.api.Celcoin;

import data.protocols.Celcoin.IConsultBills;
import data.protocols.Celcoin.IGenerateCelcoinToken;
import domain.DTO.ConsultBillsDTO;
import domain.entities.BarCode;
import domain.exceptions.ComunicationException;
import infra.utils.JsonUtils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultBills implements IConsultBills {

    private final IGenerateCelcoinToken generateCelcoinToken;

    public ConsultBills(IGenerateCelcoinToken generateCelcoinToken) {
        this.generateCelcoinToken = generateCelcoinToken;
    }

    @Override
    public String consultBills(ConsultBillsDTO dto) throws IllegalAccessException {
        String token = generateCelcoinToken.getCelcoinToken();
        String json = JsonUtils.toJson(dto);


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize"))
                .header("authorization", "Bearer "+token)
                .header("content-type", "application/json")
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        String result = null;

        try(HttpClient httpClient = HttpClient.newHttpClient()){
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            Map<String, Object> jsonData = JsonUtils.srtToMap(response.body());

            if(response.statusCode() == 400){
                throw new ComunicationException("Erro de comunicação com API: "+ jsonData.get("message"));
            }
            if(response.statusCode() == 401){
                throw new ComunicationException("Erro de comunicação com API: Token utilizado é inválido");
            }
            if(response.statusCode() == 500){
                throw new ComunicationException("Erro no servidor interno da API (500). Tente novamente mais tarde.");
            }

            result = showBillData(jsonData);

        }catch(ComunicationException e){
            throw new ComunicationException(e.getMessage());
        }catch (Exception e){
            throw new RuntimeException("Erro: "+e.getMessage());
        }
        return result;
    }

    private String showBillData(Map<String, Object> jsonData) {
        Map<String, Object> registerData = (Map<String, Object>) jsonData.get("registerData");
        StringBuilder sb = new StringBuilder();

        // Definindo a largura total da caixa
        int totalWidth = 46; // Ajuste conforme necessário
        int labelWidth = 24; // Espaço reservado para as etiquetas (incluindo espaços)
        int valueWidth = totalWidth - 4 - labelWidth; // 4 para bordas e espaçamento

        // Ajustando totalWidth se necessário para acomodar valores mais longos
        int maxValueLength = getMaxValueLength(registerData);
        if (maxValueLength + labelWidth + 4 > totalWidth) {
            totalWidth = maxValueLength + labelWidth + 4;
            valueWidth = totalWidth - 4 - labelWidth;
        }

        String horizontalLine = "═";
        String topBorder = "╔" + repeat(horizontalLine, totalWidth - 2) + "╗\n";
        String title = "║" + centerText("Detalhes da Conta", totalWidth - 2) + "║\n";
        String separator = "╠" + repeat(horizontalLine, totalWidth - 2) + "╣\n";

        sb.append(topBorder);
        sb.append(title);
        sb.append(separator);

        // Adicionando cada linha de dados com alinhamento consistente
        sb.append(formatLine("Cedente", jsonData.get("assignor"), labelWidth, valueWidth));
        sb.append(formatLine("Recebedor", registerData.get("recipient"), labelWidth, valueWidth));
        sb.append(formatLine("Documento do Recebedor", registerData.get("documentRecipient"), labelWidth, valueWidth));
        sb.append(formatLine("Pagador", registerData.get("payer"), labelWidth, valueWidth));
        sb.append(formatLine("Documento do Pagador", registerData.get("documentPayer"), labelWidth, valueWidth));
        sb.append(formatLine("Válido até", registerData.get("payDueDate"), labelWidth, valueWidth));
        sb.append(formatLine("Valor de desconto", registerData.get("discountValue"), labelWidth, valueWidth));
        sb.append(formatLine("Multa calculada", registerData.get("fineValueCalculated"), labelWidth, valueWidth));
        sb.append(formatLine("Valor original", registerData.get("originalValue"), labelWidth, valueWidth));
        sb.append(formatLine("Total Atualizado", registerData.get("totalUpdated"), labelWidth, valueWidth));
        sb.append(formatLine("Total pago", registerData.get("totalValuePaid"), labelWidth, valueWidth));

        // Adicionando a borda inferior
        String bottomBorder = "╚" + repeat(horizontalLine, totalWidth - 2) + "╝\n";
        sb.append(bottomBorder);

        return sb.toString();
    }

    // Método auxiliar para repetir caracteres
    private String repeat(String s, int count) {
        return new String(new char[count]).replace("\0", s);
    }

    // Método auxiliar para centralizar texto
    private String centerText(String text, int width) {
        if (text.length() >= width) {
            return text.substring(0, width);
        }
        int padding = (width - text.length()) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padding; i++) sb.append(" ");
        sb.append(text);
        while (sb.length() < width) sb.append(" ");
        return sb.toString();
    }

    // Método auxiliar para formatar cada linha com alinhamento consistente
    private String formatLine(String label, Object value, int labelWidth, int valueWidth) {
        String labelWithColon = "  " + label + ":";
        int spacesAfterLabel = labelWidth - labelWithColon.length();
        if (spacesAfterLabel < 1) spacesAfterLabel = 1; // Garantir pelo menos um espaço
        String spaces = repeat(" ", spacesAfterLabel);
        String formattedValue = String.format("%-" + valueWidth + "s", value.toString());
        return "║" + labelWithColon + spaces + formattedValue + " ║\n";
    }

    // Método auxiliar para encontrar o valor máximo de comprimento
    private int getMaxValueLength(Map<String, Object> registerData) {
        int max = 0;
        for (Object value : registerData.values()) {
            if (value != null) {
                int length = value.toString().length();
                if (length > max) {
                    max = length;
                }
            }
        }
        // Verificar também o assignor
        Object assignor = registerData.get("assignor");
        if (assignor != null) {
            int length = assignor.toString().length();
            if (length > max) {
                max = length;
            }
        }
        return max;
    }
}
