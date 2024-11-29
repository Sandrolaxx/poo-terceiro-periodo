package infra.api.Celcoin;

import data.protocols.Celcoin.IGenerateCelcoinToken;
import domain.exceptions.ComunicationException;
import infra.utils.JsonUtils;

import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.CompletionException;

public class GenerateCelcoinToken implements IGenerateCelcoinToken {

    private final String CLIENT_ID_HOMOLOG = "41b44ab9a56440.teste.celcoinapi.v5";
    private final String CLIENT_SECRET_HOMOLOG = "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3";
    private final String GRANT_TYPE_HOMOLOG = "client_credentials";

    public static String TOKEN = null;

    @Override
    public String getCelcoinToken() {
        if( isJWTValid(TOKEN) ) return TOKEN;

        StringBuilder params = new StringBuilder();

        params.append("client_id=").append(URLEncoder.encode(CLIENT_ID_HOMOLOG, StandardCharsets.UTF_8));
        params.append("&grant_type=").append(URLEncoder.encode(GRANT_TYPE_HOMOLOG, StandardCharsets.UTF_8));
        params.append("&client_secret=").append(URLEncoder.encode(CLIENT_SECRET_HOMOLOG, StandardCharsets.UTF_8));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.openfinance.celcoin.dev/v5/token"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(params.toString()))
                .build();

        try(HttpClient client = HttpClient.newHttpClient()) {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Map<String, Object> jsonData = JsonUtils.srtToMap(response.body());

            if (response.statusCode() == 400) {
                throw new ComunicationException("Erro de comunicação com API: "+ jsonData.get("message"));
            }
            if (response.statusCode() == 500) {
                throw new ComunicationException("Erro no servidor interno da API (500). Tente novamente mais tarde.");
            }


            TOKEN = jsonData.get("access_token").toString();
        }catch (ComunicationException e){
            throw new ComunicationException(e.getMessage());
        }catch(Exception e){
            throw new ComunicationException("Não foi possível comunicar-se com API: "+e.getMessage());
        }
        return TOKEN;
    }

    private boolean isJWTValid(String jwt){
        if(jwt == null) return false;

        String[] parts = jwt.split("\\.");
        if(parts.length < 2) return false; // Ensure payload exists

        String payload = parts[1];

        Base64.Decoder decoder = Base64.getUrlDecoder();
        String payloadJson;
        try {
            payloadJson = new String(decoder.decode(payload));
        } catch (IllegalArgumentException e) {
            // Invalid Base64 input
            return false;
        }

        Map<String, Object> jsonData = JsonUtils.srtToMap(payloadJson);
        if (jsonData == null || !jsonData.containsKey("exp")) return false;

        try {
            Object expObj = jsonData.get("exp");
            long expiration;
            if (expObj instanceof Number) {
                expiration = ((Number) expObj).longValue();
            } else if (expObj instanceof String) {
                expiration = Long.parseLong((String) expObj);
            } else {
                // Unsupported type for "exp"
                return false;
            }

            long now = System.currentTimeMillis() / 1000L;
            return expiration > now;
        } catch (NumberFormatException e) {
            // "exp" claim is not a valid number
            return false;
        }
    }
}
