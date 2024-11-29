package com.cellcoinapp.util;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class AuthUtil {
    private static final String TOKEN_URL = "https://sandbox.openfinance.celcoin.dev/v5/token";
    private static final String CLIENT_ID = "41b44ab9a56440.teste.celcoinapi.v5";
    private static final String CLIENT_SECRET = "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3";
    private static final String GRANT_TYPE = "client_credentials";

    public static String getBearerToken() throws Exception {
        String token = null;
        URL url = new URL(TOKEN_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);

        String body = "client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&grant_type=" + GRANT_TYPE;
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = body.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try (Scanner scanner = new Scanner(new InputStreamReader(connection.getInputStream()))) {
            String response = scanner.useDelimiter("\\A").next();
            token = response.split(":")[1].split("\"")[1].replaceAll("[\"]", "").trim();
        }

        return token;
    }
}
