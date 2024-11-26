package com.cellcoinapp.service;

import com.cellcoinapp.dto.BoletoDTO;
import com.cellcoinapp.api.ApiClient;
import javax.swing.*;

public class BoletoService {

    private static final String BOLETO_URL = "https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize";

    public BoletoDTO consultarBoleto(String linhaDigitavel) {
        try {
            String body = "{\"barCode\":{\"type\":0,\"digitable\":\"" + linhaDigitavel + "\"}}";
            String response = ApiClient.sendPostRequest(BOLETO_URL, body);
            String status = ApiClient.extractJsonField(response, "status");
            String vencimento = ApiClient.extractJsonField(response, "dueDate");
            String valor = ApiClient.extractJsonField(response, "value");

            if (status != null && vencimento != null && valor != null) {
                return new BoletoDTO(status, vencimento, valor);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar boleto: " + e.getMessage());
        }
        return null;
    }
}
