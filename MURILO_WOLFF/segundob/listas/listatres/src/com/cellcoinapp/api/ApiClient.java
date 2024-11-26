package com.cellcoinapp.api;

import com.cellcoinapp.util.AuthUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiClient {
    public static String sendGetRequest(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");

        String token = AuthUtil.getBearerToken();
        connection.setRequestProperty("Authorization", "Bearer " + token);
        connection.setDoOutput(true);

        int responseCode = connection.getResponseCode();

        if (responseCode == 401) {
            throw new Exception("Não Autorizado: token Inválido");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String jsonResponse = response.toString();

        return jsonResponse;
    }

    public static String sendPostRequest(String urlString, String body) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");

        String token = AuthUtil.getBearerToken();
        connection.setRequestProperty("Authorization", "Bearer " + token);
        connection.setDoOutput(true);

        connection.getOutputStream().write(body.getBytes("UTF-8"));

        int responseCode = connection.getResponseCode();

        if (responseCode == 401) {
            throw new Exception("Não Autorizado: token Inválido");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String jsonResponse = response.toString();

        return jsonResponse;
    }

    public static String extractJsonField(String json, String field) {
        Pattern pattern = Pattern.compile("\"" + field + "\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(json);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}