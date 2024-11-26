package com.cellcoinapp.service;

import com.cellcoinapp.dto.ConvenioDTO;
import com.cellcoinapp.api.ApiClient;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ConvenioService {
    private static final String CONVENIO_URL = "https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions?Type=ESTADUAL&UF=AC";

    public List<ConvenioDTO> listarConvenios() {
        List<ConvenioDTO> convenios = new ArrayList<>();
        try {
            String response = ApiClient.sendGetRequest(CONVENIO_URL);
            for (int i = 0; i < 10; i++) {
                String nome = ApiClient.extractJsonField(response, "Nomeconvenant");
                String uf = ApiClient.extractJsonField(response, "statesconvenant");
                String codigo = ApiClient.extractJsonField(response, "mask");
                if (nome != null && codigo != null) {
                    convenios.add(new ConvenioDTO(nome, uf, codigo));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar convênios: " + e.getMessage());
        }
        return convenios;
    }
}
