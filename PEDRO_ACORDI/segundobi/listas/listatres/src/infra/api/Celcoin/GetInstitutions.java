package infra.api.Celcoin;

import data.protocols.Celcoin.IGenerateCelcoinToken;
import data.protocols.Celcoin.IGetInstitutions;
import domain.exceptions.ComunicationException;
import infra.utils.JsonUtils;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class GetInstitutions implements IGetInstitutions {

    private final IGenerateCelcoinToken tokenGenerator;

    public GetInstitutions(IGenerateCelcoinToken tokenGenerator) {
        this.tokenGenerator = tokenGenerator;
    }

    @Override
    public String getInstitutions() {
        String token = tokenGenerator.getCelcoinToken();
        String typeParam = "ESTADUAL";
        String ufParam = "PR";


        String queryParams = String.format("Type=%s&UF=%s",
                URLEncoder.encode(typeParam, StandardCharsets.UTF_8),
                URLEncoder.encode(ufParam, StandardCharsets.UTF_8)
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions?"+queryParams))
                .header("accept", "application/json")
                .header("authorization", "Bearer "+token)
                .GET()
                .build();
        String result = null;
        try( HttpClient httpClient = HttpClient.newHttpClient() ) {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 401){
                throw new ComunicationException("As credenciais para comunicação com API não estão corretas.");
            }
            if(response.statusCode() == 500){
                throw new ComunicationException("Ocorreu um erro de comunicação externo. Por favor, tente novamente mais tarde.");
            }
            List<Map<String, Object>> jsonData = JsonUtils.arrayToMap(response.body(), "convenants");
            result = formatArray(jsonData);
        }catch(ComunicationException e){
            throw new ComunicationException(e.getMessage());
        }catch (Exception e){
            throw new RuntimeException("Erro: "+e.getMessage());
        }

        return result;
    }

    private String formatArray(List<Map<String, Object>> jsonData){
        StringBuilder builder = new StringBuilder();

        for(Map<String,Object> element : jsonData){
            builder.append("--------\n");
            builder.append("Convênio: ").append(element.get("Nomeconvenant")).append("\n");
            builder.append("Tipo de Convênio: ").append(element.get("Tipoconvenant")).append("\n");
            builder.append("Hora limite de Pagamento/Emissão de Boletos: ").append(element.get("timeLimit")).append("\n");
        }
        return builder.toString();
    }
}
